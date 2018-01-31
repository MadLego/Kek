package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MyFlightDAO;
import com.epam.db.DBManager;
import com.epam.entity.Airport;
import com.epam.entity.Flight;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllFlightsList extends Command {
    private static final Logger LOG = Logger.getLogger(AllFlightsList.class);

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        List<Flight> flightList = new MyFlightDAO().showAllFlights(DBManager.getInstance().getConnection());
        LOG.trace("Found in DB: flightList --> " + flightList);

        List<Airport> airportList = new MyFlightDAO().allAirports(DBManager.getInstance().getConnection());
        LOG.trace("Found in DB: airportList --> " + airportList);

        request.getSession().setAttribute("airportList", airportList);
        request.getSession().setAttribute("flightList", flightList);

        LOG.debug("Command finished");
        return Path.FLIGHTS_LIST;
    }
}
