
import com.epam.dao.impl.MySQLCrewDAO;
import com.epam.db.DBManager;
import com.epam.parser.CrewParser;
import com.epam.entity.Crew;
import com.epam.validator.CrewValidator;
import com.epam.web.command.NewCrew;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class NewCrewTest {
    @Mock
    private MySQLCrewDAO crewDAO;
    @Mock
    private DBManager dbManager;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private Connection connection;

    @Before
    public void setUp() {
        NewCrew newCrew= new NewCrew(crewDAO,dbManager);

        MockitoAnnotations.initMocks(this);

        when(request.getSession()).thenReturn(session);

        when(dbManager.getConnection()).thenReturn(connection);
        when(newCrew.newCrew(request)).thenReturn(new Crew());
        when(request.getParameter(eq("flightId"))).thenReturn(String.valueOf(1));
        when(crewDAO.fillCrew(CrewParser.crewDTOParser(request))).thenReturn(new Crew());
        when(new CrewValidator().validate(new Crew(),newCrew.newCrewList(request), Integer.parseInt(request.getParameter("flightId")))).thenReturn("Name");
    }
    @Test
    public void test() throws IOException, ServletException {
        NewCrew newCrew = new NewCrew(crewDAO,dbManager);
        newCrew.execute(request,response);
    }
}
