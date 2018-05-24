package com.epam.email;


import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.UnsupportedEncodingException;
import java.util.Date;


public class MailUtils {

    private static final Logger LOG = Logger.getLogger(MailUtils.class);
    private static final Session SESSION = init();
    private static final String theme = "Registration";

    private static Session init() {
        Session session = null;
        try {
            Context initialContext = new InitialContext();
            session =  (Session) initialContext.lookup("java:comp/env/mail/Session");
        } catch (Exception ex) {
            LOG.error("mail session lookup error", ex);
        }
        return session;
    }

    /**
     * Send email with information to user.
     *
     * @param email email address.
     * @param id of user
     */
    public static void sendConfirmationEmail(String email, int id) {
        try {
            Message msg = new MimeMessage(SESSION);
            msg.setFrom(new InternetAddress("jonwick1791@gmail.com"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            setContentToConfirmationEmailEng(msg,id);

            msg.setSentDate(new Date());

            Transport.send(msg);
        } catch (AddressException e) {
            LOG.error(e);
        } catch (MessagingException e) {
            LOG.error(e);
        } catch (UnsupportedEncodingException e) {
            LOG.error(e);
        }
    }

    /**
     * Set content to confirmation email.
     *
     * @param msg massage.
     *@param id id of user
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    private static void setContentToConfirmationEmailEng(Message msg, int id)
            throws MessagingException, UnsupportedEncodingException {
        msg.setSubject(theme);

        Multipart multipart = new MimeMultipart();

        InternetHeaders emailAndPass = new InternetHeaders();
        emailAndPass.addHeader("Content-type", "text/plain; charset=UTF-8");
        String messageText = "Accept <a href=\"http://localhost:8888/Last/Controller?command=activate&id="+id+"\">This</a>";

        MimeBodyPart greetingAndData = new MimeBodyPart(emailAndPass, messageText.getBytes("UTF-8"));

        multipart.addBodyPart(greetingAndData);

        msg.setContent(multipart);
    }

}