package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MyFlightDAO;
import com.epam.db.DBManager;
import com.epam.entity.Flight;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchFlightByAirport extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getParameter("searchDepartureFlight"));
        System.out.println(request.getParameter("airport"));
        List<Flight> flightList = new MyFlightDAO().searchFlightByAirport(DBManager.getInstance().getConnection(),request.getParameter("searchDepartureFlight"),request.getParameter("airport"));
        request.setAttribute("flightList",flightList);
        return Path.FLIGHTS_SEARCHING;
    }
}
