
import com.epam.dao.impl.MySQLEmployeeDAO;
import com.epam.db.DBManager;
import com.epam.parser.EmployeeParser;
import com.epam.entity.CrewMan;
import com.epam.validator.EmployeesValidator;
import com.epam.web.command.NewEmployee;
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

public class NewEmployeeTest {

    @Mock
    MySQLEmployeeDAO employeeDAO;
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

        when(request.getParameter("age")).thenReturn(String.valueOf(1));
        when(EmployeeParser.getAdmission("Name")).thenReturn(1);
        when(dbManager.getConnection()).thenReturn(connection);
        when(employeeDAO.fillCrewMan(connection, EmployeeParser.flightDTOParser(request))).thenReturn(new CrewMan());
        when(new NewEmployee(employeeDAO,dbManager).newEmployee(request)).thenReturn(new CrewMan());
        when(EmployeesValidator.validateEmployee(new CrewMan())).thenReturn(new ArrayList<>());
    }
    @Test
    public void test() throws IOException, ServletException {
       NewEmployee newEmployee = new NewEmployee(employeeDAO,dbManager);
       newEmployee.execute(request,response);
    }
}
