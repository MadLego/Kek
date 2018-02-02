package com.epam.dao;

import com.epam.dto.FlightDTO;
import com.epam.entity.Airport;
import com.epam.entity.Flight;
import com.epam.entity.Search;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface FlightDAO {

    /**
     * Prepare to show all flights
     * @param connection connection with DB
     * @return List of flights
     */
    List<Flight> showAllFlights(Connection connection);

    /**
     * Prepare to show all flights with information for creating new flight
     * @param connection connection with DB
     * @return List of flights
     */
    List<Flight> showPrepareFlights(Connection connection);

    /**
     * Add to Database new flight
     * @param connection connection with DB
     * @param flight instance of data class with fields
     */
    void newFlight(Connection connection, Flight flight);

    /**
     * Delete from Database flight
     * @param connection connection with DB
     * @param string point what flight need to delete
     */
    void deleteFlight(Connection connection, String string);

    List<Flight> showFlightsSortedByName(Connection connection);

    /**
     * Prepare to show flight in sorted by user-defined parameters
     * @param connection connection with DB
     * @param query query created with user parameters
     * @param search instance of Data class in which the data about the selected parameters is stored
     * @return
     */
    List<Flight> showFlightsSorted(Connection connection, String query, Search search);

    /**
     * Prepare to show flight which suitable for user-specified request
     * @param connection connection with DB
     * @param search defined which flight in Database need to show
     * @return List of Flight where stored information about flights
     */
    ArrayList<Flight> searchFlight(Connection connection, String search);

    /**
     * Fill the instance of Flight class with fields from FlightDTO
     * @param con connection with DB
     * @param dto Data Transfer Object where saves and process data
     * @return instance of data class
     */
    Flight fillFlight(Connection con, FlightDTO dto) throws SQLException;

    /**
     * Prepare to show all airports for Database
     * @param connection connection with DB
     * @return List of Airport where stored information about airports
     */
    List<Airport> allAirports(Connection connection);

}
