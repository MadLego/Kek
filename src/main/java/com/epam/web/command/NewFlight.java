package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.parser.FlightParser;
import com.epam.entity.Flight;
import com.epam.dao.impl.MyFlightDAO;
import com.epam.validator.FlightsValidator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewFlight extends Command {
    private static final Logger LOG = Logger.getLogger(NewFlight.class);

    MyFlightDAO dao;
    DBManager dbManager;

    public NewFlight(MyFlightDAO dao, DBManager dbManager) {
        this.dao = dao;
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConnection(dbManager.getConnection());

        Flight f = null;
        try {
            f = newFlight(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOG.trace("New Flight --> "+f);

        ArrayList<String> list = FlightsValidator.validateNewFlights(f,connection);
        if (list.isEmpty()) {
            dao.newFlight(connection, f);
        }else {
            LOG.trace("Errors --> "+list);
            request.getSession().setAttribute("errors",list);
            return Path.FLIGHTS_NEW;
        }

        TransactionManager.close(connection);
        LOG.debug("Command finished");
        return Path.FLIGHT_RETURN_LIST;
    }

    Flight newFlight(HttpServletRequest req) throws SQLException {
        return dao.fillFlight(dbManager.getConnection(), FlightParser.flightDTOparser(req));
    }
}
