package org.jesperancinha.std.flash38.model.controller;

import org.jesperancinha.console.consolerizer.ConsolerizerColor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CharmingManController {

    @ModelAttribute(name = "modelOfTheCharmlessMan")
    public List<String> modelOfTheCharmlessMan() {
        final var modelOfTheCharmlessMan = new ArrayList<String>();
        modelOfTheCharmlessMan.add("He moves in circles of friends");
        modelOfTheCharmlessMan.add("Who just pretend that they like him");
        modelOfTheCharmlessMan.add("He does the same to them");
        modelOfTheCharmlessMan.add("And when you put it all together");
        modelOfTheCharmlessMan.add("There's the model of a charmless man");
        return modelOfTheCharmlessMan;
    }

    @RequestMapping("/")
    public ModelAndView goToIndex(final Model model, @ModelAttribute("modelOfTheCharmlessMan")
            final List<String> modelOfTheCharmlessMan) {
        ConsolerizerColor.MAGENTA.printGenericLn("This is one way of getting a model attribute.");
        ConsolerizerColor.MAGENTA.printGenericLn("It can be passed around and changed in the JSP.");
        ConsolerizerColor.MAGENTA.printGenericLn("As an example here is the model of a charmless man:");
        ConsolerizerColor.GREEN.printGenericLn(modelOfTheCharmlessMan);
        return new ModelAndView("index");
    }
}
