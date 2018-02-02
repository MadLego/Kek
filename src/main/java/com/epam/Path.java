package com.epam;

public class Path{

    public static final String FLIGHTS_LIST = "/flights";
    public static final String FLIGHTS_CHANGE= "/changeFlight";
    public static final String FLIGHTS_LIST_FOR_DELETE = "/listDeleteFlights";
    public static final String FLIGHTS_LIST_FOR_CHANGE = "/listChangeFlights";
    public static final String FLIGHTS_NEW = "/newFlight";
    public static final String FLIGHTS_SEARCHING = "/searchingFlight";
    public static final String PAGE_ERROR_PAGE="/errors";
    public static final String FLIGHT_RETURN_LIST_FOR_CHANGE="Controller?command=listFlightForChange";
    public static final String FLIGHT_RETURN_LIST="Controller?command=listFlight";

    public static final String EMPLOYEE_NEW="/newEmployee";
    public static final String EMPLOYEES_LIST_FOR_DELETE ="/listDeleteEmployees";
    public static final String EMPLOYEE_LIST_FOR_CHANGE = "/listChangeEmployee";
    public static final String EMPLOYEE_CHANGE= "/changeEmployee";
    public static final String EMPLOYEE_RETURN_CHANGE_LIST= "/Controller?command=listEmployeeForChange";
    public static final String EMPLOYEE_RETURN_DELETE_LIST= "/Controller?command=listEmployeeForDelete";
    public static final String EMPLOYEE_PREPARE_NEW= "/Controller?command=prepareEmployee";

    public static final String OPERATOR_LOGIN= "/login";
    public static final String OPERATOR_REGISTRATION="/registration";

    public static final String CREW_LIST = "/newCrewList";
    public static final String CREW_THIS = "/newCrew";
    public static final String CREW_RETURN_LIST = "/Controller?command=listCrew";
    public static final String CREW_LIST_ADMIN = "/admissionCrew";
    public static final String CREW_RETURN_LIST_CREW= "/Controller?command=listCrewAccept";
}
