package org.jesperancinha.std.flash27.monitoring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash27.monitoring.model.Health;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class Flash27HealthIndicatorTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void health() throws Exception {
        final var mvcResult = mockMvc.perform(get("/actuator/health"))
                .andReturn();

        final var response = mvcResult.getResponse();
        assertThat(response).isNotNull();
        final var contentAsString = response.getContentAsString();
        assertThat(contentAsString).isNotNull();
        ConsolerizerComposer.outSpace()
                .brightBlue("Service response is:")
                .jsonPrettyPrint(contentAsString)
                .reset();
        final var health = objectMapper.readValue(contentAsString, Health.class);
        assertThat(health).isNotNull();
        final var status = health.getStatus();
        assertThat(status).isNotNull();
        assertThat(status).isIn("UP", "DOWN", "OUT_OF_SERVICE");
        final var components = health.getComponents();
        assertThat(components).isNotNull();
        final var db = components.getDb();
        assertThat(db).isNotNull();
        assertThat(db.getStatus()).isEqualTo("UP");
        final var dbDetails = db.getDetails();
        assertThat(dbDetails).isNotNull();
        assertThat(dbDetails.getDatabase()).isEqualTo("H2");
        assertThat(dbDetails.getResult()).isIn(1, null);
        assertThat(dbDetails.getValidationQuery()).isIn("SELECT 1", "isValid()");
        assertThat(dbDetails.getLyric()).isNull();
        assertThat(dbDetails.getTotal()).isNull();
        assertThat(dbDetails.getFree()).isNull();
        assertThat(dbDetails.getThreshold()).isNull();
        final var diskSpace = components.getDiskSpace();
        assertThat(diskSpace).isNotNull();
        final var diskSpaceStatus = diskSpace.getStatus();
        assertThat(diskSpaceStatus).isNotNull();
        assertThat(diskSpaceStatus).isEqualTo("UP");
        final var diskSpaceDetails = diskSpace.getDetails();
        assertThat(diskSpaceDetails).isNotNull();
        assertThat(diskSpaceDetails.getDatabase()).isNull();
        assertThat(diskSpaceDetails.getResult()).isNull();
        assertThat(diskSpaceDetails.getValidationQuery()).isNull();
        assertThat(diskSpaceDetails.getLyric()).isNull();
        assertThat(diskSpaceDetails.getTotal()).isNotNull();
        assertThat(diskSpaceDetails.getFree()).isNotNull();
        assertThat(diskSpaceDetails.getThreshold()).isNotNull();
        final var flash27 = components.getFlash27();
        assertThat(flash27).isNotNull();
        final var flash27Status = flash27.getStatus();
        assertThat(flash27Status).isNotNull();
        final var flash27Details = flash27.getDetails();
        assertThat(flash27Details).isNotNull();
        assertThat(flash27Details.getDatabase()).isNull();
        assertThat(flash27Details.getResult()).isNull();
        assertThat(flash27Details.getValidationQuery()).isNull();
        assertThat(flash27Details.getTotal()).isNull();
        assertThat(flash27Details.getFree()).isNull();
        assertThat(flash27Details.getThreshold()).isNull();
        assertThat(flash27Details.getLyric()).isNotNull();
        assertThat(flash27Details.getLyric()).isIn(
                "Oh, not to touch a hair on your head",
                "Leave you as you are",
                "If he felt he had to direct you",
                "Then direct you into my arms");
        final var ping = components.getPing();
        assertThat(ping).isNotNull();
        final var pingStatus = ping.getStatus();
        assertThat(pingStatus).isNotNull();
        assertThat(pingStatus).isEqualTo("UP");
    }
}