package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MyCrewDAO;
import com.epam.dao.impl.MyEmployeeDAO;
import com.epam.dao.impl.MyFlightDAO;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AcceptCrew extends Command {

    private static final Logger LOG = Logger.getLogger(AcceptCrew.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = TransactionManager.prepareConnection(DBManager.getInstance().getConnection());
        LOG.debug("Command starts");
        String decision = request.getParameter("admission");

        LOG.trace("Decision of user: menuItemsList --> " + decision);

        int flightId = new MyFlightDAO().searchFlightIdByNumber(connection, request.getParameter("flightId"));

        new MyCrewDAO().acceptAdmission(connection, flightId, decision);

        Timestamp[] time = new MyFlightDAO().searchFlightTimeByNumber(connection, request.getParameter("flightId"));
        new MyEmployeeDAO().setAdmission(connection, decision, time);
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        LOG.debug("Command finished");
        TransactionManager.close(connection);
        return Path.CREW_RETURN_LIST_CREW;
    }

}
