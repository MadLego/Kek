package com.epam.captcha;


import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.renderer.DefaultWordRenderer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyCaptcha {
    public static void doCaptcha(HttpServletRequest req, HttpServletResponse resp){
        List<Color> colors = new ArrayList<Color>();
        colors.add(Color.black);
        colors.add(Color.red);

        java.util.List<Font> fonts = new ArrayList<Font>();
        fonts.add(new Font("Arial", Font.ITALIC, 40));

        Captcha captcha = new Captcha.Builder(120, 50)
                .addText(new DefaultWordRenderer(colors, fonts))
                .addBackground(new GradiatedBackgroundProducer(Color.white, Color.white))
                .gimp()
                .addBorder()
                .build();

        req.getSession().setAttribute("simpleCaptcha", captcha);

        CaptchaServletUtil.writeImage(resp, captcha.getImage());
    }
}
