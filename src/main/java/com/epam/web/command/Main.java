package com.epam.web.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Main extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("LOL");
         Enumeration<String> e = request.getParameterNames();
         while (e.hasMoreElements()){
             System.out.println(e.nextElement());
         }
        return "/main";
    }
}
