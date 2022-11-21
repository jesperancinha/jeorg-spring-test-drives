package org.jesperancinha.titletextadder.app.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.jesperancinha.titletextadder.app.model.Title;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
public class JSONControllerForm {
    @RequestMapping(value = "/AddsTitle.htm", method = RequestMethod.GET)
    public String showForm() {
        return "AddsTitle";
    }

    @RequestMapping(value = "/AddsTitle.htm", method = RequestMethod.POST)
    public @ResponseBody String addTitle(@ModelAttribute(value = "title") Title title, BindingResult result)
            throws URISyntaxException {
        String returnText;
        if (!result.hasErrors()) {
            RestTemplate restTemplate = new RestTemplate();
            URI url = new URI("http://localhost:8080/title-text-adder-api/rest/tta/titles/add");
            ResponseEntity<String> response = restTemplate.postForEntity(url, title, String.class);
            returnText = //
                    "You have added title: \"". //
                            concat(title.getTitle()). //
                            concat("\" with text: \""). //
                            concat(title.getText()). //
                            concat("\" and the response is"). //
                            concat(response.getBody());

        } else {
            returnText = "An error has ocurred, it was not possible to add your title to the database";
        }
        return returnText;
    }

    @RequestMapping(value = "/ShowTitles.htm")
    public String showTitles(ModelMap model, @ModelAttribute(value = "text_filter") String textFilter)
            throws URISyntaxException {
        final RestTemplate restTemplate = new RestTemplate();
        if (textFilter == null || textFilter.isEmpty()) {
            textFilter = "*";
        }
        final URI url = new URI("http://localhost:8080/title-text-adder-api/rest/tta/titles/list/" + textFilter);
        @SuppressWarnings("rawtypes") final ResponseEntity<ArrayList> response = restTemplate.getForEntity(url, ArrayList.class);
        model.addAttribute("Titles", response.getBody());
        return "ShowTitles";
    }

}
