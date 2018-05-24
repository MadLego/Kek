package com.epam.dao;


import com.epam.dto.CrewDTO;
import com.epam.entity.Crew;

import java.sql.Connection;
import java.util.List;

public interface CrewDAO {
    /**
     * Create new crew with crew members in Data Base
     * @param connection connection with DB
     * @param crew an instance of the data class
     * @param flightId flight ID for which the team will be assigned
     */
    void newCrew(Connection connection, Crew crew, int flightId);

    /**
     * Prepare to show all available crews
     * @param connection connection with DB
     * @return List of Crews
     */
    List<Crew> showAllCrew(Connection connection);

    /**
     * Transferring data from DTO to Entity
     * @param crewDTO Data Transfer Object where saves and process data
     * @return instance of data class
     */
    Crew fillCrew(CrewDTO crewDTO);

}
