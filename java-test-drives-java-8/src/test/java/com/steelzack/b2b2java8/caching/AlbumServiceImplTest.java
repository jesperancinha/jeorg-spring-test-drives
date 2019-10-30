package com.steelzack.b2b2java8.caching;

import com.steelzack.b2b2java8.configuration.ApplicationOkTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by joaofilipesabinoesperancinha on 02-05-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationOkTest.class)
public class AlbumServiceImplTest {

    final Logger log = LoggerFactory.getLogger(AlbumServiceImplTest.class);

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
