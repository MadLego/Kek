package com.epam.dao.impl;

import com.epam.dao.OperatorDAO;
import com.epam.db.Fields;
import com.epam.dto.OperatorDTO;
import com.epam.entity.Operator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyOperatorDAO implements OperatorDAO {
    public static final String SQL_LOGIN = "SELECT login, password, email, op_type_id\nFROM operator\nWHERE login=?;";
    public static final String SQL_REGISTRATION_VALIDATION="SELECT login, email\nFROM operator\nWHERE login=? AND email=?;";
    public static final String SQL_REGISTRATION = "INSERT INTO operator\nVALUES(DEFAULT, ?, ?, ?,DEFAULT );";

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
            e.printStackTrace();
        }
        return operator;
    }

    private Operator extractPrepareOperator(ResultSet rs) throws SQLException {
        Operator operator = new Operator();
        operator.setEmail(rs.getString(Fields.OPERATOR_EMAIL));
        operator.setLogin(rs.getString(Fields.OPERATOR_LOGIN));
        operator.setPassword(rs.getString(Fields.OPERATOR_PASSWORD));
        operator.setOp_type_id(rs.getInt(Fields.OPERATOR_OPERATOR_TYPE_ID));
        return operator;
    }

    public Operator fillOperator(OperatorDTO dto) {
        Operator operator = new Operator();
        operator.setId(dto.getId());
        operator.setEmail(dto.getEmail());
        operator.setLogin(dto.getLogin());
        operator.setPassword(dto.getPassword());
        operator.setOp_type_id(dto.getOp_type_id());
        return operator;
    }


    @Override
    public String registration(Connection connection, Operator operator) {
        String result="";
        try {
            if (validateRegistration(connection, operator).equals("False")){
                result = "Bad idea";
                return result;
            }
            PreparedStatement ps = connection.prepareCall(SQL_REGISTRATION);
            int k = 1;
            ps.setString(k++, operator.getEmail());
            ps.setString(k++, operator.getLogin());
            ps.setString(k, operator.getPassword());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            result = "Bad idea";
            e.printStackTrace();
        }
        return result;
    }

    private String validateRegistration(Connection connection, Operator operator){
        String result="False";
        PreparedStatement ps;
        ResultSet rs;
        try {
            int k = 1;
            ps = connection.prepareCall(SQL_REGISTRATION_VALIDATION);
            ps.setString(k++, operator.getLogin());
            ps.setString(k, operator.getEmail());
            rs = ps.executeQuery();
            if (!rs.next()){
                return "OK";
            }else {
                while (rs.next()){
                    operator=extractPrepareOperator(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
