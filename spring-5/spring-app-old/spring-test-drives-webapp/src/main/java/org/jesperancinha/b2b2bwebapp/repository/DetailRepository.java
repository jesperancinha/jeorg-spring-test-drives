package org.jesperancinha.b2b2bwebapp.repository;

import org.jesperancinha.b2b2bwebapp.model.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<DetailEntity, Integer> {

}
