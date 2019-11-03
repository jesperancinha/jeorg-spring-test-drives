package org.jesperancinha.b2b2java8.caching;

import lombok.extern.slf4j.Slf4j;
import org.jesperancinha.b2b2java8.configuration.ApplicationOkTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created by joaofilipesabinoesperancinha on 02-05-16.
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationOkTest.class)
public class AlbumServiceImplTest {

    @Test
    public void findByDirector() throws Exception {

        final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final AlbumService albumService = (AlbumService) context.getBean("albumService");

        log.info("The album is : {}", albumService.findByAlbum("This mortal coil!"));
        log.info("The album is : {}", albumService.findByAlbum("This mortal coil!"));
        log.info("The album is : {}", albumService.findByAlbum("This mortal coil!"));

        log.info("The album is : {}", albumService.findByAlbum("Porcelain"));
        log.info("The album is : {}", albumService.findByAlbum("Porcelain"));
        log.info("The album is : {}", albumService.findByAlbum("Porcelain"));

        log.info("The album is : {}", albumService.findByAlbum("The Rythm of the Saints"));
        log.info("The album is : {}", albumService.findByAlbum("The Rythm of the Saints"));
        log.info("The album is : {}", albumService.findByAlbum("The Rythm of the Saints"));

        ((ConfigurableApplicationContext) context).close();


    }

}
