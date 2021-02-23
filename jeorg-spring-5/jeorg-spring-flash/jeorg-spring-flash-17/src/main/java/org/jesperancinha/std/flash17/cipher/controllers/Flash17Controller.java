package org.jesperancinha.std.flash17.cipher.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;

@Controller
public class Flash17Controller {

    @RequestMapping("/**")
    public ModelAndView genericHandle(final Model model) {
        final var authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();
        YELLOW.printGenericLn("This is the object we are analyzing %s", authentication);
        model
                .addAttribute("name", authentication.getName())
                .addAttribute("roles", authentication.getAuthorities());
        return new ModelAndView("userdata");
    }
}
