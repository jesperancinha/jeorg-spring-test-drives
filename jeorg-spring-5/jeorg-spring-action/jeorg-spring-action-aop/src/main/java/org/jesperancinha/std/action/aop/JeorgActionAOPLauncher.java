package org.jesperancinha.std.action.aop;

import org.jesperancinha.std.action.aop.methods.BonitoCatcher;
import org.jesperancinha.std.action.aop.methods.cod.CodCatcher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:bean.xml")
public class JeorgActionAOPLauncher implements ApplicationRunner {

    private final BonitoCatcher bonitoCatcher;
    private final CodCatcher codCatcher;

    public JeorgActionAOPLauncher(BonitoCatcher bonitoCatcher,
                                  CodCatcher codCatcher) {
        this.bonitoCatcher = bonitoCatcher;
        this.codCatcher = codCatcher;
    }

    public static void main(String[] args) {
        SpringApplication.run(JeorgActionAOPLauncher.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        bonitoCatcher.catchByHand();
        bonitoCatcher.catchByHandExtra();
        bonitoCatcher.catchWithClaws();
        codCatcher.catchByHand();
    }
}
