package org.jesperancinha.titletextadder.app.controller;

import org.jesperancinha.titletextadder.app.model.Title;
import org.jesperancinha.titletextadder.app.service.SolrTitleDao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JSONControllerForm {

    private final SolrTitleDao solrTitleDao;

    public JSONControllerForm(SolrTitleDao solrTitleDao) {
        this.solrTitleDao = solrTitleDao;
    }

    @RequestMapping(value = "/AddsTitle.htm", method = RequestMethod.GET)
    public String showForm() {
        return "AddsTitle";
    }

    @RequestMapping(value = "/AddsTitle.htm", method = RequestMethod.POST)
    public @ResponseBody String addTitle(@ModelAttribute(value = "title") Title title, BindingResult result) {
        if (!result.hasErrors()) {
            return solrTitleDao.sendTitle(title);
        } else {
            return "An error has ocurred, it was not possible to add your title to the database";
        }
    }

    @RequestMapping(value = "/ShowTitles.htm")
    public String showTitles(ModelMap model, @ModelAttribute(value = "text_filter") String textFilter) {
        final ResponseEntity<String[]> response = solrTitleDao.getTitlesByTextFilter(textFilter);
        model.addAttribute("Titles", response.getBody());
        return "ShowTitles";
    }
}
