package com.epam.dto;

import javax.servlet.http.HttpServletRequest;

public class ChangeFlightPaser {
    public static FlightDTO changeFlightDTOparser(HttpServletRequest req){
        FlightDTO dto = new FlightDTO();
        dto.setName(req.getParameter("name"));
        dto.setPlane(req.getParameter("plane"));
        dto.setDeparture_airport(req.getParameter("departure_airport"));
        dto.setLanding_airport(req.getParameter("landing_airport"));
        String d = DateTimeParser.fromTimestamp(req.getParameter("departure_time"));
        String l = DateTimeParser.fromTimestamp(req.getParameter("landing_time"));
        dto.setDeparture_time_out(d);
        dto.setLanding_time_out(l);
        return dto;
    }
}
