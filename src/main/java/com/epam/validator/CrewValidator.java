package com.epam.validator;

import com.epam.dao.impl.MySQLCrewDAO;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.entity.Crew;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

public class CrewValidator {

    public String validate(Crew crew, List<Integer> list, int flightId) {
        Connection connection = new DBManager().getConnection();
        MySQLCrewDAO dao = new MySQLCrewDAO();
        String result = "OK";
        if (crew.getFirst_conductor() == crew.getSecond_conductor()) {
            result = "You can not choose the same stewardess";
        }
        for (int i : list) {
            if (!dao.timeAdmission(connection, i, flightId)) {
                result = "Illegal time for employees";
            }
        }
        if (result.equals("OK")) {
            dao.newCrew(connection, crew, flightId);
            dao.addCrewAdmission(connection, list, flightId);
        }
        TransactionManager.close(connection);
        return result;
    }

    public boolean validateTime(Timestamp[] admissionTime, Timestamp[] timestamps) {
        if (admissionTime[0] == null || admissionTime[1] == null) {
            return true;
        }
        for (int i = 0; i < timestamps.length; i++) {
            if (timestamps[i].getTime() >= (admissionTime[0].getTime()) && timestamps[i].getTime() <= (admissionTime[1]).getTime()) {
                return false;
            }
        }
        return true;
    }
}
