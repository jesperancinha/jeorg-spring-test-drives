package org.jesperancinha.std.old.webapp.service;

import org.jesperancinha.std.old.webapp.model.Detail;
import org.jesperancinha.std.old.webapp.model.DetailConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joao on 15-5-16.
 */

@Service
public class DetailController {

    @Autowired
    DetailService detailService;

    public Detail findDetailById(Integer id) {

        return DetailConverter.toDetail(detailService.findBetailById(id));

    }

}
