package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MyEmployeeDAO;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.dto.ChangeEmployeeParser;
import com.epam.dto.EmployeeDTO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PrepareChangeThisEmployee extends Command {
    private static final Logger LOG = Logger.getLogger(PrepareChangeEmployee.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConection(DBManager.getInstance().getConnection());

        List<EmployeeDTO> list = new ArrayList<>();
        list.add(ChangeEmployeeParser.changeEmployeeDTOparser(request));
        request.getSession().setAttribute("thisEmployee",ChangeEmployeeParser.changeEmployeeDTOparser(request).getId());
        request.getSession().setAttribute("roleList", new MyEmployeeDAO().showAllRoles(connection));
        request.setAttribute("changeThisEmployee",list);
        LOG.trace("This Employee --> "+list);

        TransactionManager.close(connection);
        LOG.debug("Command finished");
        return Path.EMPLOYEE_CHANGE;
    }
}
