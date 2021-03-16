package org.jesperancinha.std.flash57.secured.services;

import org.jesperancinha.std.flash57.secured.domain.Throne;
import org.jesperancinha.std.flash57.secured.dto.ThroneDto;
import org.jesperancinha.std.flash57.secured.repository.ThroneRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@Service
@Profile("test")
public class ThroneServiceJsr250Impl implements ThroneService {

    private final ThroneRepository throneRepository;

    public ThroneServiceJsr250Impl(ThroneRepository throneRepository) {
        this.throneRepository = throneRepository;
    }

    /**
     * (C) reate
     *
     * @param throne
     * @return
     */
    @RolesAllowed("ROLE_RULER")
    public ThroneDto createThrone(Throne throne) {
        final Throne save = this.throneRepository.save(throne);
        final ThroneDto throneDto1 = new ThroneDto();
        throneDto1.setThroneType(save.getThroneType());
        throneDto1.setKeeper(save.getKeeper());
        return throneDto1;
    }


    /**
     * (U) pdate
     *
     * @param throne
     */
    @RolesAllowed("ROLE_RULER")
    public void updateThrone(Throne throne) {
        this.throneRepository.save(throne);
    }

    /**
     * (R) ead
     *
     * @param id
     * @return {@link Throne}
     */
    @RolesAllowed("ROLE_RULER")
    public Throne getThrone(final Long id) {
        final Throne throne = throneRepository.findById(id).orElse(null);
        ORANGE.printGenericLn(throne);
        return throne;
    }

    @RolesAllowed("ROLE_RULER")
    public List<Throne> getAll() {
        return throneRepository.findAll();
    }

    /**
     * (D) elete
     *
     * @param throne
     */
    @RolesAllowed("ROLE_RULER")
    public void deleteThrone(Throne throne) {
        throneRepository.delete(throne);
    }

    @RolesAllowed({"ROLE_RULER","ROLE_ADMIN","ROLE_DANCER"})
    public String dance() {
        return "We would Pop Champagne and Raise our tones!";
    }
}
