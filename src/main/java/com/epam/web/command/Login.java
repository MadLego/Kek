package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MySQLOperatorDAO;
import com.epam.db.DBManager;
import com.epam.db.Role;
import com.epam.db.TransactionManager;
import com.epam.entity.Operator;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class Login extends Command {
    private static final Logger LOG = Logger.getLogger(Login.class);

    MySQLOperatorDAO dao;
    DBManager dbManager;

    public Login(MySQLOperatorDAO dao, DBManager dbManager) {
        this.dao = dao;
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConnection(dbManager.getConnection());

        Operator operator = dao.login(connection,request.getParameter("username").trim());
        LOG.trace("User"+operator);
        String result = checkLogin(operator,request);
        if (result.equals("")){
            request.getSession().setAttribute("userRole", Role.getRole(operator));
            request.getSession().setAttribute("userRoleName", Role.getRole(operator).getName());
            return "/main";
        }
        LOG.trace("Errors --> "+result);
        request.getSession().setAttribute("loginResult",result);

        TransactionManager.close(connection);

        LOG.debug("Command finished");
        return Path.OPERATOR_LOGIN;
    }
    public String checkLogin(Operator operator,HttpServletRequest req){
        try {
            if (operator.getLogin().equals(req.getParameter("username"))&&operator.getPassword().equals(hashPassword(req.getParameter("password")))){
                return "";
            }
        }catch (Exception e) {
            return "Bad parameter";
        }
        return "Illegal arguments";
    }

    private String hashPassword(String password){
        return DigestUtils.md5Hex(password);
    }
}
