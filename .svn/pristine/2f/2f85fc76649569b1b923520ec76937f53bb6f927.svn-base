package com.epam.parser;

import com.epam.dto.EmployeeDTO;

import javax.servlet.http.HttpServletRequest;

public class EmployeeParser {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SUR_NAME = "surName";
    private static final String AGE = "age";
    private static final String ADMISSION = "admission";
    private static final String ROLE = "role";

    public static EmployeeDTO flightDTOParser(HttpServletRequest req) {
        EmployeeDTO dto = new EmployeeDTO();
        if (req.getParameter(ID)!=null)
        dto.setId(Integer.parseInt(req.getParameter(ID)));
        dto.setFirstName(req.getParameter(NAME));
        dto.setLastName(req.getParameter(SUR_NAME));
        dto.setAge(Integer.parseInt(req.getParameter(AGE)));
        dto.setIsPermitter(getAdmission(req.getParameter(ADMISSION)));
        dto.setIsPemittedView(setAdmission(dto.getIsPermitter()));
        dto.setRole(req.getParameter(ROLE));
        return dto;
    }
    public static int getAdmission(String string){
        if (string.equals("False")) {
            return 0;
        }
        return 1;
    }

    public static String setAdmission(int i){
        if (i==0){
            return "False";
        }
        return "True";
    }

}
