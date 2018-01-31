package com.epam.dto;

import javax.servlet.http.HttpServletRequest;

public class EmployeeParser {
    public static EmployeeDTO flightDTOParser(HttpServletRequest req) {
        EmployeeDTO dto = new EmployeeDTO();
        if (req.getParameter("id")!=null)
        dto.setId(Integer.parseInt(req.getParameter("id")));
        dto.setFirstName(req.getParameter("name"));
        dto.setLastName(req.getParameter("surName"));
        dto.setAge(Integer.parseInt(req.getParameter("age")));
        dto.setIsPermitter(getAdmission(req.getParameter("admission")));
        dto.setIsPemittedView(setAdmission(dto.getIsPermitter()));
        dto.setRole(req.getParameter("role"));
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
