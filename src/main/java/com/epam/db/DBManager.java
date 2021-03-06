package com.epam.db;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {

    private static final Logger LOG = Logger.getLogger(DBManager.class);
    private static final String CONNECTION_POOL_NAME = "java:comp/env/jdbc/flight";
    private DataSource ds;

    public DBManager() {
        DataSource ds = null;
        InitialContext initContext;
        try {
            initContext = new InitialContext();
            ds = (DataSource) initContext.lookup(CONNECTION_POOL_NAME);
        } catch (NamingException e) {
            LOG.error(e);
        }
        this.ds=ds;
    }

    /**
     * Get connection
     * @return connection
     */
    public Connection getConnection() {
        Connection con = null;
        try {
            con = ds.getConnection();
        } catch (SQLException ex) {
            LOG.error(ex.getMessage());
        }
        return con;
    }
}
