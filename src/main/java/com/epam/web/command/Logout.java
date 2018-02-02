package com.epam.web.command;

import com.epam.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().removeAttribute("userRole");
        request.getSession().removeAttribute("userRoleName");
        return Path.OPERATOR_LOGIN;
    }
}
