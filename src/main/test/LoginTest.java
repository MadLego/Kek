
import com.epam.dao.impl.MySQLOperatorDAO;
import com.epam.db.DBManager;
import com.epam.entity.Operator;
import com.epam.web.command.Login;
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

import static org.mockito.Mockito.when;

public class LoginTest {

    @Mock
    MySQLOperatorDAO operatorDAO;
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
        when(request.getParameter("username")).thenReturn("Name");
        when(operatorDAO.login(connection,request.getParameter("name"))).thenReturn(new Operator());
        when(new Login(operatorDAO,dbManager).checkLogin(new Operator(),request)).thenReturn("");
    }
    @Test
    public void test() throws IOException, ServletException {
        Login login = new Login(operatorDAO,dbManager);
        login.execute(request,response);
    }
}
