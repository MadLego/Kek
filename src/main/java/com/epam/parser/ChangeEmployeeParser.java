package com.epam.parser;

import com.epam.dto.EmployeeDTO;

import javax.servlet.http.HttpServletRequest;

public class ChangeEmployeeParser {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SUR_NAME = "surName";
    private static final String AGE = "age";
    private static final String PERMISSION = "permission";
    private static final String ROLE = "role";

    public static EmployeeDTO changeEmployeeDTOparser(HttpServletRequest req){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(Integer.parseInt(req.getParameter(ID)));
        dto.setFirstName(req.getParameter(NAME));
        dto.setLastName(req.getParameter(SUR_NAME));
        dto.setAge(Integer.parseInt(req.getParameter(AGE)));
        dto.setIsPemittedView(req.getParameter(PERMISSION));
        dto.setRole(req.getParameter(ROLE));
        return dto;
    }
}
