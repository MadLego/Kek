
import com.epam.dao.impl.MySQLCrewDAO;
import com.epam.db.DBManager;
import com.epam.web.command.PrepareAcceptCrew;
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

public class PrepareAcceptCrewTest {
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
        MockitoAnnotations.initMocks(this);

        when(request.getSession()).thenReturn(session);
        when(dbManager.getConnection()).thenReturn(connection);
        when(crewDAO.showAllCrew(connection)).thenReturn(new ArrayList<>());
    }

    @Test
    public void test() throws IOException, ServletException {
        PrepareAcceptCrew prepareAcceptCrew = new PrepareAcceptCrew(crewDAO,dbManager);
        prepareAcceptCrew.execute(request,response);
    }
}
