package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.dto.FlightParser;
import com.epam.entity.Flight;
import com.epam.dao.impl.MyFlightDAO;
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

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConnection(DBManager.getInstance().getConnection());

        Flight f = null;
        try {
            f = newFlight(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOG.trace("New Flight --> "+f);

        ArrayList<String> list = validateNewFlight(f);
        if (list.isEmpty()) {
            new MyFlightDAO().newFlight(connection, f);
        }else {
            LOG.trace("Errors --> "+list);
            request.setAttribute("errors",list);
            return Path.FLIGHTS_NEW;
        }

        TransactionManager.close(connection);
        LOG.debug("Command finished");
        return Path.FLIGHT_RETURN_LIST;
    }

    Flight newFlight(HttpServletRequest req) throws SQLException {
        MyFlightDAO flightDAO = new MyFlightDAO();
        return flightDAO.fillFlight(DBManager.getInstance().getConnection(), FlightParser.flightDTOparser(req));
    }

    private ArrayList<String> validateNewFlight(Flight flight) {
        ArrayList<String> list = new ArrayList<>();
        if (flight.getDeparture_time().after(flight.getLanding_time())){
            list.add("Back to the Future?");
        }
        if(flight.getDeparture_airport_id()==flight.getLanding_airport_id()){
            list.add("You can not fly to the same airport");
        }
        if (flight.getNumber().equals("")){
            list.add("Flight number cannot be empty");
        }
        return list;
    }
}
