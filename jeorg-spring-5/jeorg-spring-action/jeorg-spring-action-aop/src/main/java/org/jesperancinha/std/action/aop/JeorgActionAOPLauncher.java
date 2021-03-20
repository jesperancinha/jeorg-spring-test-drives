package org.jesperancinha.std.action.aop;

import org.jesperancinha.std.action.aop.methods.BonitoCatcher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JeorgActionAOPLauncher implements ApplicationRunner {

    private final BonitoCatcher bonitoCatcher;

    public JeorgActionAOPLauncher(BonitoCatcher bonitoCatcher) {
        this.bonitoCatcher = bonitoCatcher;
    }

    public static void main(String[] args) {
        SpringApplication.run(JeorgActionAOPLauncher.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        bonitoCatcher.catchByHand();
        bonitoCatcher.catchByHandExtra();
        bonitoCatcher.catchWithClaws();
    }
}
