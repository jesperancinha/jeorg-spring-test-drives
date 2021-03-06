package org.jesperancinha.std.flash45.context;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.time.LocalDateTime;

@SpringBootApplication
public class SpringFlash45Launcher extends SpringBootServletInitializer implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ConsolerizerColor.BLUE.printGenericTitleLn("AppInitializer on %s", LocalDateTime.now());
        ConsolerizerComposer.out(" ")
                .magenta("WebApplicationInitializer won't work be cause it has been disabled as described in\n")
                .yellow("https://github.com/spring-projects/spring-boot/issues/522")
                .magenta(".")
                .blue("This is the reason why we switch to ServletContextInitializer in this example.")
                .toConsoleLn();
        WebApplicationContext context = getContext();
        final ContextLoaderListener contextLoaderListener = new ContextLoaderListener(context);
        ConsolerizerComposer.out(" ")
                .magenta("We don't use this")
                .blue("So instead of using")
                .orange("servletContext.addListener(contextLoaderListener);")
                .blue("we just print the result -> %s", contextLoaderListener.toString())
                .toConsoleLn();
//        servletContext.addListener(contextLoaderListener);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/app");
    }

    private AnnotationConfigWebApplicationContext getContext() {
        ConsolerizerColor.BLUE.printGenericTitleLn("AnnotationConfigWebApplicationContext on %s", LocalDateTime.now());
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(" org.jesperancinha.std.flash45.context");
        return context;
    }

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{SpringFlash45Launcher.class}, args);
    }
}
