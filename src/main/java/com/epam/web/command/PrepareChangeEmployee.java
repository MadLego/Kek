package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MyEmployeeDAO;
import com.epam.db.DBManager;
import com.epam.entity.CrewMan;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PrepareChangeEmployee extends Command {
    private static final Logger LOG = Logger.getLogger(PrepareChangeEmployee.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        List<CrewMan> employeeList = new MyEmployeeDAO().showAllEmployers(DBManager.getInstance().getConnection());
        LOG.trace("Employees list --> "+employeeList);
        request.getSession().setAttribute("employeeList",employeeList);

        LOG.debug("Command finished");
        return Path.EMPLOYEE_LIST_FOR_CHANGE;
    }
}
