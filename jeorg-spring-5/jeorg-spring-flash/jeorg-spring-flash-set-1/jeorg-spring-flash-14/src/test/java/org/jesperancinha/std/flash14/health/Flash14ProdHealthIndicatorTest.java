package org.jesperancinha.std.flash14.health;

import org.apache.commons.io.IOUtils;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("prod")
@SpringBootTest(
        webEnvironment = RANDOM_PORT,
        classes = Flash14ProdHealthIndicator.class)
@EnableAutoConfiguration
class Flash14ProdHealthIndicatorTest {

    @LocalServerPort
    private Long port;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void testHealthCheck_whenEndpointCalled_thenReturnHealthChecks() {
        final String url = String.format("http://localhost:%s/actuator/health", port);
        final var headers = new HttpHeaders();
        final var request = new HttpEntity<>(headers);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            protected void handleError(final @NonNull
                                               ClientHttpResponse response, final @NonNull
                                               HttpStatus statusCode) throws IOException {
                final String responseText = IOUtils.toString(response.getBody());
                assertThat(responseText).isNotNull();
                assertThat(responseText).contains("\"lyrics\":\"Without you what does my life amount to\"");
                ConsolerizerComposer.outSpace()
                        .green("All assertions complete!")
                        .reset();
                super.handleError(response, statusCode);
            }
        });

        assertThrows(HttpServerErrorException.class, () -> restTemplate.exchange(
                url, HttpMethod.GET,
                request, String.class));
    }
}