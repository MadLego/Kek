package com.epam.listener;

import com.epam.dao.impl.MySQLCrewDAO;
import com.epam.dao.impl.MySQLEmployeeDAO;
import com.epam.dao.impl.MyFlightDAO;
import com.epam.dao.impl.MySQLOperatorDAO;
import com.epam.db.DBManager;
import com.epam.web.command.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;
import java.util.TreeMap;

public class ContextListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(ContextListener.class);

    public void contextDestroyed(ServletContextEvent event) {
        log("Servlet context destruction starts");
        // no op
        log("Servlet context destruction finished");
    }

    public void contextInitialized(ServletContextEvent event) {
        log("Servlet context initialization starts");

        ServletContext servletContext = event.getServletContext();
        initLog4J(servletContext);
        initCommandContainer();
        initCommands(servletContext);

        log("Servlet context initialization finished");
    }


    private void initCommands(ServletContext servletContext){
        Map<String, Command> commands = new TreeMap<>();

        DBManager dbManager = new DBManager();

        MySQLCrewDAO crewDAO = new MySQLCrewDAO();
        MySQLOperatorDAO operatorDAO = new MySQLOperatorDAO();
        MyFlightDAO flightDAO = new MyFlightDAO();
        MySQLEmployeeDAO employeeDAO = new MySQLEmployeeDAO();

        commands.put("listFlight",new AllFlightsList(flightDAO,dbManager));
        commands.put("prepareFlight",new PrepareNewFlights(flightDAO,dbManager));
        commands.put("newFlight",new NewFlight(flightDAO,dbManager));
        commands.put("listFlightForDelete",new PrepareDeleteFlight(flightDAO,dbManager));
        commands.put("deleteFlight", new DeleteFlight(flightDAO,dbManager));
        commands.put("listFlightForChange", new PrepareChangeFlight(flightDAO,dbManager));
        commands.put("changeThisFlight", new PrepareChangeThisFlight(flightDAO,dbManager));
        commands.put("changeFlight", new ChangeFlight(flightDAO,dbManager));
        commands.put("prepareEmployee", new PrepareNewEmployee());
        commands.put("newEmployee", new NewEmployee(employeeDAO,dbManager));
        commands.put("listEmployeeForDelete", new PrepareDeleteEmployee(employeeDAO,dbManager));
        commands.put("deleteEmployee", new DeleteEmployee(employeeDAO,dbManager));
        commands.put("listEmployeeForChange", new PrepareChangeEmployee(employeeDAO,dbManager));
        commands.put("changeThisEmployee", new PrepareChangeThisEmployee(employeeDAO,dbManager));
        commands.put("changeEmployee", new ChangeEmployee(employeeDAO,dbManager));
        commands.put("sortFlightByName", new SortFlightByName(flightDAO,dbManager));
        commands.put("sortFlightByNumber", new SortFlightByNumber());
        commands.put("searchFlight", new SearchFlight(flightDAO,dbManager));
        commands.put("login", new Login(operatorDAO,dbManager));
        commands.put("registration", new Registration(operatorDAO,dbManager));
        commands.put("listCrew", new PrepareNewCrew(flightDAO,dbManager));
        commands.put("newThisCrew", new PrepareNewThisCrew(employeeDAO,dbManager));
        commands.put("newCrew", new NewCrew(crewDAO,dbManager));
        commands.put("listCrewAccept", new PrepareAcceptCrew(crewDAO,dbManager));
        commands.put("acceptCrew", new AcceptCrew(flightDAO,crewDAO,employeeDAO,dbManager));
        commands.put("sampleFlight", new SortFlights(flightDAO,dbManager));
        commands.put("logout", new Logout());
        commands.put("activate", new ActivateAccount(operatorDAO,dbManager));
        commands.put("task", new Task(employeeDAO,crewDAO,dbManager));

        CommandContainer commandContainer = new CommandContainer(commands);

        servletContext.setAttribute("commandContainer",commandContainer);
    }


    /**
     * Initializes log4j framework.
     *
     * @param servletContext
     */
    private void initLog4J(ServletContext servletContext) {
        log("Log4J initialization started");
        try {
            PropertyConfigurator.configure(
                    servletContext.getRealPath("WEB-INF/log4j.properties"));
            LOG.debug("Log4j has been initialized");
        } catch (Exception ex) {
            log("Cannot configure Log4j");
            ex.printStackTrace();
        }
        log("Log4J initialization finished");
    }

    /**
     * Initializes CommandContainer.
     */
    private void initCommandContainer() {

        // initialize commands container
        // just load class to JVM
        try {
            Class.forName("com.epam.web.command.CommandContainer");
        } catch (ClassNotFoundException ex) {
            throw new IllegalStateException("Cannot initialize Command Container");
        }
    }

    private void log(String msg) {
        System.out.println("[ContextListener] " + msg);
    }
}
