package org.jesperancinha.std.flash31.bean.initialization;

import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash31.bean.initialization.domain.BookService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.CYAN;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

@SpringBootApplication
@RestController
public class SpringFlash31Launcher {
    public static void main(String[] args) {
        Consolerizer.setupFastDefault();
        Consolerizer.titleSpread = 200;
        Consolerizer.maxLineCharsGlobal = 200;
        classPathXmlApplicationContext();
        fileSystemXmlApplicationContext();

    }

    private static void fileSystemXmlApplicationContext() {
        ConsolerizerComposer
                .outSpace()
                .brightGreen(title("Starting FileSystemXmlApplicationContext test"))
                .reset();
        final String path = SpringFlash31Launcher.class.getResource("/beans.xml").toExternalForm();
        ConfigurableApplicationContext fileSystemXmlApplicationContext =
                new FileSystemXmlApplicationContext(path);
        final var bookService = (BookService) fileSystemXmlApplicationContext.getBean("bookService");
        final var bookService2 = (BookService) fileSystemXmlApplicationContext.getBean("bookService2");
        CYAN.printGenericTitleLn("This is the %s instance", bookService.getClass());
        BLUE.printGenericLn("The instance has these contents %s", bookService);
        CYAN.printGenericTitleLn("This is the %s instance", bookService2.getClass());
        BLUE.printGenericLn("The instance 2 has these contents %s", bookService2);
    }

    private static ConfigurableApplicationContext classPathXmlApplicationContext() {
        ConsolerizerComposer
                .outSpace()
                .brightGreen(title("Starting ConfigurableApplicationContext test"))
                .reset();
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        final var bookService = (BookService) context.getBean("bookService");
        final var bookService2 = (BookService) context.getBean("bookService2");
        CYAN.printGenericTitleLn("This is the %s instance", bookService.getClass());
        BLUE.printGenericLn("The instance has these contents %s", bookService);
        CYAN.printGenericTitleLn("This is the %s instance", bookService2.getClass());
        BLUE.printGenericLn("The instance 2 has these contents %s", bookService2);
        context.close();
        return context;
    }
}
