package org.jesperancinha.std.flash35.aop.security;

import org.jesperancinha.std.flash35.aop.security.southern.oracle.SouthernOracle;
import org.jesperancinha.std.flash35.aop.security.southern.oracle.SouthernOracleAdvice;
import org.jesperancinha.std.flash35.aop.security.southern.oracle.SouthernOracleMessage;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;

@SpringBootApplication
@RestController
public class SpringFlash35Launcher implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringFlash35Launcher.class, args);
    }

    @Override
    public void run(String... args) {
        SouthernOracle mgr = new SouthernOracle();
        SouthernOracleMessage bean = southernOracleMessage();
        mgr.login("Atreyu");
        bean.giveANewName();
        mgr.logout();
        try {
            mgr.login("Falkor");
            bean.giveANewName();
        } catch (SecurityException securityException) {
            ORANGE.printExpectedException("Falkor is not in the Southern Oracle at this point", securityException);
        } finally {
            mgr.logout();
        }
        try {
            bean.giveANewName();
        } catch (SecurityException securityException) {
            ORANGE.printExpectedException("The Nothing has tried to reach the Southern Oracle. We won't let it", securityException);
        }

        GREEN.printGenericLn("We can confirm that our method is protected against other users.");
        GREEN.printGenericLn("Atreyu is safe to be the only one to get the message from the Southern Oracle.");
    }

    public SouthernOracleMessage southernOracleMessage() {
        SouthernOracleMessage target = new SouthernOracleMessage();
        SouthernOracleAdvice advice = new SouthernOracleAdvice();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);
        return (SouthernOracleMessage) factory.getProxy();
    }
}
