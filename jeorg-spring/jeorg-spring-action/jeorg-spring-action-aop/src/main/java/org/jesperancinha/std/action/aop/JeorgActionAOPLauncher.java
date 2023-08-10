package org.jesperancinha.std.action.aop;

import org.jesperancinha.std.action.aop.catchers.*;
import org.jesperancinha.std.action.aop.catchers.cod.CodCatcher;
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
    private final GambaFoodCatcher gambaFoodCatcher;
    private final MackerelCatcher mackerelCatcher;
    private final MegaTunaCatcher megaTunaCatcher;
    private final SardineCatcher sardineCatcher;
    private final ShrimpCatcher shrimpCatcher;
    private final TunaCatcher tunaCatcher;

    public JeorgActionAOPLauncher(
            final BonitoCatcher bonitoCatcher,
            final CodCatcher codCatcher,
            final GambaFoodCatcher gambaFoodCatcher,
            final MackerelCatcher mackerelCatcher,
            final MegaTunaCatcher megaTunaCatcher,
            final SardineCatcher sardineCatcher,
            final ShrimpCatcher shrimpCatcher,
            final TunaCatcher tunaCatcher) {
        this.bonitoCatcher = bonitoCatcher;
        this.codCatcher = codCatcher;
        this.gambaFoodCatcher = gambaFoodCatcher;
        this.mackerelCatcher = mackerelCatcher;
        this.megaTunaCatcher = megaTunaCatcher;
        this.sardineCatcher = sardineCatcher;
        this.shrimpCatcher = shrimpCatcher;
        this.tunaCatcher = tunaCatcher;
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
        gambaFoodCatcher.catchByHand();
        mackerelCatcher.catchWithNet();
        megaTunaCatcher.catchWithNet();
        sardineCatcher.catchWithNet();
        shrimpCatcher.catchByHand();
        tunaCatcher.catchByHand();
    }
}
