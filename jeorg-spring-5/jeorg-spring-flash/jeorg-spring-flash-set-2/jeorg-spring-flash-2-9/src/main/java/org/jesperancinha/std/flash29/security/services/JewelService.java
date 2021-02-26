package org.jesperancinha.std.flash29.security.services;

import org.jesperancinha.std.flash29.security.domain.Jewel;
import org.jesperancinha.std.flash29.security.dto.JewelDto;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface JewelService {

    @PreAuthorize("hasRole('ROLE_WRITE') && hasRole('ROLE_ADMIN') && #jewel.guardian != null &&  #jewel.guardian == authentication.name")
    JewelDto createJewel(final Jewel jewel);

    @PreAuthorize("hasRole('ROLE_ADMIN') && #jewel.guardian != null &&  #jewel.guardian == authentication.name")
    void updateJewel(Jewel jewel);

    @PostAuthorize("returnObject.guardian == authentication.name")
    Jewel getJewelById(final Long id);

    List<Jewel> getAll();

    @PreAuthorize("#jewel.guardian == authentication.name && hasRole('ROLE_ADMIN')")
    void deleteJewel(final Jewel jewel);
}
