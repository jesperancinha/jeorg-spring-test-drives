package com.steelzack.b2b2springboot.service;

import com.steelzack.b2b2springboot.entities.SpaceRocket;
import com.steelzack.b2b2springboot.entities.SpaceRocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jesperancinha on 24-5-16.
 */
@Service
public class SpaceRocketService {

    @Autowired
    SpaceRocketRepository spaceRocketRepository;

    public Iterable<SpaceRocket> getAllRockets() {
        return spaceRocketRepository.findAll();
    }

    public void deleteRocket(final Integer id) {
        spaceRocketRepository.delete(id);
    }

    public void addRocket(final SpaceRocket spaceRocket) {
        spaceRocketRepository.save(spaceRocket);
    }

}
