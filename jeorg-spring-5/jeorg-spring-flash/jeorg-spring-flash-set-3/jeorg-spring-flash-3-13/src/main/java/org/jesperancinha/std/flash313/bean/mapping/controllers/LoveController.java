package org.jesperancinha.std.flash313.bean.mapping.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/love.html")
public class LoveController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("love");
        model.addObject("message", "Love is stronger than death");
        return model;
    }
}