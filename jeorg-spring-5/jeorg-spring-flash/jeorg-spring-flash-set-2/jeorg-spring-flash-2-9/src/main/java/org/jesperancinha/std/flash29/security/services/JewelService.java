package org.jesperancinha.std.flash29.security.services;

import org.jesperancinha.std.flash29.security.dto.JewelDto;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * It is important to notice that ROLE_ as a prefix has no actual effect in the authoriazations resolutions.
 * Spring handles the role as must having ROLE_. If we don't specify this, Spring will add it for us.
 */
public interface JewelService {

    @PreAuthorize("hasRole('WRITE') && hasRole('ADMIN') && #jewel.guardian != null &&  #jewel.guardian == authentication.name")
    JewelDto createJewel(final JewelDto jewel);

    @PreAuthorize("hasRole('ROLE_ADMIN') && #jewel.guardian != null &&  #jewel.guardian == authentication.name")
    JewelDto updateJewel(JewelDto jewel);

    /**
     * To read our own jewels, we shouldn't have any special role.
     * After all they are our own.
     * The only jewels to be reject are the jewels that do not belong to us.
     *
     * @param id This is the id of the Jewel {@link Long}
     * @return The {@link JewelDto} we need to find.
     */
    @PostAuthorize("returnObject.guardian == authentication.name")
    JewelDto getJewelById(final Long id);

    /**
     * For demonstration purposes, this is our only method that has no protection on a service level.
     *
     * @return The list of all current Jewels in our system. {@link List}
     */
    List<JewelDto> getAll();

    /**
     * For demonstration purposes, we will make a delete method, by using a Jewel dto.
     * This way we can test our jewels via their content and the authentication role.
     *
     * @param jewel
     */
    @PreAuthorize("#jewel.guardian == authentication.name && hasRole('ROLE_ADMIN')")
    void deleteJewel(final JewelDto jewel);
}
