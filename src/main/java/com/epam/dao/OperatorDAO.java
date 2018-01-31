package com.epam.dao;

import java.sql.Connection;

public interface OperatorDAO {
    com.epam.entity.Operator login(Connection connection, String login);
    
    String registration(Connection connection, com.epam.entity.Operator operator);
}

