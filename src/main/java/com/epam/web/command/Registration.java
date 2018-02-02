package com.epam.web.command;

import com.epam.Path;
import com.epam.dao.impl.MyOperatorDAO;
import com.epam.db.DBManager;
import com.epam.db.TransactionManager;
import com.epam.dto.OperatorParser;
import com.epam.entity.Operator;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class Registration extends Command {
    private static final Logger LOG = Logger.getLogger(Registration.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Connection connection = TransactionManager.prepareConnection(DBManager.getInstance().getConnection());

        MyOperatorDAO dao = new MyOperatorDAO();
        Operator o = dao.fillOperator(OperatorParser.operatorDTOparser(request));
        o.setPassword(hashPassword(o.getPassword()));
        boolean val = answerCaptcha(request);
        if (!val){
            request.setAttribute("validate","Wrong captcha");
            LOG.trace("Wrong captcha");
            return Path.OPERATOR_REGISTRATION;
        }
        String attr = dao.registration(connection,o);
        o.setPassword(hashPassword(o.getPassword()));
        if (attr.equals("Bad idea")){
            request.setAttribute("validate","Illegal argument for registration");
            LOG.trace("Illegal argument for registration");
            return Path.OPERATOR_REGISTRATION;
        }
        LOG.debug("Command finished");
        return Path.OPERATOR_LOGIN;
    }

    boolean answerCaptcha(HttpServletRequest request){
        String reqCaptcha = request.getParameter("captcha");
        return reqCaptcha.equals(request.getSession().getAttribute("answer"));
    }

    private String hashPassword(String password){
        return DigestUtils.md5Hex(password);
    }
}
