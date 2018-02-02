package com.epam.dao.impl;

import com.epam.dao.EmployeeDAO;
import com.epam.dto.EmployeeDTO;
import com.epam.dto.EmployeeParser;
import com.epam.entity.CrewMan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyEmployeeDAO implements EmployeeDAO {
    private static final String SQL_INSERT_NEW_EMPLOYEE = "INSERT INTO crew_man\nVALUES(DEFAULT,?,?,?,?,?);";
    private static final String SQL_SHOW_ALL_EMPLOYEES = "SELECT*\nFROM crew_man;";
    private static final String SQL_DELETE_EMPOYEE = "DELETE FROM crew_man\nWHERE id=?;";
    private static final String SQL_SHOW_ALL_ROLE = "SELECT role\nFROM crew_man\nGROUP BY role;";
    private static final String SQL_CHANGE_EMPLOYEE = "UPDATE crew_man\nSET first_name=?, last_name=?, age=?, is_permitted=?, role=?\nWHERE id=?;";
    private static final String SQL_SELECT_EMPLOYEE_BY_ID = "SELECT *\nFROM crew_man\nWHERE id=?;";
    private static final String SQL_SET_ADMISSION_ACCEPT = "UPDATE crew_man_admission\nSET is_admitted = 1\nWHERE date_from = ? AND date_to = ?;";
    private static final String SQL_SET_ADMISSION_REJECT = "DELETE FROM crew_man_admission\nWHERE date_from = ? AND date_to = ?;";

    @Override
    public List<CrewMan> showAllEmployers(Connection connection) {
        List<CrewMan> employeeList = new ArrayList<>();
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(SQL_SHOW_ALL_EMPLOYEES);
            while (rs.next()) {
                employeeList.add(extractAllEmployees(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public CrewMan selectEmployeeById(Connection connection, int employeeId) {
        CrewMan crewMan=new CrewMan();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = connection.prepareCall(SQL_SELECT_EMPLOYEE_BY_ID);
            ps.setInt(1, employeeId);
            rs = ps.executeQuery();
            while (rs.next()) {
               crewMan=(extractAllEmployees(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crewMan;
    }

    public List<String> showAllRoles(Connection connection) {
        List<String> roleList = new ArrayList<>();
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(SQL_SHOW_ALL_ROLE);
            while (rs.next()) {
                roleList.add(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public void newEmployee(Connection connection, CrewMan crewMan) {
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(SQL_INSERT_NEW_EMPLOYEE);
            int k = 1;
            ps.setString(k++, crewMan.getFirstName());
            ps.setString(k++, crewMan.getLastName());
            ps.setInt(k++, crewMan.getAge());
            ps.setInt(k++, crewMan.getIsPermitted());
            ps.setString(k, crewMan.getRole());
            ps.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(Connection connection, int id) {
        try {
            PreparedStatement ps = connection.prepareCall(SQL_DELETE_EMPOYEE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeEmployee(Connection connection, CrewMan crewMan) {
        try {
            PreparedStatement ps = connection.prepareCall(SQL_CHANGE_EMPLOYEE);
            int k = 1;
            ps.setString(k++, crewMan.getFirstName());
            ps.setString(k++, crewMan.getLastName());
            ps.setInt(k++, crewMan.getAge());
            ps.setInt(k++, crewMan.getIsPermitted());
            ps.setString(k++, crewMan.getRole());
            ps.setInt(k, crewMan.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setAdmission(Connection connection, String decision ,Timestamp[] timestamps){
        PreparedStatement ps;
        try {
            if (decision.equals("Ok")) {
                ps = connection.prepareCall(SQL_SET_ADMISSION_ACCEPT);
            }else {
                ps = connection.prepareCall(SQL_SET_ADMISSION_REJECT);
            }
            ps.setTimestamp(1, timestamps[0]);
            ps.setTimestamp(2, timestamps[1]);
//            String [] time = DateTimeParser.fromTimestampToString(timestamps);
//            ps.setString(1,time[0]);
//            ps.setString(2,time[1]);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CrewMan fillCrewMan(Connection con, EmployeeDTO dto) {
        CrewMan crew = new CrewMan();
        crew.setId(dto.getId());
        crew.setFirstName(dto.getFirstName());
        crew.setLastName(dto.getLastName());
        crew.setAge(dto.getAge());
        crew.setIsPermitted(dto.getIsPermitter());
        crew.setIsPermittedView(dto.getIsPemittedView());
        crew.setRole(dto.getRole());
        return crew;
    }

    private CrewMan extractAllEmployees(ResultSet rs) throws SQLException {
        CrewMan cMan = new CrewMan();
        cMan.setId(rs.getInt("id"));
        cMan.setFirstName(rs.getNString("first_name"));
        cMan.setLastName(rs.getString("last_name"));
        cMan.setAge(rs.getInt("age"));
        cMan.setIsPermitted(rs.getInt("is_permitted"));
        cMan.setIsPermittedView(EmployeeParser.setAdmission(cMan.getIsPermitted()));
        cMan.setRole(rs.getString("role"));
        return cMan;
    }

}
