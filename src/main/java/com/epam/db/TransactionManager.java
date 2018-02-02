package com.epam.db;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    /**
     * Prepare connection to use in some command
     * @param connection connection with DB
     * @return connection with settings
     */
    public static Connection prepareConnection(Connection connection){
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Need to use after doing all what you need in your command
     * @param connection connection with DB
     */
    public static void close(Connection connection){
        try {
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
