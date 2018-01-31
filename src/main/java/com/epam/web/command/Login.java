package com.epam.web.command;

import com.epam.Path;
import com.epam.db.DBManager;
import com.epam.entity.Operator;
import com.epam.dao.impl.MyOperatorDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends Command {
    private static final Logger LOG = Logger.getLogger(Login.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Operator operator = new MyOperatorDAO().login(DBManager.getInstance().getConnection(),request.getParameter("username"));
        LOG.trace("User"+operator);
        String result = checkLogin(operator,request);
        if (result.equals("")){
            return "/administrator";
        }
        LOG.trace("Errors --> "+result);
        request.setAttribute("loginResult",result);
        LOG.debug("Command finished");

        return Path.OPERATOR_LOGIN;
    }
    String checkLogin(Operator operator,HttpServletRequest req){
        try {
            if (operator.getLogin().equals(req.getParameter("username"))&&operator.getPassword().equals(req.getParameter("password"))){
                return "";
            }
        }catch (Exception e) {
            return "Bad parameter";
        }
        return "Bad parameter";
    }
}
