package org.jesperancinha.std.flash18.aop.afterthrowing;

import org.jesperancinha.std.flash18.aop.afterthrowing.service.impl.LyricsService;
import org.jesperancinha.std.flash18.aop.afterthrowing.service.impl.LyricsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringFlash18Launcher {
    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(SpringFlash18Launcher.class, args);
        LyricsService lyricsService = ac.getBean("lyricsServiceImpl", LyricsServiceImpl.class);
        try {
            lyricsService.enumerateLyric1();
        } finally {
            try {
                lyricsService.resultLyric1();
            } finally {
                try {
                    lyricsService.enumerateLyric2();
                } finally {
                    try {
                        lyricsService.resultLyric2();
                    } finally {
                        try {
                            lyricsService.enumerateLyric3();
                        } finally {
                            try {
                                lyricsService.resultLyric3();
                            } finally {
                                lyricsService.resultLyric4();
                            }
                        }
                    }
                }
            }
        }
    }
}
