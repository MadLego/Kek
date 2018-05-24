package com.epam.parser;

import com.epam.dto.FlightDTO;

import javax.servlet.http.HttpServletRequest;

public class FlightParser {

    private static final String NAME = "name";
    private static final String PLANE = "plane";
    private static final String DEPARTURE_AIRPORT = "departure_airport";
    private static final String LANDING_AIRPORT = "landing_airport";
    private static final String DEPARTURE_TIME = "departure_time";
    private static final String LANDING_TIME = "landing_time";

    public static FlightDTO flightDTOparser(HttpServletRequest req){
        FlightDTO dto = new FlightDTO();
        dto.setName(req.getParameter(NAME));
        dto.setPlane(req.getParameter(PLANE));
        dto.setDeparture_airport(req.getParameter(DEPARTURE_AIRPORT));
        dto.setLanding_airport(req.getParameter(LANDING_AIRPORT));
        String d = req.getParameter(DEPARTURE_TIME);
        String l = req.getParameter(LANDING_TIME);
        d = DateTimeParser.troubleWithChange(d);
        l = DateTimeParser.troubleWithChange(l);
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
