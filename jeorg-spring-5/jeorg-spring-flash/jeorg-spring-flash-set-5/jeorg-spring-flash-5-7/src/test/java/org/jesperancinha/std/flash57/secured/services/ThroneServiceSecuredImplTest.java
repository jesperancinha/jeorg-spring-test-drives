package org.jesperancinha.std.flash57.secured.services;

import org.jesperancinha.std.flash57.secured.domain.Throne;
import org.jesperancinha.std.flash57.secured.dto.ThroneDto;
import org.jesperancinha.std.flash57.secured.repository.ThroneRepository;
import org.jesperancinha.std.flash57.secured.security.Flash57SecuredConfiguration;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.std.flash57.secured.services.ThroneType.SAVANNAH_WOOD;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("acc")
@ContextConfiguration(classes = {
        Flash57SecuredConfiguration.class,
        ThroneServiceSecuredImpl.class
})
class ThroneServiceSecuredImplTest {

    @Autowired
    private ThroneService throneService;

    @MockBean
    private ThroneRepository throneRepository;

    @Captor
    private ArgumentCaptor<Throne> throneArgumentCaptor;

    @BeforeEach
    public void setUp() {
        when(throneRepository.save(any(Throne.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
    }

    @Test
    void testCreateThrone_whenCreatingThroneNoAuthentication_thenFail() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.createThrone(throne));
    }

    @Test
    @WithMockUser(username = "intruder")
    void testCreateThrone_whenCreatingWithDefaultUserRole_thenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        assertThrows(AccessDeniedException.class,
                () -> throneService.createThrone(throne));
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testCreateThrone_whenCreatingWithRoleRuler_thenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        final ThroneDto throneDto = throneService.createThrone(throne);
        assertThat(throneDto).isNotNull();
        assertThat(throneDto.getThroneType()).isEqualTo(SAVANNAH_WOOD);
        assertThat(throneDto.getKeeper()).isEqualTo("test");
    }

    @Test
    void testUpdateThrone_whenCreatingThroneNoAuthentication_thenFail() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.updateThrone(throne));
    }

    @Test
    @WithMockUser(username = "intruder")
    void testUpdateThrone_whenCreatingWithDefaultUserRole_thenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        assertThrows(AccessDeniedException.class,
                () -> throneService.updateThrone(throne));
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testUpdateThrone_whenCreatingWithRoleRuler_thenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        throneService.updateThrone(throne);

        verify(throneRepository, only()).save(throneArgumentCaptor.capture());

        final var value = throneArgumentCaptor.getValue();
        assertThat(value).isNotNull();
        assertThat(value.getThroneType()).isEqualTo(SAVANNAH_WOOD);
        assertThat(value.getKeeper()).isEqualTo("test");
    }

    @Test
    void testGetThroneById_whenCreatingThroneNoAuthentication_thenFail() {
        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.getThrone(1L));
    }

    @Test
    @WithMockUser(username = "intruder")
    void testGetThroneById_whenCreatingWithDefaultUserRole_thenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();
        when(throneRepository.getOne(1L)).thenReturn(throne);

        final var throneResult = throneService.getThrone(1L);
        assertThat(throneResult).isEqualTo(throne);
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testGetThroneById_whenCreatingWithRoleRuler_thenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();
        when(throneRepository.getOne(1L)).thenReturn(throne);

        final var value = throneService.getThrone(1L);
        assertThat(value).isNotNull();
        assertThat(value.getThroneType()).isEqualTo(SAVANNAH_WOOD);
        assertThat(value.getKeeper()).isEqualTo("test");
    }


    @Test
    void testGetAll_whenCreatingThroneNoAuthentication_thenFail() {
        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.getAll());
    }

    @Test
    @WithMockUser(username = "intruder")
    void testGetAll_whenCreatingWithDefaultUserRole_thenOk() {
        assertThrows(AccessDeniedException.class,
                () -> throneService.getAll());
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testGetAll_whenCreatingWithRoleRuler_thenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();
        when(throneRepository.findAll()).thenReturn(List.of(throne));

        final List<Throne> all = throneService.getAll();

        assertThat(all).hasSize(1);
        final var value = all.get(0);
        assertThat(value).isNotNull();
        assertThat(value.getThroneType()).isEqualTo(SAVANNAH_WOOD);
        assertThat(value.getKeeper()).isEqualTo("test");
    }

    @Test
    void testDelete_whenCreatingThroneNoAuthentication_thenFail() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();
        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.deleteThrone(throne));
    }

    @Test
    @WithMockUser(username = "intruder")
    void testDelete_whenCreatingWithDefaultUserRole_thenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();
        assertThrows(AccessDeniedException.class,
                () -> throneService.deleteThrone(throne));
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testDelete_whenCreatingWithRoleRuler_thenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        throneService.deleteThrone(throne);

        verify(throneRepository, only()).delete(throneArgumentCaptor.capture());
        final var value = throneArgumentCaptor.getValue();
        assertThat(value).isNotNull();
        assertThat(value.getThroneType()).isEqualTo(SAVANNAH_WOOD);
        assertThat(value.getKeeper()).isEqualTo("test");
    }

    @Test
    void testDance_whenCreatingThroneNoAuthentication_thenFail() {
        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.dance());
    }

    @Test
    @WithMockUser(username = "intruder")
    void testDance_whenCreatingWithDefaultUserRole_thenOk() {
        assertThrows(AccessDeniedException.class,
                () -> throneService.dance());
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testDance_whenCreatingWithRoleRuler_thenOk() {
        final String dance = throneService.dance();

        assertThat(dance).isEqualTo("We would Pop Champagne and Raise our tones!");
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "DANCER")
    void testDance_whenCreatingWithRoleDancer_thenOk() {
        final String dance = throneService.dance();

        assertThat(dance).isEqualTo("We would Pop Champagne and Raise our tones!");
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "ADMIN")
    void testDance_whenCreatingWithRoleAdmin_thenOk() {
        final String dance = throneService.dance();

        assertThat(dance).isEqualTo("We would Pop Champagne and Raise our tones!");
    }
}