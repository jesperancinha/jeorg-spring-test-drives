package org.jesperancinha.std.old.webapp.service;

import org.jesperancinha.std.old.webapp.model.DetailEntity;
import org.jesperancinha.std.old.webapp.repository.DetailRepository;
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

    @Cacheable(value = "detailCache",
            key = "#id")
    public DetailEntity findDetailById(Integer id) {
        return detailRepository.findById(id).orElseThrow();
    }
}
