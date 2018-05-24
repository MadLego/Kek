
import com.epam.dao.impl.MyFlightDAO;
import com.epam.db.DBManager;
import com.epam.web.command.DeleteFlight;
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

public class DeleteFlightTest {

    @Mock
    private
    MyFlightDAO myFlightDAO;
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
        when(request.getParameter("name")).thenReturn("Name");
        when(myFlightDAO.showAllFlights(connection)).thenReturn(new ArrayList<>());
    }
    @Test
    public void test() throws IOException, ServletException {
        DeleteFlight deleteFlight = new DeleteFlight(myFlightDAO,dbManager);
        deleteFlight.execute(request,response);
    }
}
