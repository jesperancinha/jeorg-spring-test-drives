package org.jesperancinha.std.flash313.bean.mapping.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/beatenGeneration.html")
public class GenerationController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("generation");
        model.addObject("message", "Open your imagination");
        return model;
    }
}
