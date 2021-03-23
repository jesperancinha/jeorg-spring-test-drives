package org.jesperancinha.std.flash25.jpa.operators;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash25.jpa.operators.domain.Bean;
import org.jesperancinha.std.flash25.jpa.operators.repos.BeanRepository;
import org.jesperancinha.std.flash25.jpa.operators.service.BeanService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.inject.Named;

import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.quote;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

@SpringBootApplication
@PropertySource("classpath:production.beans.properties")
public class SpringFlash25Launcher implements CommandLineRunner {

    private final BeanRepository beanRepository;

    private final BeanService beanService;

    private final Environment environment;

    public SpringFlash25Launcher(BeanRepository beanRepository,
                                 @Named("that-other-bean-service")
                                         BeanService beanService, Environment environment) {
        this.beanRepository = beanRepository;
        this.beanService = beanService;
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash25Launcher.class, args);
    }

    @Override
    public void run(String... args) {
        final Bean bean1 = makeBean("Runner", 40L);
        final Bean bean2 = makeBean("Red Kidney", 60L);
        final Bean bean3 = makeBean("Kidney", 30L);
        final Bean bean4 = makeBean("Mung", 1000L);
        final Bean bean5 = makeBean("Aduki", 25L);
        final Bean bean6 = makeBean("Black-Eyed Pea", 30L);
        final Bean bean7 = makeBean("Brown", 15L);
        final Bean bean8 = makeBean("Lima", 55L);
        final Bean bean9 = makeBean("White", null);
        final Bean bean10 = makeBean("Black", null);
        beanRepository.save(bean1);
        beanRepository.save(bean2);
        beanRepository.save(bean3);
        beanRepository.save(bean4);
        beanRepository.save(bean5);
        beanRepository.save(bean6);
        beanRepository.save(bean7);
        beanRepository.save(bean8);
        beanRepository.save(bean9);
        beanRepository.save(bean10);

        ConsolerizerComposer.outSpace()
                .black()
                .bgRed(title("@Named beans explained"))
                .bgCyan("We just started bean %s",beanService)
                .reset();

        final String property = environment.getProperty("org.jesperancinha.std.flash25.jpa.operators.beanlove");

        ConsolerizerComposer.outSpace()
                .black()
                .bgCyan(title("Because we love beans"))
                .bgGreen("we can also take our message from an external production.beans.properties file")
                .black()
                .bgCyan(quote(property))
                .reset();

    }

    private Bean makeBean(String name, Long kilos) {
        final Bean bean = new Bean();
        bean.setName(name);
        bean.setKilos(kilos);
        return bean;
    }
}
