package com.epam.dao.impl;

import com.epam.dao.FlightDAO;
import com.epam.db.Fields;
import com.epam.dto.FlightDTO;
import com.epam.entity.Airport;
import com.epam.entity.Flight;
import com.epam.entity.Search;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyFlightDAO implements FlightDAO {
    private static final String SQL_SHOW_ALL_FLIGHTS = "SELECT f.id, f.number, p.boarding_number AS model_id, a.name AS departure_airport, f.departure_time, b.name\nAS landing_airport, f.landing_time\n FROM flight f INNER JOIN plane p\nON f.plane_id = p.id\nINNER JOIN airport a\nON f.departure_airport_id = a.id\nINNER JOIN airport b\nON f.landing_airport_id = b.id;";
    private static final String SQL_FLIGHTS_FOR_CREATE="SELECT f.number, p.model_id AS id, p.boarding_number AS model_id, a.name AS departure_airport, b.name\nAS landing_airport\n FROM flight f INNER JOIN plane p\nON f.plane_id = p.id\nINNER JOIN airport a\nON f.departure_airport_id = a.id\nINNER JOIN airport b\nON f.landing_airport_id = b.id;";
    private static final String SQL_INSERT_NEW_FLIGHT="INSERT INTO flight\nVALUES(DEFAULT ,?,?,?,?,?,?)";
    private static final String SQL_INSERT_NEW_FLIGHT_PLANE_ID= "SELECT id\n FROM plane\n WHERE boarding_number = ?";
    private static final String SQL_INSERT_NEW_FLIGHT_AIRPORT_ID= "SELECT id\n FROM airport\n WHERE name = ?";
    private static final String SQL_DELETE_FLIGHT= "DELETE FROM flight\nWHERE number=?;";
    private static final String SQL_CHANGE_FLIGHT= "UPDATE flight\nSET number=?, plane_id=?, departure_airport_id = ?, departure_time=?, landing_airport_id=?, landing_time=?\nWHERE number=?;";
    private static final String SQL_SHOW_ALL_AIRPORTS="SELECT * FROM airport;";
    private static final String SQL_SORT_BY_DEPARTURE_NUMBER= "SELECT f.number, p.boarding_number AS model_id, a.name AS departure_airport, f.departure_time, b.name\nAS landing_airport, f.landing_time\nFROM flight f INNER JOIN plane p\n    ON f.plane_id = p.id\n  INNER JOIN airport a\n    ON f.departure_airport_id = a.id\n  INNER JOIN airport b\n    ON f.landing_airport_id = b.id\nORDER BY f.number;";
    private static final String SQL_SEARCH_FLIGHT="SELECT f.number, p.boarding_number AS model_id, a.name AS departure_airport, f.departure_time, b.name\nAS landing_airport, f.landing_time\n FROM flight f INNER JOIN plane p\nON f.plane_id = p.id\nINNER JOIN airport a\nON f.departure_airport_id = a.id\nINNER JOIN airport b\nON f.landing_airport_id = b.id\nWHERE f.number LIKE ?;";
    private static final String SQL_SEARCH_FLIGHT_FROM= "SELECT f.id, f.number, p.boarding_number AS model_id, a.name AS departure_airport, f.departure_time, b.name\nAS landing_airport, f.landing_time\nFROM flight f INNER JOIN plane p\n    ON f.plane_id = p.id\n  INNER JOIN airport a\n    ON f.departure_airport_id = a.id\n  INNER JOIN airport b\n    ON f.landing_airport_id = b.id\nWHERE a.name=?;";
    private static final String SQL_SEARCH_FLIGHT_TO= "SELECT f.id, f.number, p.boarding_number AS model_id, a.name AS departure_airport, f.departure_time, b.name\nAS landing_airport, f.landing_time\nFROM flight f INNER JOIN plane p\n    ON f.plane_id = p.id\n  INNER JOIN airport a\n    ON f.departure_airport_id = a.id\n  INNER JOIN airport b\n    ON f.landing_airport_id = b.id\nWHERE b.name=?;";
    private static final String SQL_SEARCH_FLIGHT_DEPARTURE_TIME= "SELECT f.id, f.number, p.boarding_number AS model_id, a.name AS departure_airport, f.departure_time, b.name\nAS landing_airport, f.landing_time\nFROM flight f INNER JOIN plane p\n    ON f.plane_id = p.id\n  INNER JOIN airport a\n    ON f.departure_airport_id = a.id\n  INNER JOIN airport b\n    ON f.landing_airport_id = b.id\nWHERE f.departure_time LIKE ?%;";
    private static final String SQL_SEARCH_FLIGHT_NUMBER_BY_ID= "SELECT f.number\nFROM flight f INNER JOIN crew c ON f.id = c.flight_id\nWHERE c.flight_id=?;";
    private static final String SQL_SEARCH_FLIGHT_ID_BY_NUMBER= "SELECT f.id\nFROM flight f INNER JOIN crew c ON f.id = c.flight_id\nWHERE f.number=?;";
    private static final String SQL_SEARCH_FLIGHT_TIME_BY_NUMBER= "SELECT departure_time, landing_time\nFROM flight\nWHERE number=?;";

    public List<Flight> showAllFlights(Connection connection){
        List<Flight> flightList = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con;
        try {
            con = connection;
            st = con.createStatement();
            rs = st.executeQuery(SQL_SHOW_ALL_FLIGHTS);
            while (rs.next()) {
                flightList.add(extractALlFlightList(rs));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightList;
    }

    @Override
    public List<Flight> showPrepareFlights(Connection connection) {
        List<Flight> flightList = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con=null;
        try {
            con = connection;
            st = con.createStatement();
            rs = st.executeQuery(SQL_FLIGHTS_FOR_CREATE);
            while (rs.next()) {
                flightList.add(extractPrepareFlightList(rs));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightList;
    }

    public void deleteFlight(Connection connection, String string){
        try {
            PreparedStatement ps = connection.prepareCall(SQL_DELETE_FLIGHT);
            ps.setString(1,string);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Flight> showFlightsSortedByName(Connection connection) {
        List<Flight> flightList = new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con;
        try {
            con = connection;
            st = con.createStatement();
            rs = st.executeQuery(SQL_SORT_BY_DEPARTURE_NUMBER);
            while (rs.next()) {
                flightList.add(extractALlFlightList(rs));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightList;
    }

    @Override
    public List<Flight> showFlightsSorted(Connection connection, String query, Search search) {
        List<Flight> flightList = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        String SQL_SORT = "SELECT f.number, p.boarding_number AS model_id, a.name AS departure_airport, f.departure_time, b.name\nAS landing_airport, f.landing_time\nFROM flight f INNER JOIN plane p\n    ON f.plane_id = p.id\n  INNER JOIN airport a\n    ON f.departure_airport_id = a.id\n  INNER JOIN airport b\n    ON f.landing_airport_id = b.id\n";
        String q = SQL_SORT + query;
        try {
            con = connection;
            ps = con.prepareCall(q);
            int k=1;
            if (search.getFrom()!=null) {
                ps.setString(k++, search.getFrom());
            }
            if (search.getTo()!=null) {
                ps.setString(k++, search.getTo());
            }
            if (search.getDate()!=null) {
                ps.setString(k, search.getDate()+"%");
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                flightList.add(extractALlFlightList(rs));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightList;
    }

    @Override
    public ArrayList<Flight> searchFlight(Connection connection, String search) {
        ArrayList<Flight> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            con = connection;
            int k=1;
            ps = con.prepareCall(SQL_SEARCH_FLIGHT);
            search = "%"+search+"%";
            ps.setString(k,search);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractALlFlightList(rs));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Flight> searchFlightByAirport(Connection connection, String decision, String search) {
        ArrayList<Flight> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            con = connection;
            int k=1;
            if (decision.equals("From")) {
                ps = con.prepareCall(SQL_SEARCH_FLIGHT_FROM);
            }else {
                ps = con.prepareCall(SQL_SEARCH_FLIGHT_TO);
            }
            ps.setString(k,search);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractALlFlightList(rs));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String searchFlighNumberById(Connection connection, int id){
        String result="";
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            con = connection;
            int k=1;
            ps = con.prepareCall(SQL_SEARCH_FLIGHT_NUMBER_BY_ID);
            ps.setInt(k,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = (rs.getString(1));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int searchFlightIdByNumber(Connection connection,String number){
        int result=0;
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            con = connection;
            int k=1;
            ps = con.prepareCall(SQL_SEARCH_FLIGHT_ID_BY_NUMBER);
            ps.setString(k,number);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = (rs.getInt(1));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Timestamp[] searchFlightTimeByNumber(Connection connection,String number) {
        Timestamp [] timestamp = new Timestamp[2];
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            con = connection;
            int k=1;
            ps = con.prepareCall(SQL_SEARCH_FLIGHT_TIME_BY_NUMBER);
            ps.setString(k,number);
            rs = ps.executeQuery();
            while (rs.next()) {
                timestamp[0] = (rs.getTimestamp(1));
                timestamp[1] = (rs.getTimestamp(2));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    public int getIdFromPlane(Connection connection, String string){
        int id=0;
        try {
            PreparedStatement ps = connection.prepareCall(SQL_INSERT_NEW_FLIGHT_PLANE_ID);
            ps.setString(1,string);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                id=rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(id);
        return id;
    }

    public int getIdFromAirport(Connection connection,String string){
        int id=0;
        try {
            PreparedStatement ps = connection.prepareCall(SQL_INSERT_NEW_FLIGHT_AIRPORT_ID);
            ps.setString(1,string);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                id=rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(id);
        return id;
    }

    public Flight fillFlight(Connection con, FlightDTO dto){
        Flight flight = new Flight();
        flight.setNumber(dto.getName());
        flight.setPlanedID(getIdFromPlane(con,dto.getPlane()));
        flight.setDeparture_airport_id(getIdFromAirport(con,dto.getDeparture_airport()));
        flight.setLanding_airport_id(getIdFromAirport(con,dto.getLanding_airport()));
        flight.setDeparture_time(dto.getDeparture_time());
        flight.setLanding_time(dto.getLanding_time());
        return flight;
    }

    public void changeFlight(Connection connection, Flight flight, String before){
        try {
            System.out.println(flight);
            PreparedStatement ps = connection.prepareCall(SQL_CHANGE_FLIGHT);
            int k=1;
            System.out.println(before);
            ps.setString(k++, flight.getNumber());
            ps.setInt(k++, flight.getPlanedID());
            ps.setInt(k++, flight.getDeparture_airport_id());
            ps.setTimestamp(k++, flight.getDeparture_time());
            ps.setInt(k++, flight.getLanding_airport_id());
            ps.setTimestamp(k++, flight.getLanding_time());
            ps.setString(k,before);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void newFlight(Connection connection, Flight flight) {
            try {
                PreparedStatement ps = connection.prepareCall(SQL_INSERT_NEW_FLIGHT);
                int k = 1;
                ps.setString(k++, flight.getNumber());
                ps.setInt(k++, flight.getPlanedID());
                ps.setInt(k++, flight.getDeparture_airport_id());
                ps.setTimestamp(k++, flight.getDeparture_time());
                ps.setInt(k++, flight.getLanding_airport_id());
                ps.setTimestamp(k, flight.getLanding_time());
                ps.execute();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


    public List<Airport> allAirports(Connection connection) {
        List<Airport> airportList= new ArrayList<>();
        Statement st;
        ResultSet rs;
        Connection con=null;
        try {
            con = connection;
            st = con.createStatement();
            rs = st.executeQuery(SQL_SHOW_ALL_AIRPORTS);
            while (rs.next()) {
                airportList.add(extractAllAirport(rs));
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airportList;
    }


    private Airport extractAllAirport(ResultSet rs) throws SQLException {
        Airport airport = new Airport();
        airport.setName(rs.getString(Fields.AIRPORT_NAME));
        airport.setCode(rs.getString(Fields.AIRPORT_CODE));
        airport.setCity(rs.getString(Fields.AIRPORT_CITY));
        airport.setLatitude(rs.getDouble(Fields.AIRPORT_LATITUDE));
        airport.setLongitude(rs.getDouble(Fields.AIRPORT_LONGITUDE));
        return airport;
    }

    private Flight extractALlFlightList(ResultSet rs) throws SQLException {
        Flight flight = new Flight();
        try {
            flight.setId(rs.getInt(Fields.FLIGHT_ID));
        }catch (Exception e){}
        flight.setNumber(rs.getString(Fields.FLIGHT_NUMBER));
        flight.setPlane(rs.getString(Fields.FLIGHT_PLANE_NAME));
        flight.setDeparture_airport(rs.getString(Fields.FLIGHT_DEPARTURE_AIRPORT));
        flight.setLanding_airport(rs.getString(Fields.FLIGHT_LANDING_AIRPORT));
        flight.setDeparture_time(rs.getTimestamp(Fields.FLIGHT_DEPARTURE_TIME));
        flight.setLanding_time(rs.getTimestamp(Fields.FLIGHT_LANDING_TIME));
        return flight;
    }
    private Flight extractPrepareFlightList(ResultSet rs) throws SQLException {
        Flight flight = new Flight();
        flight.setPlane(rs.getString(Fields.FLIGHT_PLANE_NAME));
        flight.setDeparture_airport(rs.getString(Fields.FLIGHT_DEPARTURE_AIRPORT));
        flight.setLanding_airport(rs.getString(Fields.FLIGHT_LANDING_AIRPORT));
        return flight;
    }
}
