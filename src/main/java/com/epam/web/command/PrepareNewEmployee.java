package com.epam.web.command;

import com.epam.Path;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrepareNewEmployee extends Command {
    private static final Logger LOG = Logger.getLogger(PrepareNewEmployee.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");
        LOG.trace("This class returns to page for creating new Employee");
        LOG.debug("Command finished");
        return Path.EMPLOYEE_NEW;
    }
}
