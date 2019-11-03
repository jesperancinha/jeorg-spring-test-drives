package org.jesperancinha.b2b2bwebapp.service;

import org.jesperancinha.b2b2bwebapp.model.DetailEntity;
import org.jesperancinha.b2b2bwebapp.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by joao on 15-5-16.
 */

@Service
public class DetailService {

    final DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Cacheable(value = "detailCache", key = "#id")
    public DetailEntity findBetailById(Integer id) {
        return detailRepository.findById(id).orElseThrow();
    }
}
