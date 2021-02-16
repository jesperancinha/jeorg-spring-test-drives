package org.jesperancinha.std.topic.container;

import org.jesperancinha.console.consolerizer.ConsolerizerGraphs;
import org.jesperancinha.std.topic.container.beans.Bean;
import org.jesperancinha.std.topic.container.beans.Flower;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;

public class ContainerLauncher {
    public static void main(String[] args) {
        BRIGHT_MAGENTA.printGenericTitleLn("Runtime Started");

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("./beans.xml");
        Flower flower1 = (Flower) beanFactory.getBean("flower1");
        GREEN.printGenericTitleLn("Flower No. 1 - From BeanFactory");
        BLUE.printGenericLn("Flower Type: %s", flower1.getName());
        BLUE.printGenericLn("Flower Height: %d", flower1.getHeight());

        ApplicationContext context = new ClassPathXmlApplicationContext("./beans.xml");
        Flower flower2 = (Flower) context.getBean("flower2");

        GREEN.printGenericTitleLn("Flower No. 2 - From ApplicationContext");
        BLUE.printGenericLn("Flower Type: %s", flower2.getName());
        BLUE.printGenericLn("Flower Height: %d", flower2.getHeight());

        MAGENTA.printGenericLn("ApplicationContext is also a Bean Factory -> %s", context instanceof BeanFactory);
        MAGENTA.printGenericLn("Bean Factory is also an ApplicationContext -> %s", beanFactory instanceof ApplicationContext);
        MAGENTA.printGenericLn("Instance context is a %s", context.getClass().getCanonicalName());
        MAGENTA.printGenericLn("Instance beanFactory is a %s", beanFactory.getClass().getCanonicalName());
        ORANGE.printGenericLn("This is because both are just interfaces for an instance of the Application context");

        ConsolerizerGraphs.printUnicornsLn(100);
        GREEN.printGenericLn("Now that we have seen how beans  work with params, let's now see how they work with constructors");

        final Bean kidneyBean = (Bean) context.getBean("kidneyBean");
        final Bean scarletBean = (Bean) context.getBean("scarletBean");
        final Bean blackBean = (Bean) context.getBean("blackBean");

        MAGENTA.printGenericLn("This is the kidneyBean value %s:", kidneyBean);
        MAGENTA.printGenericLn("This is the scarletBean value %s:", scarletBean);
        MAGENTA.printGenericLn("This is the blackBean value %s:", blackBean);
        BRIGHT_MAGENTA.printGenericLn("(Note that no getters and setters are needed for this sort of instantiaion)");
    }
}
