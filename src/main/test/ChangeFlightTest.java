
import com.epam.dao.impl.MyFlightDAO;
import com.epam.db.DBManager;
import com.epam.entity.Flight;
import com.epam.validator.FlightsValidator;
import com.epam.web.command.ChangeFlight;
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
import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class ChangeFlightTest {

    @Mock
    private MyFlightDAO flightDAO;
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
        MockitoAnnotations.initMocks(this);

        when(request.getSession()).thenReturn(session);

        when(dbManager.getConnection()).thenReturn(connection);
        when(request.getParameter("departure_time")).thenReturn("2018-02-15T10:45");
        when(request.getParameter("landing_time")).thenReturn("2018-02-15T10:45");
        when(new ChangeFlight(flightDAO,dbManager).changeFlight(request)).thenReturn(new Flight());
        when(FlightsValidator.validateChangeFlights(new Flight(),connection)).thenReturn(new ArrayList<>());
    }

    @Test
    public void test() throws IOException, ServletException {
        ChangeFlight changeFlight = new ChangeFlight(flightDAO,dbManager);
        changeFlight.execute(request,response);
    }
}
