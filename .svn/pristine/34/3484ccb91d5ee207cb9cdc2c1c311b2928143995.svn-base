package com.epam.parser;

import com.epam.dto.CrewDTO;

import javax.servlet.http.HttpServletRequest;

public class CrewParser {

    private static final String FLIGHT_ID = "flightId";
    private static final String PILOT = "pilot";
    private static final String NAVIGATOR = "navigator";
    private static final String RADIO_OPERATOR = "radio_operator";
    private static final String F_CONDUCTOR = "fConductor";
    private static final String S_CONDUCTOR = "sConductor";

    public static CrewDTO crewDTOParser(HttpServletRequest req){
        CrewDTO dto = new CrewDTO();
        dto.setFlight_id(Integer.parseInt(req.getParameter(FLIGHT_ID)));
        dto.setPilot(Integer.parseInt(req.getParameter(PILOT)));
        dto.setNavigator(Integer.parseInt(req.getParameter(NAVIGATOR)));
        dto.setRadio_operator(Integer.parseInt(req.getParameter(RADIO_OPERATOR)));
        try {
            dto.setFirst_conductor(Integer.parseInt(req.getParameter(F_CONDUCTOR)));
            dto.setSecond_conductor(Integer.parseInt(req.getParameter(S_CONDUCTOR)));
            if (dto.getFirst_conductor()==dto.getSecond_conductor()){
                throw new IllegalArgumentException();
            }
        }catch (Exception ignored){

        }
        return dto;
    }
}
