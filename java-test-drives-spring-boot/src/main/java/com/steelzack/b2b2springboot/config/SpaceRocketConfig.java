package com.steelzack.b2b2springboot.config;

import com.steelzack.b2b2springboot.entities.SpaceRocket;
import com.steelzack.b2b2springboot.entities.SpaceRocketRepository;
import com.steelzack.b2b2springboot.service.SpaceRocketService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by jesperancinha on 24-5-16.
 */
@ComponentScan(basePackageClasses = SpaceRocketService.class)
@EntityScan(basePackageClasses = SpaceRocket.class)
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses = SpaceRocketRepository.class)
public class SpaceRocketConfig {
}
