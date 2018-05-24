package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MySQLOperatorDAO;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class ActivateAccount extends Command {
    private MySQLOperatorDAO operatorDAO;
    DBManager dbManager;

    public ActivateAccount(MySQLOperatorDAO operatorDAO, DBManager dbManager) {
        this.operatorDAO = operatorDAO;
        this.dbManager = dbManager;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection =  TransactionManager.prepareConnection(dbManager.getConnection());
        int id= Integer.parseInt(request.getParameter("id"));
        operatorDAO.activateOperatorAccount(connection,id);
        TransactionManager.close(connection);
        return Path.ACCOUNT_ACTIVATION;
    }
}
