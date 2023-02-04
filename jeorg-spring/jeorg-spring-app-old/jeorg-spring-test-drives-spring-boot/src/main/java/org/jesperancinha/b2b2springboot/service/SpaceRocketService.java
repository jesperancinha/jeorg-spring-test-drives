package org.jesperancinha.b2b2springboot.service;

import org.jesperancinha.b2b2springboot.entities.SpaceRocket;
import org.jesperancinha.b2b2springboot.entities.SpaceRocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jesperancinha on 24-5-16.
 */
@Service
public class SpaceRocketService {

    final
    SpaceRocketRepository spaceRocketRepository;

    public SpaceRocketService(SpaceRocketRepository spaceRocketRepository) {
        this.spaceRocketRepository = spaceRocketRepository;
    }

    public Iterable<SpaceRocket> getAllRockets() {
        return spaceRocketRepository.findAll();
    }

    public void deleteRocket(final Integer id) {
        spaceRocketRepository.deleteById(id);
    }

    public void addRocket(final SpaceRocket spaceRocket) {
        spaceRocketRepository.save(spaceRocket);
    }

}
