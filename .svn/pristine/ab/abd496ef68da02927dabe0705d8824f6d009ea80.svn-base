package com.epam.dao;

import com.epam.dto.OperatorDTO;
import com.epam.entity.Operator;

import java.sql.Connection;

public interface OperatorDAO {
    /**
     * Logs in to the page, defines the role
     * @param connection connection with DB
     * @param login login of user on which the first audit of the account in the database
     * @return instance of Login class in which user data is stored including the role of
     */
    com.epam.entity.Operator login(Connection connection, String login);

    /**
     * Create new user and save information about him in Database
     * @param connection connection with DB
     * @param operator on this instance store information about new User
     * @return result of registration, if it's false he show on the page
     */
    String registration(Connection connection, com.epam.entity.Operator operator);

    /**
     * Fill the instance of Operator class with fields from OperatorDTO
     * @param dto Data Transfer Object where saves and process data
     * @return instance of data class
     */
    Operator fillOperator(OperatorDTO dto);
}

