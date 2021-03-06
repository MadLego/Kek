package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MySQLEmployeeDAO;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.parser.EmployeeParser;
import com.epam.entity.CrewMan;
import com.epam.validator.EmployeesValidator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class ChangeEmployee extends Command {
    private static final Logger LOG = Logger.getLogger(ChangeEmployee.class);

    DBManager dbManager;
    MySQLEmployeeDAO dao;

    public ChangeEmployee(MySQLEmployeeDAO dao, DBManager dbManager) {
        this.dao = dao;
        this.dbManager = dbManager;

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConnection(dbManager.getConnection());

        CrewMan man = changeEmployee(request);
        ArrayList<String> list=EmployeesValidator.validateEmployee(man);
        if (list.isEmpty()) {
            dao.changeEmployee(connection, changeEmployee(request));
        }else {
            request.getSession().setAttribute("errors",list);
            return Path.EMPLOYEE_PREPARE_NEW;
        }
        LOG.trace("Errors in request --> " + list);

        LOG.debug("Command finished");
        TransactionManager.close(connection);
        return Path.EMPLOYEE_RETURN_CHANGE_LIST;
    }
    public CrewMan changeEmployee(HttpServletRequest req){
        Connection connection = TransactionManager.prepareConnection(dbManager.getConnection());
        return dao.fillCrewMan( connection, EmployeeParser.flightDTOParser(req));
    }


}
