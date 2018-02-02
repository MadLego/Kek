package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MyFlightDAO;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.entity.Flight;
import com.epam.entity.Search;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.List;

public class SortFlights extends Command {
    private static final Logger LOG = Logger.getLogger(SearchFlight.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConnection(DBManager.getInstance().getConnection());

        String query = chooseTheSearch(request.getParameterNames(),request);
        Search search =  fillSearch(request);
        List<Flight> flightList = new MyFlightDAO().showFlightsSorted(connection,query,search);
        LOG.trace("Sorted flight list --> "+flightList);
        if (flightList.isEmpty()){
            request.setAttribute("errors", "Bed request");
        }
        request.setAttribute("searchList", flightList);
        TransactionManager.close(connection);
        LOG.debug("Command finished");

        return Path.FLIGHTS_LIST;
    }

    private Search fillSearch(HttpServletRequest req){
        Search search = new Search();
        String temp =req.getParameter("searchDepartureFlight");
        checkOrder(req);
        if (!temp.isEmpty()){
            search.setFrom(temp);
            req.getSession().setAttribute("departureFlightChoice",temp);
        }else {
            req.getSession().removeAttribute("departureFlightChoice");
        }
        temp = req.getParameter("searchLandingFlight");
        if (!temp.isEmpty()){
            req.getSession().setAttribute("landingFlightChoice",temp);
            search.setTo(temp);
        }else {
            req.getSession().removeAttribute("landingFlightChoice");
        }
        temp = req.getParameter("date");
        if (!temp.isEmpty()){
            req.getSession().setAttribute("departureDateChoice", temp);
            search.setDate(temp);
        }else {
            req.getSession().removeAttribute("departureDateChoice");
        }
        LOG.trace("Search Entity --> "+search);
        return search;
    }

    private void checkOrder(HttpServletRequest req) {
        String temp = req.getParameter("sortFlightBy");
        if (!temp.isEmpty()){
            req.getSession().setAttribute("sortFlightBy", temp);
        }else {
            req.getSession().removeAttribute("sortFlightBy");
        }
    }

    private String chooseTheSearch(Enumeration<String> command, HttpServletRequest req){
        String sqlQuery="";
        if(!req.getParameter("searchDepartureFlight").isEmpty()){
            if (sqlQuery.isEmpty()) {
                sqlQuery+="WHERE a.name=?";
            }else {
                sqlQuery+=" WHERE a.name=?";
            }
        }
        if (!req.getParameter("searchLandingFlight").isEmpty()){
            if (sqlQuery.isEmpty()) {
                sqlQuery += "WHERE b.name=?";
            }else {
                sqlQuery += " AND b.name=?";
            }
        }
        if(!req.getParameter("date").isEmpty()){
            if (sqlQuery.isEmpty()) {
                sqlQuery += "WHERE f.departure_time LIKE ?";
            }else{
                sqlQuery+=" AND f.departure_time LIKE ?";
            }
        }
        if (!req.getParameter("sortFlightBy").isEmpty()){
            String parameter = req.getParameter("sortFlightBy");
            if (parameter.equals("Sort By Number")) {
                sqlQuery += "\nORDER BY f.number";
            }else {
                sqlQuery += "\nORDER BY f.id";
            }
        }
        sqlQuery+=";";
        LOG.trace("SQL Query for sort --> "+sqlQuery);
        return sqlQuery;
    }

}
