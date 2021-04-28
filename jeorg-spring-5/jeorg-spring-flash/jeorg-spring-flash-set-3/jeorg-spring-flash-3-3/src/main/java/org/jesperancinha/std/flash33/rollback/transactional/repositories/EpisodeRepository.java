package org.jesperancinha.std.flash33.rollback.transactional.repositories;

import org.jesperancinha.std.flash33.rollback.transactional.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
