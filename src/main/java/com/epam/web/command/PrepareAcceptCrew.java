package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MySQLCrewDAO;
import com.epam.dao.impl.MySQLEmployeeDAO;
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

    MySQLCrewDAO dao;
    DBManager dbManager;


    public PrepareAcceptCrew(MySQLCrewDAO dao, DBManager dbManager) {
        this.dao=dao;
        this.dbManager = dbManager;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConnection(dbManager.getConnection());

        List<Crew> crews= dao.showAllCrew(connection);
        LOG.trace("Prepare crew list --> "+crews);
        ArrayList<CrewView> crewViews = fillCrewView(crews,connection);
        LOG.trace("Ready crew list --> "+crews);
        request.getSession().setAttribute("views",crewViews);

        TransactionManager.close(connection);

        LOG.debug("Command finished");
        return Path.CREW_LIST_ADMIN;
    }

    private ArrayList<CrewView> fillCrewView(List<Crew> crews,Connection connection) {
        ArrayList<CrewView> crewViews = new ArrayList<>();
        CrewMan crewMan;
        CrewView cw;
        for (Crew c:crews) {
            cw = new CrewView();
            cw.setId(c.getId());
            cw.setFlightId(new MyFlightDAO().searchFlighNumberById(connection,c.getFlight_id()));
            crewMan=new MySQLEmployeeDAO().selectEmployeeById(connection,c.getPilot());
            cw.setPilot(crewMan.getFirstName()+" "+crewMan.getLastName());
            crewMan=new MySQLEmployeeDAO().selectEmployeeById(connection,c.getNavigator());
            cw.setNavigator(crewMan.getFirstName()+" "+crewMan.getLastName());
            crewMan=new MySQLEmployeeDAO().selectEmployeeById(connection,c.getRadio_operator());
            cw.setRadioOperator(crewMan.getFirstName()+" "+crewMan.getLastName());
            crewMan=new MySQLEmployeeDAO().selectEmployeeById(connection,c.getFirst_conductor());
            cw.setFirstConductor(crewMan.getFirstName()+" "+crewMan.getLastName());
            crewMan=new MySQLEmployeeDAO().selectEmployeeById(connection,c.getSecond_conductor());
            cw.setSecondConductor(crewMan.getFirstName()+" "+crewMan.getLastName());
            cw.setIsPermitted(c.getIs_permitted());
            crewViews.add(cw);
        }
        return crewViews;
    }
}
