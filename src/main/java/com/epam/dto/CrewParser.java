package com.epam.dto;

import javax.servlet.http.HttpServletRequest;

public class CrewParser {
    public static CrewDTO crewDTOParser(HttpServletRequest req){
        CrewDTO dto = new CrewDTO();
        dto.setFlight_id(Integer.parseInt(req.getParameter("flightId")));
        dto.setPilot(Integer.parseInt(req.getParameter("pilot")));
        dto.setNavigator(Integer.parseInt(req.getParameter("navigator")));
        dto.setRadio_operator(Integer.parseInt(req.getParameter("radio_operator")));
        try {
            dto.setFirst_conductor(Integer.parseInt(req.getParameter("fConductor")));
            dto.setSecond_conductor(Integer.parseInt(req.getParameter("sConductor")));
            if (dto.getFirst_conductor()==dto.getSecond_conductor()){
                throw new IllegalArgumentException();
            }
        }catch (Exception ignored){

        }
        return dto;
    }
}
