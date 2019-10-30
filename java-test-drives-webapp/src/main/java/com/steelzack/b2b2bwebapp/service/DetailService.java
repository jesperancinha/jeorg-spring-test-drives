package com.steelzack.b2b2bwebapp.service;

import com.steelzack.b2b2bwebapp.model.DetailEntity;
import com.steelzack.b2b2bwebapp.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by joao on 15-5-16.
 */

@Service
public class DetailService {

    @Autowired
    DetailRepository detailRepository;

    @Cacheable(value = "detailCache", key = "#id")
    public DetailEntity findBetailById(Integer id) {
        return detailRepository.findOne(id);
    }
}
