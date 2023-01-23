package org.jesperancinha.std.old.webapp.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * Created by jofisaes on 11/03/2022
 */
@Configuration
public class CacheConfiguration {
    @Bean
    CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("detailCache")));
        return cacheManager;
    }
}
