package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.entity.Flight;
import com.epam.dao.impl.MyFlightDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SortFlightByName extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Flight> flightList = new MyFlightDAO().showFlightsSortedByName(DBManager.getInstance().getConnection());
        request.setAttribute("flightList",flightList);
        return Path.FLIGHTS_LIST;
    }
}
