package org.jesperancinha.std.flash29.security.controller;

import org.jesperancinha.std.flash29.security.domain.Jewel;
import org.jesperancinha.std.flash29.security.dto.JewelDto;
import org.jesperancinha.std.flash29.security.services.JewelService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;

@Controller
public class Flash29Controller {

    private final JewelService jewelService;

    public Flash29Controller(JewelService jewelService) {
        this.jewelService = jewelService;
    }

    @RequestMapping("/")
    public ModelAndView genericHandle(final Model model) {
        final var authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();
        YELLOW.printGenericLn("This is the object we are analyzing %s", authentication);
        model
                .addAttribute("name", authentication.getName())
                .addAttribute("roles", authentication.getAuthorities());
        return new ModelAndView("ownedjewels");
    }

    @GetMapping("/jewels")
    public @ResponseBody
    List<Jewel> listJewels() {
        return jewelService.getAll();
    }

    @GetMapping("/jewels/{id}")
    public @ResponseBody
    Jewel jewel(
            @PathVariable
                    Long id) {
        return jewelService.getJewelById(id);
    }

    @PostMapping(path = "/jewels", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JewelDto> Jewel(
            @RequestBody
                    JewelDto jewelDto) {
        Jewel jewel = new Jewel();
        jewel.setJewelType(jewelDto.getJewelType());
        jewel.setGuardian(jewelDto.getGuardian());
        final JewelDto jewel1 = jewelService.createJewel(jewel);
        GREEN.printGenericLn("Created jewel -> %s", jewel1);
        return ResponseEntity.ok().body(jewel1);
    }

    @DeleteMapping("/jewels/{id}")
    public @ResponseBody
    void removeJewel(
            @PathVariable
                    Long id) {
        final Jewel jewelById = jewelService.getJewelById(id);
        jewelService.deleteJewel(jewelById);
        RED.printGenericLn("Removed jewel -> %d", id);
    }
}
