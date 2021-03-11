package org.jesperancinha.std.flash52.delegating;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@SpringBootApplication
public class SpringFlash52Launcher implements CommandLineRunner {

    private final ApplicationContext applicationContext;

    public SpringFlash52Launcher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        GREEN.printGenericTitleLn("Service is starting");
        SpringApplication.run(SpringFlash52Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final DelegatingFilterProxyRegistrationBean securityFilterChainRegistration = applicationContext.getBean("securityFilterChainRegistration", DelegatingFilterProxyRegistrationBean.class);
        final DelegatingFilterProxy delegatingFilterProxy = securityFilterChainRegistration.getFilter();
        ConsolerizerComposer.out(" ")
                .orange("This is the DelegatingFilterProxy")
                .newLine()
                .magenta(delegatingFilterProxy)
                .newLine()
                .brightWhite(delegatingFilterProxy.getContextAttribute())
                .newLine()
                .yellow(delegatingFilterProxy.getEnvironment())
                .newLine()
                .brightWhite(delegatingFilterProxy.getFilterConfig())
                .newLine()
                .orange("Isn't it beautiful?")
                .toConsoleLn();
    }

}