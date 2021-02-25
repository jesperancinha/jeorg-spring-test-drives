package org.jesperancinha.std.flash25.jpa.operators;

import org.jesperancinha.std.flash25.jpa.operators.domain.Bean;
import org.jesperancinha.std.flash25.jpa.operators.repos.BeanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFlash25Launcher implements CommandLineRunner {

    private final BeanRepository beanRepository;

    public SpringFlash25Launcher(BeanRepository beanRepository) {
        this.beanRepository = beanRepository;
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
        beanRepository.save(bean1);
        beanRepository.save(bean2);
        beanRepository.save(bean3);
        beanRepository.save(bean4);
        beanRepository.save(bean5);
        beanRepository.save(bean6);
        beanRepository.save(bean7);
        beanRepository.save(bean8);
    }

    private Bean makeBean(String name, Long kilos) {
        final Bean bean = new Bean();
        bean.setName(name);
        bean.setKilos(kilos);
        return bean;
    }
}
