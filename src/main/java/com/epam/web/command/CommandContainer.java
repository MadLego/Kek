package com.epam.web.command;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {

    private static final Logger LOG = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new TreeMap<>();

    static {
        commands.put("listFlight",new AllFlightsList());
        commands.put("prepareFlight",new PrepareNewFlights());
        commands.put("newFlight",new NewFlight());
        commands.put("listFlightForDelete",new PrepareDeleteFlight());
        commands.put("deleteFlight", new DeleteFlight());
        commands.put("listFlightForChange", new PrepareChangeFlight());
        commands.put("changeThisFlight", new PrepareChangeThisFlight());
        commands.put("changeFlight", new ChangeFlight());
        commands.put("prepareEmployee", new PrepareNewEmployee());
        commands.put("newEmployee", new NewEmployee());
        commands.put("listEmployeeForDelete", new PrepareDeleteEmployee());
        commands.put("deleteEmployee", new DeleteEmployee());
        commands.put("listEmployeeForChange", new PrepareChangeEmployee());
        commands.put("changeThisEmployee", new PrepareChangeThisEmployee());
        commands.put("changeEmployee", new ChangeEmployee());
        commands.put("sortFlightByName", new SortFlightByName());
        commands.put("sortFlightByNumber", new SortFlightByNumber());
        commands.put("searchFlight", new SearchFlight());
        commands.put("login", new Login());
        commands.put("registration", new Registration());
        commands.put("listCrew", new PrepareNewCrew());
        commands.put("newThisCrew", new PrepareNewThisCrew());
        commands.put("newCrew", new NewCrew());
        commands.put("listCrewAccept", new PrepareAcceptCrew());
        commands.put("acceptCrew", new AcceptCrew());
        commands.put("sampleFlight", new SortFlights());
        commands.put("logout", new Logout());
        LOG.debug("Command container was successfully initialized");
        LOG.trace("Number of commands --> " + commands.size());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOG.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
