package com.epam.dao.impl;

import com.epam.dao.CrewDAO;
import com.epam.db.DBManager;
import com.epam.dto.CrewDTO;
import com.epam.entity.Crew;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyCrewDAO implements CrewDAO {
    private static final String SQL_SHOW_ALL_CREW = "SELECT c.id, c.flight_id, c.pilot, c.navigator, c.radio_opeartor, c.first_conductor, c.second_conductor, c.is_permitted\n\nFROM crew c  INNER JOIN crew_man cm\n    ON  c.pilot = cm.id;"; //WHERE C.is_permitted=0
    private static final String SQL_SHOW_TIME_ADMISSION_CREW = "SELECT date_from, date_to\nFROM crew_man_admission\nWHERE crew_man_id=?;";
    private static final String SQL_GET_TIME_FLIGHT = "SELECT departure_time, landing_time\nFROM flight\nWHERE id=?;";
    private static final String SQL_INSERT_NEW_CREW = "INSERT INTO crew\nVALUES (DEFAULT ,?,?,?,?,?,?,DEFAULT );";
    private static final String SQL_INSERT_CREW_ADMISSION = "INSERT INTO crew_man_admission\nVALUES (DEFAULT ,?,?,0,?);";
    private static final String SQL_ACCEPT_CREW_ADMISSION = "UPDATE crew\nSET is_permitted=1\nWHERE flight_id=?;";
    private static final String SQL_REJECT_CREW_ADMISSION = "DELETE FROM crew\nWHERE flight_id=?;";

    @Override
    public void newCrew(Connection connection, Crew crew, int flightId) {
        try {
            PreparedStatement ps = connection.prepareCall(SQL_INSERT_NEW_CREW);
            int k = 1;
            ps.setInt(k++, flightId);
            ps.setInt(k++, crew.getPilot());
            ps.setInt(k++, crew.getNavigator());
            ps.setInt(k++, crew.getRadio_operator());
            ps.setInt(k++, crew.getFirst_conductor());
            ps.setInt(k, crew.getSecond_conductor());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Crew> showAllCrew(Connection connection) {
        List<Crew> crewList = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con;
        try {
            con = connection;
            st = con.createStatement();
            rs = st.executeQuery(SQL_SHOW_ALL_CREW);
            while (rs.next()) {
                crewList.add(extractAllCrews(rs));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crewList;
    }

    private void addCrewAdmission(Connection connection, List<Integer> list, int flightId) {
        Timestamp[] timestamps = timeFlight(connection, flightId);
        for (Integer i : list) {
            try {
                PreparedStatement ps = connection.prepareCall(SQL_INSERT_CREW_ADMISSION);
                int k = 1;
                ps.setTimestamp(k++, timestamps[0]);
                ps.setInt(k++, i);
                ps.setTimestamp(k, timestamps[1]);
                ps.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void acceptAdmission(Connection connection, int flightId, String decision){
        PreparedStatement ps;
        try {
            if (decision.equals("Ok")) {
                ps = connection.prepareCall(SQL_ACCEPT_CREW_ADMISSION);
            }else {
                ps = connection.prepareCall(SQL_REJECT_CREW_ADMISSION);
            }
            ps.setInt(1, flightId);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private boolean timeAdmission(Connection connection, int crewMainId, int flightId) {
        Timestamp[] admissionTime = new Timestamp[2];
        PreparedStatement ps;
        ResultSet rs;
        Connection con = null;
        try {
            con = connection;
            ps = con.prepareCall(SQL_SHOW_TIME_ADMISSION_CREW);
            ps.setInt(1, crewMainId);
            rs = ps.executeQuery();
            while (rs.next()) {
                admissionTime[0] = rs.getTimestamp(1);
                admissionTime[1] = rs.getTimestamp(2);
            }
            con.commit();
            return validateTime(admissionTime, timeFlight(connection, flightId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean validateTime(Timestamp[] admissionTime, Timestamp[] timestamps) {
        if (admissionTime[0] == null || admissionTime[1] == null) {
            return true;
        }
        for (int i = 0; i < timestamps.length; i++) {
            if (timestamps[i].getTime() >= (admissionTime[0].getTime()) && timestamps[i].getTime() <= (admissionTime[1]).getTime()) {
                return false;
            }
        }
        return true;
    }

    private Timestamp[] timeFlight(Connection connection, int flightId) {
        Timestamp[] time = new Timestamp[2];
        PreparedStatement ps;
        ResultSet rs;
        Connection con = null;
        try {
            con = connection;
            ps = con.prepareCall(SQL_GET_TIME_FLIGHT);
            ps.setInt(1, flightId);
            rs = ps.executeQuery();
            while (rs.next()) {
                time[0] = rs.getTimestamp(1);
                time[1] = rs.getTimestamp(2);
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return time;
    }

    public Crew fillCrew(CrewDTO crewDTO) {
        Crew crew = new Crew();
        crew.setId(crewDTO.getId());
        crew.setFlight_id(crewDTO.getFlight_id());
        crew.setPilot(crewDTO.getPilot());
        crew.setNavigator(crewDTO.getNavigator());
        crew.setRadio_operator(crewDTO.getRadio_operator());
        crew.setFirst_conductor(crewDTO.getFirst_conductor());
        crew.setSecond_conductor(crewDTO.getSecond_conductor());
        System.out.println(crew);
        return crew;
    }

    Crew extractAllCrews(ResultSet rs) throws SQLException {
        Crew crew = new Crew();
        crew.setId(rs.getInt("id"));
        crew.setFlight_id(rs.getInt("flight_id"));
        crew.setPilot(rs.getInt("pilot"));
        crew.setNavigator(rs.getInt("navigator"));
        crew.setRadio_operator(rs.getInt("radio_opeartor"));
        crew.setFirst_conductor(rs.getInt("first_conductor"));
        crew.setSecond_conductor(rs.getInt("second_conductor"));
        System.out.println(crew);
        return crew;
    }

    public String validate(Crew crew, List<Integer> list, int flightId) {
        String result = "OK";
        if (crew.getFirst_conductor() == crew.getSecond_conductor()) {
            result = "You can not choose the same stewardess";
        }
        for (int i : list) {
            if (!timeAdmission(DBManager.getInstance().getConnection(), i, flightId)) {
                result = "Illegal time for employees";
            }
        }
        if (result.equals("OK")) {
            newCrew(DBManager.getInstance().getConnection(), crew, flightId);
            addCrewAdmission(DBManager.getInstance().getConnection(), list, flightId);
        }
        return result;
    }
}
