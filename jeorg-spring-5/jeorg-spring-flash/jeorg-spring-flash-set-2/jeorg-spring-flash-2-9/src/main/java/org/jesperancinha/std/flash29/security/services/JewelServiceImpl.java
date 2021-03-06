package org.jesperancinha.std.flash29.security.services;

import org.jesperancinha.std.flash29.security.domain.Jewel;
import org.jesperancinha.std.flash29.security.dto.JewelDto;
import org.jesperancinha.std.flash29.security.repository.JewelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@Service
public class JewelServiceImpl implements JewelService {

    private final JewelRepository jewelRepository;

    public JewelServiceImpl(JewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    /**
     * (C) reate
     *
     * @param jewel
     * @return
     */
    public JewelDto createJewel(Jewel jewel) {
        final Jewel save = this.jewelRepository.save(jewel);
        final JewelDto jewelDto1 = new JewelDto();
        jewelDto1.setJewelType(save.getJewelType());
        jewelDto1.setGuardian(save.getGuardian());
        return jewelDto1;
    }


    /**
     * (U) pdate
     *
     * @param jewel
     */
    public void updateJewel(Jewel jewel) {
        this.jewelRepository.save(jewel);
    }

    /**
     * (R) ead
     *
     * @param id
     * @return {@link Jewel}
     */
    public Jewel getJewelById(final Long id) {
        final Jewel jewel = jewelRepository.findById(id).orElse(null);
        ORANGE.printGenericLn(jewel);
        return jewel;
    }

    public List<Jewel> getAll() {
        return jewelRepository.findAll();
    }

    /**
     * (D) elete
     *
     * @param jewel
     */
    public void deleteJewel(Jewel jewel) {
        jewelRepository.delete(jewel);
    }
}
