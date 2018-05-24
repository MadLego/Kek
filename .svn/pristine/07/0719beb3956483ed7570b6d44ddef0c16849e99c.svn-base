package com.epam.dao;

import com.epam.dto.EmployeeDTO;
import com.epam.entity.CrewMan;

import java.sql.Connection;
import java.util.List;

public interface EmployeeDAO {

    /**
     * Prepare to show all available employees
     * @param connection connection with DB
     * @return List of CrewMan
     */
    List<CrewMan> showAllEmployers(Connection connection);

    /**
     * Add to Database new employer
     * @param connection connection with DB
     * @param crewMan instance of data class with fields
     */
    void newEmployee(Connection connection, CrewMan crewMan);

    /**
     * Delete from Database employer
     * @param connection connection with DB
     * @param id ID of the employee whose database you want to delete
     */
    void deleteEmployee(Connection connection, int id);

    /**
     * Change information of the employee in Database
     * @param connection connection with DB
     * @param crewMan new information of the employee
     */
    void changeEmployee(Connection connection, CrewMan crewMan);

    /**
     * Fill the instance of CrewMan class with fields from EmployeeDTO
     * @param con connection with DB
     * @param dto Data Transfer Object where saves and process data
     * @return instance of data class
     */
    CrewMan fillCrewMan(Connection con, EmployeeDTO dto);

    /**
     * Prepare to show all roles what can be an employees
     * @param connection connection with DB
     * @return List of roles
     */
    List<String> showAllRoles(Connection connection);

    /**
     * Select from database all information of this employee
     * @param connection connection with DB
     * @param employeeId whose employee ID need to be found in the database
     * @return instance of CrewMan class with filled fields
     */
    CrewMan selectEmployeeById(Connection connection, int employeeId);
}
