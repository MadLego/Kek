package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MySQLCrewDAO;
import com.epam.dao.impl.MySQLEmployeeDAO;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.entity.CrewMan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Task extends Command {
    MySQLCrewDAO crewDAO;
    DBManager dbManager;
    MySQLEmployeeDAO employeeDAO;

    public Task(MySQLEmployeeDAO employeeDAO, MySQLCrewDAO crewDAO, DBManager dbManager) {
        this.employeeDAO = employeeDAO;
        this.crewDAO = crewDAO;
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = TransactionManager.prepareConnection(dbManager.getConnection());
        ArrayList<CrewMan> list = crewDAO.getCrewManAdmission(connection);
        List<CrewMan> crewList = employeeDAO.showAllEmployers(connection);
        getCount(list, crewList, request);

        TransactionManager.close(connection);

        return Path.TASK;
    }

    private void getCount(ArrayList<CrewMan> list, List<CrewMan> crewList, HttpServletRequest request) {
        int counterPilot = 0;
        int counterNavigator = 0;
        int counterConductor = 0;
        int counterRadioOperator = 0;
        for (CrewMan c : crewList) {
            if (!list.contains(c)) {
                if (c.getRole().equals("pilot")) {
                    counterPilot++;
                }
                if (c.getRole().equals("radio_operator")) {
                    counterRadioOperator++;
                }
                if (c.getRole().equals("navigator")) {
                    counterNavigator++;
                }
                if (c.getRole().equals("conductor")) {
                    counterConductor++;
                }
            }
        }
        request.getSession().setAttribute("pilotCounter", counterPilot);
        request.getSession().setAttribute("pilotNavigator", counterNavigator);
        request.getSession().setAttribute("pilotRadioOperator", counterRadioOperator);
        request.getSession().setAttribute("pilotConductor", counterConductor);
    }
}
