
import com.epam.dao.impl.MySQLCrewDAO;
import com.epam.dao.impl.MySQLEmployeeDAO;
import com.epam.dao.impl.MyFlightDAO;
import com.epam.db.DBManager;
import com.epam.web.command.AcceptCrew;
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
import java.sql.Timestamp;

import static org.mockito.Mockito.when;

public class AcceptCrewTest {

    @Mock
    private MyFlightDAO flightDAO;
    @Mock
    private MySQLCrewDAO crewDAO;
    @Mock
    private MySQLEmployeeDAO employeeDAO;
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
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        when(request.getSession()).thenReturn(session);

        when(dbManager.getConnection()).thenReturn(connection);
        when(request.getParameter("admission")).thenReturn("Ok");
        when(request.getParameter("flightId")).thenReturn(String.valueOf(1));
        when(flightDAO.searchFlighNumberById(connection, Integer.parseInt(request.getParameter("flightId")))).thenReturn(String.valueOf(1));
        when(flightDAO.searchFlightTimeByNumber(connection, String.valueOf(1))).thenReturn(new Timestamp[]{new Timestamp(1),new Timestamp(2)});
    }
    @Test
    public void test() throws IOException, ServletException {
        AcceptCrew acceptCrew = new AcceptCrew(flightDAO,crewDAO,employeeDAO,dbManager);
        acceptCrew.execute(request,response);
    }
}
