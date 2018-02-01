package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.entity.Flight;
import com.epam.dao.impl.MyFlightDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class SearchFlight extends Command {
    private static final Logger LOG = Logger.getLogger(SearchFlight.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConection(DBManager.getInstance().getConnection());

        ArrayList<Flight> flights = new MyFlightDAO().searchFlight(connection,request.getParameter("searchItem"));
        LOG.trace("List of flights --> "+flights);
        String result=validate(flights);
        if (!result.equals("OK")){
            LOG.trace("Error --> "+result);
            request.setAttribute("errors", result);
        }else {
            request.setAttribute("searchingFlight", flights);
        }
        LOG.debug("Command finished");

        return Path.FLIGHTS_SEARCHING;
    }

    private String validate(List<Flight> flights) {
        if (flights.isEmpty()){
            return "This flight does not exist";
        }
        return "OK";
    }

}
