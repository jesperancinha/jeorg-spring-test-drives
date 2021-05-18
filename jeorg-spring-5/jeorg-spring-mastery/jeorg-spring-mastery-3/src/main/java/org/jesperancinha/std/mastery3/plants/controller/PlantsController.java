package org.jesperancinha.std.mastery3.plants.controller;

import org.jesperancinha.std.mastery3.plants.dto.PlantDto;
import org.jesperancinha.std.mastery3.plants.service.PlantService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/")
public class PlantsController {

    private final PlantService plantService;

    private final PlantDto yucca;
    private final PlantDto yohoo;
    private final PlantDto yuppi;

    public PlantsController(PlantService plantService, PlantDto yucca, PlantDto yohoo, PlantDto yuppi) {
        this.plantService = plantService;
        this.yucca = yucca;
        this.yohoo = yohoo;
        this.yuppi = yuppi;
    }

    @PostMapping(path = "/create/old",
            consumes = APPLICATION_JSON_VALUE)
    public PlantDto openPostFail(
            @RequestBody
            final PlantDto plantDto) {
        return plantService.createPlant(plantDto.toData());
    }

    @GetMapping(path = "/list/copies", produces = APPLICATION_JSON_VALUE)
    public List<PlantDto> get3Copies() {
        return List.of(yucca, yohoo, yuppi);
    }
}
