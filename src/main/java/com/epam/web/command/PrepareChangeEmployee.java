package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MySQLEmployeeDAO;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.entity.CrewMan;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class PrepareChangeEmployee extends Command {
    private static final Logger LOG = Logger.getLogger(PrepareChangeEmployee.class);

    MySQLEmployeeDAO dao;
    DBManager dbManager;

    public PrepareChangeEmployee(MySQLEmployeeDAO dao, DBManager dbManager) {
        this.dao = dao;
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConnection(dbManager.getConnection());

        List<CrewMan> employeeList = dao.showAllEmployers(connection);
        LOG.trace("Employees list --> "+employeeList);
        request.getSession().setAttribute("employeeList",employeeList);

        TransactionManager.close(connection);
        LOG.debug("Command finished");
        return Path.EMPLOYEE_LIST_FOR_CHANGE;
    }
}
