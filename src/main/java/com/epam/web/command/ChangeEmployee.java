package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.dto.EmployeeParser;
import com.epam.entity.CrewMan;
import com.epam.dao.impl.MyEmployeeDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ChangeEmployee extends Command {
    private static final Logger LOG = Logger.getLogger(ChangeEmployee.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        CrewMan man = changeEmployee(request);
        ArrayList<String> list=new NewEmployee().validateEmployee(man);
        if (list.isEmpty()) {
            new MyEmployeeDAO().changeEmployee(DBManager.getInstance().getConnection(), changeEmployee(request));
        }else {
            request.setAttribute("errors",list);
            return Path.EMPLOYEE_PREPARE_NEW;
        }
        LOG.trace("Errors in request --> " + list);

        LOG.debug("Command finished");

        return Path.EMPLOYEE_RETURN_CHANGE_LIST;
    }
    CrewMan changeEmployee(HttpServletRequest req){
        MyEmployeeDAO employeeDAO = new MyEmployeeDAO();
        return employeeDAO.fillCrewMan(DBManager.getInstance().getConnection(), EmployeeParser.flightDTOParser(req));
    }


}
