package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.dto.ChangeFlightPaser;
import com.epam.dto.FlightDTO;
import com.epam.dao.impl.MyFlightDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrepareChangeThisFlight extends Command{
    private static final Logger LOG = Logger.getLogger(PrepareChangeThisFlight.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        List<FlightDTO> list = new ArrayList<>();
        list.add(ChangeFlightPaser.changeFlightDTOparser(request));
        request.getSession().setAttribute("thisList", ChangeFlightPaser.changeFlightDTOparser(request).getName());
        request.getSession().setAttribute("airportList", new MyFlightDAO().allAirports(DBManager.getInstance().getConnection()));
        request.getSession().setAttribute("changeThisList",list);
        LOG.trace("This Flight --> "+list);

        LOG.debug("Command finished");

        return Path.FLIGHTS_CHANGE;
    }
}
