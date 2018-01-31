package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.dto.EmployeeParser;
import com.epam.entity.CrewMan;
import com.epam.dao.impl.MyEmployeeDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class ChangeEmployee extends Command {
    private static final Logger LOG = Logger.getLogger(ChangeEmployee.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConection(DBManager.getInstance().getConnection());

        CrewMan man = changeEmployee(request);
        ArrayList<String> list=new NewEmployee().validateEmployee(man);
        if (list.isEmpty()) {
            new MyEmployeeDAO().changeEmployee(connection, changeEmployee(request));
        }else {
            request.setAttribute("errors",list);
            return Path.EMPLOYEE_PREPARE_NEW;
        }
        LOG.trace("Errors in request --> " + list);

        LOG.debug("Command finished");
        TransactionManager.close(connection);
        return Path.EMPLOYEE_RETURN_CHANGE_LIST;
    }
    CrewMan changeEmployee(HttpServletRequest req){
        Connection connection = TransactionManager.prepareConection(DBManager.getInstance().getConnection());
        MyEmployeeDAO employeeDAO = new MyEmployeeDAO();
        return employeeDAO.fillCrewMan( connection, EmployeeParser.flightDTOParser(req));
    }


}
