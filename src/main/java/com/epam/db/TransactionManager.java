package com.epam.db;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    public static Connection prepareConection(Connection connection){
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection){
        try {
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
