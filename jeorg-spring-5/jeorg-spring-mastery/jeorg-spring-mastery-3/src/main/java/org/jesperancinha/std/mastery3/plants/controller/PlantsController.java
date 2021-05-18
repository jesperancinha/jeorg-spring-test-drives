package org.jesperancinha.std.mastery3.plants.controller;

import org.jesperancinha.std.mastery3.plants.dto.PlantDto;
import org.jesperancinha.std.mastery3.plants.service.PlantService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PlantsController {

    private final PlantService plantService;

    public PlantsController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping(path = "/create/old", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PlantDto openPostFail(@RequestBody final PlantDto plantDto){
        return plantService.createPlant(plantDto.toData());
    }
}
