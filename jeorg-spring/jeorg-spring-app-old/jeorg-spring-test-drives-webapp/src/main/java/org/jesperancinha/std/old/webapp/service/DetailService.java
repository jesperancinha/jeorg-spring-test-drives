package org.jesperancinha.std.old.webapp.service;

import org.jesperancinha.std.old.webapp.model.DetailEntity;
import org.jesperancinha.std.old.webapp.repository.DetailRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


// TODO: p0 Is placed instead of an id which is what should have been done
// However the use of #id always resulted in a null which broke the application
// Fix later, moving on now.

/**
 *
 */
@Service
public class DetailService {

    final DetailRepository detailRepository;

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }


    /**
     * @param id The id used to retrieve {@link DetailEntity}
     * @return {@link DetailEntity}
     */
    @Cacheable(value = "detailCache",
            key = "#p0")
    public DetailEntity findDetailById(Integer id) {
        return detailRepository.findById(id).orElse(null);
    }
}
