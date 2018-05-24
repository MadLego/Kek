package com.epam.parser;

import com.epam.dto.FlightDTO;

import javax.servlet.http.HttpServletRequest;

public class ChangeFlightPaser {

    private static final String NAME = "name";
    private static final String PLANE = "plane";
    private static final String DEPARTURE_AIRPORT = "departure_airport";
    private static final String LANDING_AIRPORT = "landing_airport";
    private static final String DEPARTURE_TIME = "departure_time";
    private static final String LANDING_TIME = "landing_time";

    public static FlightDTO changeFlightDTOparser(HttpServletRequest req){
        FlightDTO dto = new FlightDTO();
        dto.setName(req.getParameter(NAME));
        dto.setPlane(req.getParameter(PLANE));
        dto.setDeparture_airport(req.getParameter(DEPARTURE_AIRPORT));
        dto.setLanding_airport(req.getParameter(LANDING_AIRPORT));
        String d = DateTimeParser.fromTimestamp(req.getParameter(DEPARTURE_TIME));
        String l = DateTimeParser.fromTimestamp(req.getParameter(LANDING_TIME));
        dto.setDeparture_time_out(d);
        dto.setLanding_time_out(l);
        return dto;
    }
}
