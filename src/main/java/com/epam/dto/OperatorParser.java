package com.epam.dto;

import javax.servlet.http.HttpServletRequest;

public class OperatorParser {
    public static OperatorDTO operatorDTOparser(HttpServletRequest req){
        OperatorDTO dto = new OperatorDTO();
        dto.setEmail(req.getParameter("email"));
        dto.setLogin(req.getParameter("login"));
        dto.setPassword(req.getParameter("password"));
        return dto;
    }
}
