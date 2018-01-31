package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.entity.Flight;
import com.epam.dao.impl.MyFlightDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PrepareNewFlights extends Command {
    private static final Logger LOG = Logger.getLogger(PrepareNewFlights.class);

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        List<Flight> flightList = new MyFlightDAO().showPrepareFlights(DBManager.getInstance().getConnection());
        request.getSession().setAttribute("prepareFlight", flightList);
        LOG.trace("New Flight --> "+flightList);
        LOG.debug("Command finished");
        return Path.FLIGHTS_NEW;
    }
}
