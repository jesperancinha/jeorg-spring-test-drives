package org.jesperancinha.std.flash313.bean.mapping.controllers;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/beatenGeneration.html")
public class GenerationController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) {
        final var modelAndView = new ModelAndView("generation");
        modelAndView.addObject("message", "Open your imagination");
        ConsolerizerComposer.outSpace()
                .cyan()
                .jsonPrettyPrint(modelAndView)
                .reset();
        return modelAndView;
    }
}
