package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.dao.impl.MyFlightDAO;
import com.epam.db.TransactionManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class DeleteFlight extends Command {
    private static final Logger LOG = Logger.getLogger(DeleteFlight.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");
        Connection connection = TransactionManager.prepareConection(DBManager.getInstance().getConnection());

        LOG.trace("Item for delete -->"+itemForDelete(request));
        new MyFlightDAO().deleteFlight(DBManager.getInstance().getConnection(), itemForDelete(request));

        TransactionManager.close(connection);
        LOG.debug("Command finished");
        return Path.FLIGHTS_LIST_FOR_DELETE;
    }

    private String itemForDelete(HttpServletRequest req){
        return req.getParameter("name");
    }
}
