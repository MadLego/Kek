package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MyEmployeeDAO;
import com.epam.db.DBManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployee extends Command {
    private static final Logger LOG = Logger.getLogger(DeleteEmployee.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        new MyEmployeeDAO().deleteEmployee(DBManager.getInstance().getConnection(), itemForDelete(request));

        LOG.debug("Command finished");
        return Path.EMPLOYEE_RETURN_DELETE_LIST;
    }

    private int itemForDelete(HttpServletRequest req) {
        return Integer.parseInt(req.getParameter("id"));
    }
}
