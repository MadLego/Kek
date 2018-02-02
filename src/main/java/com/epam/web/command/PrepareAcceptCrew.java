package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MyCrewDAO;
import com.epam.dao.impl.MyEmployeeDAO;
import com.epam.dao.impl.MyFlightDAO;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.entity.Crew;
import com.epam.entity.CrewMan;
import com.epam.entity.CrewView;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PrepareAcceptCrew extends Command {
    private static final Logger LOG = Logger.getLogger(PrepareAcceptCrew.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConnection(DBManager.getInstance().getConnection());


        List<Crew> crews= new MyCrewDAO().showAllCrew(connection);
        LOG.trace("Prepare crew list --> "+crews);
        ArrayList<CrewView> crewViews = fillCrewView(crews);
        LOG.trace("Ready crew list --> "+crews);
        request.setAttribute("views",crewViews);

        TransactionManager.close(connection);

        LOG.debug("Command finished");
        return Path.CREW_LIST_ADMIN;
    }

    private ArrayList<CrewView> fillCrewView(List<Crew> crews) {
        ArrayList<CrewView> crewViews = new ArrayList<>();
        Connection connection = DBManager.getInstance().getConnection();
        CrewMan crewMan;
        CrewView cw;
        for (Crew c:crews) {
            cw = new CrewView();
            cw.setId(c.getId());
            cw.setFlightId(new MyFlightDAO().searchFlighNumberById(connection,c.getFlight_id()));
            crewMan=new MyEmployeeDAO().selectEmployeeById(connection,c.getPilot());
            cw.setPilot(crewMan.getFirstName()+" "+crewMan.getLastName());
            crewMan=new MyEmployeeDAO().selectEmployeeById(connection,c.getNavigator());
            cw.setNavigator(crewMan.getFirstName()+" "+crewMan.getLastName());
            crewMan=new MyEmployeeDAO().selectEmployeeById(connection,c.getRadio_operator());
            cw.setRadioOperator(crewMan.getFirstName()+" "+crewMan.getLastName());
            crewMan=new MyEmployeeDAO().selectEmployeeById(connection,c.getFirst_conductor());
            cw.setFirstConductor(crewMan.getFirstName()+" "+crewMan.getLastName());
            crewMan=new MyEmployeeDAO().selectEmployeeById(connection,c.getSecond_conductor());
            cw.setSecondConductor(crewMan.getFirstName()+" "+crewMan.getLastName());
            crewViews.add(cw);
        }
        return crewViews;
    }
}
