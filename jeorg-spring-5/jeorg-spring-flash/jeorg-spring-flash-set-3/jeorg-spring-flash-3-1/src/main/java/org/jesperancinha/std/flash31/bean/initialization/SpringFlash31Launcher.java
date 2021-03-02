package org.jesperancinha.std.flash31.bean.initialization;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.console.consolerizer.ConsolerizerColor;
import org.jesperancinha.std.flash31.bean.initialization.domain.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_RED;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.CYAN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootApplication
@RestController
public class SpringFlash31Launcher {
    public static void main(String[] args) {
        Consolerizer.setupFastDefault();
        Consolerizer.titleSpread = 200;
        Consolerizer.maxLineCharsGlobal = 200;
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        final var bookService = (BookService) context.getBean("bookService");
        CYAN.printGenericTitleLn("This is the %s instance", bookService.getClass());
        BLUE.printGenericLn("The instance has these contents %s", bookService);
        context.close();
    }
}
