package com.epam.tag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class LanguageTag extends TagSupport {

    public int doStartTag() throws JspTagException {
        try {
            pageContext.getOut().write("<form action=\"Controller?command=main\" method=\"post\">");
            pageContext.getOut().write("<input type=\"button\" value=\"Ru\"/>");
            pageContext.getOut().write("<input type=\"button\" value=\"En\"/>");
            pageContext.getOut().write("</form>");
        } catch (IOException e) {
            throw new JspTagException(e.getMessage());
        }
        return SKIP_BODY;
    }
}
