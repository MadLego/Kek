package com.epam.dto;

import javax.servlet.http.HttpServletRequest;

public class FlightParser {
    public static FlightDTO flightDTOparser(HttpServletRequest req){
        FlightDTO dto = new FlightDTO();
        dto.setName(req.getParameter("name"));
        System.out.println(req.getParameter("name"));
        dto.setPlane(req.getParameter("plane"));
        dto.setDeparture_airport(req.getParameter("departure_airport"));
        dto.setLanding_airport(req.getParameter("landing_airport"));
        String d = req.getParameter("departure_time");
        String l = req.getParameter("landing_time");
        System.out.println(d);
        System.out.println(l);
        try {
            dto.setDeparture_time(DateTimeParser.toTimestamp(d));
            dto.setLanding_time(DateTimeParser.toTimestamp(l));
        }catch (Exception e){
            dto.setDeparture_time(DateTimeParser.toTimestampAlter(d));
            dto.setLanding_time(DateTimeParser.toTimestampAlter(l));
        }
        return dto;
    }
}
