package com.epam.dao;

import com.epam.entity.Flight;
import com.epam.entity.Search;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface FlightDAO {

    List<Flight> showAllFlights(Connection connection) throws SQLException;

    List<Flight> showPrepareFlights(Connection connection) throws SQLException;

    void newFlight(Connection connection, Flight flight);

    void deleteFlight(Connection connection, String string);

    List<Flight> showFlightsSortedByName(Connection connection);

    List<Flight> showFlightsSorted(Connection connection, String query, Search search);

    ArrayList<Flight> searchFlight(Connection connection, String search);
}
