package com.epam.web;


import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.renderer.DefaultWordRenderer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCaptcha extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        java.util.List<Color> colors = new ArrayList<Color>();
        colors.add(Color.black);
        colors.add(Color.red);

        List<Font> fonts = new ArrayList<Font>();
        fonts.add(new Font("Arial", Font.ITALIC, 40));

        Captcha captcha = new Captcha.Builder(120, 50)
                .addText(new DefaultWordRenderer(colors, fonts))
                .addBackground(new GradiatedBackgroundProducer(Color.white, Color.white))
                .gimp()
                .addBorder()
                .build();
        request.getSession().setAttribute("answer",captcha.getAnswer());

        request.getSession().setAttribute("simpleCaptcha", captcha);

        // display the image produced
        CaptchaServletUtil.writeImage(response, captcha.getImage());

        // save the captcha value on session
    }

}
