package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MyFlightDAO;
import com.epam.db.DBManager;
import com.epam.entity.Flight;
import com.epam.entity.Search;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

public class SortFlights extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String query = chooseTheSearch(request.getParameterNames(),request);
        Search search =  fillSearch(request);
        List<Flight> flightList = new MyFlightDAO().showFlightsSorted(DBManager.getInstance().getConnection(),query,search);
        if (flightList.isEmpty()){
            request.setAttribute("errors", "Bed request");
        }
            request.setAttribute("searchList", flightList);
        return Path.FLIGHTS_LIST;
    }

    private Search fillSearch(HttpServletRequest req){
        Search search = new Search();
        String temp =req.getParameter("searchDepartureFlight");
        if (!temp.isEmpty()){
            search.setFrom(temp);
        }
        temp = req.getParameter("searchLandingFlight");
        if (!temp.isEmpty()){
            search.setTo(temp);
        }
        temp = req.getParameter("date");
        if (!temp.isEmpty()){
            search.setDate(temp);
        }
        return search;
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
        return sqlQuery;
    }

}
