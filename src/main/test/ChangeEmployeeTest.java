
import com.epam.dao.impl.MySQLEmployeeDAO;
import com.epam.db.DBManager;
import com.epam.dto.EmployeeDTO;
import com.epam.entity.CrewMan;
import com.epam.web.command.ChangeEmployee;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class ChangeEmployeeTest {

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
    @Mock
    private CrewMan man;



    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(request.getSession()).thenReturn(session);

        when(dbManager.getConnection()).thenReturn(connection);
        when(request.getParameter("age")).thenReturn(String.valueOf(1));
        when(request.getParameter("name")).thenReturn("Name");
        when(request.getParameter("surName")).thenReturn("Name");
        when(request.getParameter("admission")).thenReturn("False");
        when(request.getParameter("age")).thenReturn(String.valueOf(20));
        when(man.getAge()).thenReturn(20);
        when(employeeDAO.fillCrewMan(eq(connection), any(EmployeeDTO.class))).thenReturn(new CrewMan());
    }
    @Test
    public void test() throws IOException, ServletException {
        ChangeEmployee changeEmployee = new ChangeEmployee(employeeDAO,dbManager);
        changeEmployee.execute(request,response);
    }
}
