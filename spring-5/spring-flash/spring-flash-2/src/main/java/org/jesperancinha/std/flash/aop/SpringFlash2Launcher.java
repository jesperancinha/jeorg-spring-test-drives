package org.jesperancinha.std.flash.aop;

import org.springframework.aop.framework.ProxyFactory;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;

public class SpringFlash2Launcher {
    public static void main(String[] args) {
        final var seed = new Seed("Chives");
        final var vase = new Vase();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new VaseAdvice());
        proxyFactory.setTarget(vase);

        final var proxy = (Vase) proxyFactory.getProxy();

        final Plant plant = proxy.seed(seed);

        BRIGHT_BLUE.printGenericTitleLn("Proxy, cutpoints and advices");
        GREEN.printGenericLn("Out result is  %s", plant);
        GREEN.printGenericLn(plant.hashCode());
    }
}
