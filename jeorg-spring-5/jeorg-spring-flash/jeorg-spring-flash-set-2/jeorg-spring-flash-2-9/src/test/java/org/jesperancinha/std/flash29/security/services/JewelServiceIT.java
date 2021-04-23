package org.jesperancinha.std.flash29.security.services;

import org.jesperancinha.std.flash29.security.domain.Jewel;
import org.jesperancinha.std.flash29.security.repository.JewelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.std.flash29.security.services.JewelType.OPAL;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest
class JewelServiceIT {

    @Autowired
    private JewelService jewelService;

    @MockBean
    private JewelRepository jewelRepository;

    @BeforeEach
    public void setUp() {
        when(jewelRepository.save(any())).thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);
    }

    @Captor
    private ArgumentCaptor<Jewel> jewelArgumentCaptor;

    @Test
    void testCreateJewel_whenNoAuthentication_thenFail() {
        final var jewel = Jewel
                .builder()
                .jewelType(OPAL)
                .guardian("Kitten")
                .build();

        assertThrows(AuthenticationCredentialsNotFoundException.class, () -> jewelService.createJewel(jewel));
        verifyNoInteractions(jewelRepository);
    }

    @Test
    @WithMockUser(username = "gregory_kitten")
    void testCreateJewel_whenAuthenticationButNoRoles_thenFail() {
        final var jewel = Jewel
                .builder()
                .jewelType(OPAL)
                .guardian("Kitten")
                .build();

        assertThrows(AccessDeniedException.class, () -> jewelService.createJewel(jewel));
        verifyNoInteractions(jewelRepository);
    }

    @Test
    @WithMockUser(username = "gregory_kitten",
            roles = "ADMIN")
    void testCreateJewel_whenAuthenticationButNotEnoughRoles_thenFail() {
        final var jewel = Jewel
                .builder()
                .jewelType(OPAL)
                .guardian("Kitten")
                .build();

        assertThrows(AccessDeniedException.class, () -> jewelService.createJewel(jewel));
        verifyNoInteractions(jewelRepository);
    }

    @Test
    @WithMockUser(username = "gregory_kitten",
            roles = {"ADMIN", "WRITE"})
    void testCreateJewel_whenAuthenticationAndRolesButGuardianNotMatch_thenFail() {
        final var jewel = Jewel
                .builder()
                .jewelType(OPAL)
                .guardian("Kitten")
                .build();

        assertThrows(AccessDeniedException.class, () -> jewelService.createJewel(jewel));
        verifyNoInteractions(jewelRepository);
    }

    @Test
    @WithMockUser(username = "gregory_kitten",
            roles = {"ADMIN", "WRITE"})
    void testCreateJewel_whenAuthenticationAndRightRoles_thenOk() {
        final var jewel = Jewel
                .builder()
                .jewelType(OPAL)
                .guardian("gregory_kitten")
                .build();

        final var jewelResult = jewelService.createJewel(jewel);
        assertThat(jewelResult.getJewelType()).isEqualTo(OPAL);
        assertThat(jewelResult.getGuardian()).isEqualTo("gregory_kitten");
        verify(jewelRepository, times(2)).save(jewelArgumentCaptor.capture());
        final Jewel result = jewelArgumentCaptor.getValue();
        assertThat(result).isNotNull();
        assertThat(result).isSameAs(jewel);
    }

    @Test
    void updateJewel() {
    }

    @Test
    void getJewelById() {
    }

    @Test
    void getAll() {
    }

    @Test
    void deleteJewel() {
    }
}