package org.jesperancinha.std.flash57.secured.services;

import org.jesperancinha.std.flash57.secured.domain.Throne;
import org.jesperancinha.std.flash57.secured.dto.ThroneDto;
import org.jesperancinha.std.flash57.secured.repository.ThroneRepository;
import org.jesperancinha.std.flash57.secured.security.Flash57PreConfiguration;
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
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("prod")
@ContextConfiguration(classes = {
        Flash57PreConfiguration.class,
        ThroneServiceImpl.class
})
class ThroneServiceImplTest {

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
    void testCreateThroneWhenCreatingThroneNoAuthenticationThenFail() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.createThrone(throne));
    }

    @Test
    @WithMockUser(username = "intruder")
    void testCreateThroneWhenCreatingWithDefaultUserRoleThenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        assertThrows(AccessDeniedException.class,
                () -> throneService.createThrone(throne));
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testCreateThroneWhenCreatingWithRoleRulerThenOk() {
        final var throne = Throne.builder().keeper("joao").throneType(SAVANNAH_WOOD).build();

        final ThroneDto throneDto = throneService.createThrone(throne);
        assertThat(throneDto).isNotNull();
        assertThat(throneDto.getThroneType()).isEqualTo(SAVANNAH_WOOD);
        assertThat(throneDto.getKeeper()).isEqualTo("joao");
    }

    @Test
    void testUpdateThroneWhenCreatingThroneNoAuthenticationThenFail() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.updateThrone(throne));
    }

    @Test
    @WithMockUser(username = "intruder")
    void testUpdateThroneWhenCreatingWithDefaultUserRoleThenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();

        assertThrows(AccessDeniedException.class,
                () -> throneService.updateThrone(throne));
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testUpdateThroneWhenCreatingWithRoleRulerThenOk() {
        final var throne = Throne.builder().keeper("joao").throneType(SAVANNAH_WOOD).build();

        throneService.updateThrone(throne);

        verify(throneRepository, only()).save(throneArgumentCaptor.capture());

        final var value = throneArgumentCaptor.getValue();
        assertThat(value).isNotNull();
        assertThat(value.getThroneType()).isEqualTo(SAVANNAH_WOOD);
        assertThat(value.getKeeper()).isEqualTo("joao");
    }

    @Test
    void testGetThroneByIdWhenCreatingThroneNoAuthenticationThenFail() {
        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.getThrone(1L));
    }

    @Test
    @WithMockUser(username = "intruder")
    void testGetThroneByIdWhenCreatingWithDefaultUserRoleThenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();
        when(throneRepository.getOne(1L)).thenReturn(throne);
        assertThrows(AccessDeniedException.class,
                () -> throneService.getThrone(1L));
        verify(throneRepository, only()).getOne(1L);
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testGetThroneByIdWhenCreatingWithRoleRulerThenOk() {
        final var throne = Throne.builder().keeper("joao").throneType(SAVANNAH_WOOD).build();
        when(throneRepository.getOne(1L)).thenReturn(throne);

        final var value = throneService.getThrone(1L);
        assertThat(value).isNotNull();
        assertThat(value.getThroneType()).isEqualTo(SAVANNAH_WOOD);
        assertThat(value.getKeeper()).isEqualTo("joao");
    }


    @Test
    void testGetAllWhenCreatingThroneNoAuthenticationThenFail() {
        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.getAll());
    }

    @Test
    @WithMockUser(username = "intruder")
    void testGetAllWhenCreatingWithDefaultUserRoleThenOk() {
        assertThrows(AccessDeniedException.class,
                () -> throneService.getAll());
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testGetAllWhenCreatingWithRoleRulerThenOk() {
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
    void testDeleteWhenCreatingThroneNoAuthenticationThenFail() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();
        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.deleteThrone(throne));
    }

    @Test
    @WithMockUser(username = "intruder")
    void testDeleteWhenCreatingWithDefaultUserRoleThenOk() {
        final var throne = Throne.builder().keeper("test").throneType(SAVANNAH_WOOD).build();
        assertThrows(AccessDeniedException.class,
                () -> throneService.deleteThrone(throne));
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "ADMIN")
    void testDeleteWhenCreatingWithRoleRulerThenOk() {
        final var throne = Throne.builder().keeper("joao").throneType(SAVANNAH_WOOD).build();

        throneService.deleteThrone(throne);

        verify(throneRepository, only()).delete(throneArgumentCaptor.capture());
        final var value = throneArgumentCaptor.getValue();
        assertThat(value).isNotNull();
        assertThat(value.getThroneType()).isEqualTo(SAVANNAH_WOOD);
        assertThat(value.getKeeper()).isEqualTo("joao");
    }

    @Test
    void testDanceWhenCreatingThroneNoAuthenticationThenFail() {
        assertThrows(AuthenticationCredentialsNotFoundException.class,
                () -> throneService.dance());
    }

    @Test
    @WithMockUser(username = "intruder")
    void testDanceWhenCreatingWithDefaultUserRoleThenOk() {
        assertThrows(AccessDeniedException.class,
                () -> throneService.dance());
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "RULER")
    void testDanceWhenCreatingWithRoleRulerThenOk() {
        final String dance = throneService.dance();

        assertThat(dance).isEqualTo("We would Pop Champagne and Raise our tones!");
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "DANCER")
    void testDanceWhenCreatingWithRoleDancerThenOk() {
        final String dance = throneService.dance();

        assertThat(dance).isEqualTo("We would Pop Champagne and Raise our tones!");
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "ADMIN")
    void testDanceWhenCreatingWithRoleAdminThenOk() {
        final String dance = throneService.dance();

        assertThat(dance).isEqualTo("We would Pop Champagne and Raise our tones!");
    }
}