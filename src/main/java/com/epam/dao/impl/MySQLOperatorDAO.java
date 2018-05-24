package com.epam.dao.impl;

import com.epam.dao.OperatorDAO;
import com.epam.db.Fields;
import com.epam.db.TransactionManager;
import com.epam.dto.OperatorDTO;
import com.epam.entity.Operator;

import java.sql.*;

public class MySQLOperatorDAO implements OperatorDAO {
    private static final String SQL_LOGIN = "SELECT login, password, email, op_type_id\nFROM operator\nWHERE login=?;";
    private static final String SQL_REGISTRATION_VALIDATION = "SELECT login, email\nFROM operator\nWHERE login=? OR email=?;";
    private static final String SQL_REGISTRATION = "INSERT INTO operator\nVALUES(DEFAULT, ?, ?, ?,DEFAULT, DEFAULT);";
    private static final String SQL_ACTIVATE = "UPDATE operator\nSET activate = 1\nWHERE id = ?;";
    private static final String SQL_MAX_ID = "SELECT MAX(id)\nFROM operator;";

    @Override
    public Operator login(Connection connection, String login) {
        Operator operator = new Operator();
        PreparedStatement ps;
        ResultSet rs;
        try {
            int k = 1;
            ps = connection.prepareCall(SQL_LOGIN);
            ps.setString(k, login);
            rs = ps.executeQuery();
            while (rs.next()) {
                operator = extractPrepareOperator(rs);
            }
        } catch (SQLException e) {
            TransactionManager.rollback(connection);
            e.printStackTrace();
        }
        return operator;
    }

    public int selectMaxId(Connection connection) {
        int id = 0;
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(SQL_MAX_ID);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            TransactionManager.rollback(connection);
            e.printStackTrace();
        }
        return id;
    }

    public void activateOperatorAccount(Connection connection, int id) {
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(SQL_ACTIVATE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            TransactionManager.rollback(connection);
            e.printStackTrace();
        }
    }

    private Operator extractPrepareOperator(ResultSet rs) throws SQLException {
        Operator operator = new Operator();
        operator.setEmail(rs.getString(Fields.OPERATOR_EMAIL));
        operator.setLogin(rs.getString(Fields.OPERATOR_LOGIN));
        operator.setPassword(rs.getString(Fields.OPERATOR_PASSWORD));
        operator.setOpTypeId(rs.getInt(Fields.OPERATOR_OPERATOR_TYPE_ID));
        return operator;
    }

    public Operator fillOperator(OperatorDTO dto) {
        Operator operator = new Operator();
        operator.setId(dto.getId());
        operator.setEmail(dto.getEmail());
        operator.setLogin(dto.getLogin());
        operator.setPassword(dto.getPassword());
        operator.setOpTypeId(dto.getOp_type_id());
        return operator;
    }


    @Override
    public String registration(Connection connection, Operator operator) {
        String result = "";
        try {
            System.out.println(validateRegistration(connection,operator));
            if (validateRegistration(connection, operator).equals("False")) {
                result = "Bad idea";
                return result;
            }
            PreparedStatement ps = connection.prepareCall(SQL_REGISTRATION);
            int k = 1;
            ps.setString(k++, operator.getEmail());
            ps.setString(k++, operator.getLogin());
            ps.setString(k, operator.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            result = "Bad idea";
            TransactionManager.rollback(connection);
            e.printStackTrace();
        }
        return result;
    }

    private String validateRegistration(Connection connection, Operator operator) {
        String result = "False";
        PreparedStatement ps;
        ResultSet rs;
        try {
            int k = 1;
            ps = connection.prepareCall(SQL_REGISTRATION_VALIDATION);
            ps.setString(k++, operator.getLogin());
            ps.setString(k, operator.getEmail());
            rs = ps.executeQuery();
            if (!rs.next()) {
                return "OK";
            } else {
                while (rs.next()) {
                    operator = extractPrepareOperator(rs);
                }
            }
        } catch (SQLException e) {
            TransactionManager.rollback(connection);
            e.printStackTrace();
        }
        return result;
    }

}
