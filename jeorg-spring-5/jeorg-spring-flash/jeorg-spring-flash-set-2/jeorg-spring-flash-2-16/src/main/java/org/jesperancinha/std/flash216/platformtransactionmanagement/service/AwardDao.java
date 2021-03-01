package org.jesperancinha.std.flash216.platformtransactionmanagement.service;

import org.jesperancinha.std.flash216.platformtransactionmanagement.domain.Award;

import java.time.LocalDateTime;
import java.util.List;

public interface AwardDao {


    void createTables();

    Award create(String artist, String award, LocalDateTime awardDateTime);

    List<Award> listAwards();
}
