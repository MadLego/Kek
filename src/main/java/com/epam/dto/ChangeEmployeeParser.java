package com.epam.dto;

import javax.servlet.http.HttpServletRequest;

public class ChangeEmployeeParser {
    public static EmployeeDTO changeEmployeeDTOparser(HttpServletRequest req){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(Integer.parseInt(req.getParameter("id")));
        dto.setFirstName(req.getParameter("name"));
        dto.setLastName(req.getParameter("surName"));
        dto.setAge(Integer.parseInt(req.getParameter("age")));
        dto.setIsPemittedView(req.getParameter("permission"));
        dto.setRole(req.getParameter("role"));
        return dto;
    }
}
