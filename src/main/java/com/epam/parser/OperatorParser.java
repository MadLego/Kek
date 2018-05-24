package com.epam.parser;

import com.epam.dto.OperatorDTO;

import javax.servlet.http.HttpServletRequest;

public class OperatorParser {

    private static final String EMAIL = "email";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    public static OperatorDTO operatorDTOparser(HttpServletRequest req){
        OperatorDTO dto = new OperatorDTO();
        dto.setEmail(req.getParameter(EMAIL));
        dto.setLogin(req.getParameter(LOGIN));
        dto.setPassword(req.getParameter(PASSWORD));
        return dto;
    }
}
