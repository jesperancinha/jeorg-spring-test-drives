package org.jesperancinha.std.flash29.security.services;

import org.jesperancinha.std.flash29.security.domain.Jewel;
import org.jesperancinha.std.flash29.security.dto.JewelDto;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface JewelService {

    @PreAuthorize("hasRole('ROLE_WRITE') && hasRole('ROLE_ADMIN') && #jewel.guardian != null &&  #jewel.guardian == authentication.name")
    JewelDto createJewel(final JewelDto jewel);

    @PreAuthorize("hasRole('ROLE_ADMIN') && #jewel.guardian != null &&  #jewel.guardian == authentication.name")
    JewelDto updateJewel(JewelDto jewel);

    @PostAuthorize("returnObject.guardian == authentication.name")
    JewelDto getJewelById(final Long id);

    List<Jewel> getAll();

    /**
     * For demonstration purposes, we will make a delete method, by using a Jewel dto.
     * This way we can test our jewels via their content and the authentication role.
     * @param jewel
     */
    @PreAuthorize("#jewel.guardian == authentication.name && hasRole('ROLE_ADMIN')")
    void deleteJewel(final JewelDto jewel);
}
