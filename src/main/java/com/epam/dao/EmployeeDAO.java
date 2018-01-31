package com.epam.dao;

import com.epam.entity.CrewMan;

import java.sql.Connection;
import java.util.List;

public interface EmployeeDAO {

    List<CrewMan> showAllEmployers(Connection connection);

    void newEmployee(Connection connection, CrewMan crewMan);

    void deleteEmployee(Connection connection, int id);

    void changeEmployee(Connection connection, CrewMan crewMan);
}
