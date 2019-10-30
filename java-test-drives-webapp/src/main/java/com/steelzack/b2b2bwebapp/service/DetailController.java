package com.steelzack.b2b2bwebapp.service;

import com.steelzack.b2b2bwebapp.config.DetailConfig;
import com.steelzack.b2b2bwebapp.model.Detail;
import com.steelzack.b2b2bwebapp.model.DetailConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by joao on 15-5-16.
 */

@Service
@ContextConfiguration(classes = DetailConfig.class, loader = AnnotationConfigContextLoader.class)
public class DetailController {

    @Autowired
    DetailService detailService;

    public Detail findDetailById(Integer id) {

        return DetailConverter.toDetail(detailService.findBetailById(id));

    }

}
