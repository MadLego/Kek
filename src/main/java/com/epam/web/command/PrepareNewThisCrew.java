package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.entity.CrewMan;
import com.epam.dao.impl.MyEmployeeDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PrepareNewThisCrew extends Command {
    private static final Logger LOG = Logger.getLogger(PrepareNewThisCrew.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        List<CrewMan> list = new MyEmployeeDAO().showAllEmployers(DBManager.getInstance().getConnection());
        request.getSession().setAttribute("employees",list);
        request.getSession().setAttribute("flightName",request.getParameter("name"));
        request.getSession().setAttribute("flightId",request.getParameter("flightId"));
        LOG.trace("List of Employees --> "+list);

        LOG.debug("Command finished");

        return Path.CREW_THIS;
    }
}
