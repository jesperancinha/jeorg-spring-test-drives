package org.jesperancinha.std.flash21.embedded.factory;

import org.jesperancinha.console.consolerizer.ConsolerizerColor;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomServletWebServerFactoryCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        ConsolerizerColor.BRIGHT_BLUE.printGenericLn("Starting Setting up Configurable Embedded Server");
        ConsolerizerColor.ORANGE.printGenericLn("We override the normal Spring configuration this way.");
        factory.setPort(9000);
        factory.setDisplayName("Testing ConfigurableServletWebServerFactory");
        factory.setServerHeader("ConfigurableServletWebServerFactory Header");
        factory.setContextPath("/api");
        ConsolerizerColor.ORANGE.printGenericLn("This is our factory -> %s", factory);
        ConsolerizerColor.BRIGHT_BLUE.printGenericLn("Finishing Setting up Configurable Embedded Server");
    }
}