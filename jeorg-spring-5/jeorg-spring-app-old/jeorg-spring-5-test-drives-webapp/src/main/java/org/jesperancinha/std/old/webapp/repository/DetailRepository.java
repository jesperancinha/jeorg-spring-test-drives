package org.jesperancinha.std.old.webapp.repository;

import org.jesperancinha.std.old.webapp.model.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<DetailEntity, Integer> {

}
