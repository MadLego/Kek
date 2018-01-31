package com.epam.dao;


import com.epam.entity.Crew;

import java.sql.Connection;
import java.util.List;

public interface CrewDAO {

    void newCrew(Connection connection, Crew crew, int flightId);

    public List<Crew> showAllCrew(Connection connection);
}
