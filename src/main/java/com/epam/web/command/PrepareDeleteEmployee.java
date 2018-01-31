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

public class PrepareDeleteEmployee extends Command {
    private static final Logger LOG = Logger.getLogger(PrepareDeleteEmployee.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        List<CrewMan> employeeslist = new MyEmployeeDAO().showAllEmployers(DBManager.getInstance().getConnection());
        request.setAttribute("employeesList", employeeslist);
        LOG.trace("Employee list --> " + employeeslist);

        LOG.debug("Command finished");

        return Path.EMPLOYEES_LIST_FOR_DELETE;
    }
}