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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewEmployee extends Command {
    private static final Logger LOG = Logger.getLogger(NewEmployee.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        CrewMan man = newEmployee(request);
        LOG.trace("New Employee --> "+man);
        ArrayList<String> list=validateEmployee(man);
        if (list.isEmpty()) {
            new MyEmployeeDAO().newEmployee(DBManager.getInstance().getConnection(), newEmployee(request));
        }else {
            LOG.trace("Errors --> "+list);
            request.setAttribute("errors",list);
            return Path.EMPLOYEE_PREPARE_NEW;
        }

        LOG.debug("Command finished");

        return Path.EMPLOYEE_NEW;
    }

    CrewMan newEmployee(HttpServletRequest req){
        MyEmployeeDAO employeeDAO = new MyEmployeeDAO();
        return employeeDAO.fillCrewMan(DBManager.getInstance().getConnection(), EmployeeParser.flightDTOParser(req));
    }

    public ArrayList<String> validateEmployee(CrewMan man) {
        ArrayList<String> list = new ArrayList<>();
        if (man.getFirstName().isEmpty()){
            list.add("Name cannot be empty");
        }
        Pattern namePattern = Pattern.compile("[A-ZА-Я]{1}[a-zа-я]+");
        Matcher m = namePattern.matcher(man.getFirstName());
        if (!m.find()){
            list.add("Name must be\"John, Bob, Susan\"");
        }
        m=namePattern.matcher(man.getLastName());
        if (!m.find()){
            list.add("SurName must be\"Smith, Snow, Barateon\"");
        }
        if (man.getAge()<18&&man.getAge()>100){
            list.add("Age must be from 18 to 100");
        }
        return list;
    }


}
