package org.jesperancinha.std.flash413.boot.test;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.BootstrapContext;
import org.springframework.test.context.CacheAwareContextLoaderDelegate;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate;
import org.springframework.test.context.support.DefaultBootstrapContext;

import static org.assertj.core.api.Assertions.assertThat;

class SpringFlash413LauncherTest {

    @Test
    public void testSpringBootContextLoader_whenSomething_sayGoodbye() {
        final CacheAwareContextLoaderDelegate delegate = new DefaultCacheAwareContextLoaderDelegate();
        final BootstrapContext bootstrapContext = new DefaultBootstrapContext(SpringFlash413Launcher.class, delegate);
        final SpringBootTestContextBootstrapper bootstrapper = new SpringBootTestContextBootstrapper();
        bootstrapper.setBootstrapContext(bootstrapContext);
        final MergedContextConfiguration configuration = bootstrapper.buildMergedContextConfiguration();
        final AssertableApplicationContext context = AssertableApplicationContext.get(() -> {
            SpringBootContextLoader loader = new SpringBootContextLoader();
            try {
                return (ConfigurableApplicationContext) loader.loadContext(configuration);
            } catch (Exception exception) {
                ConsolerizerColor.RED.printThrowableAndExit(exception);
                throw new RuntimeException(exception);
            }
        });
        final String power = (String) context.getBean("power");
        ConsolerizerComposer
                .out(" ")
                .green("We are able to load the power.")
                .newLine()
                .cyan("And the power is:")
                .newLine()
                .blue(power).toConsoleLn();
        assertThat(power).isNotNull();
        assertThat(power).isEqualTo("The power of goodbye");
    }

}