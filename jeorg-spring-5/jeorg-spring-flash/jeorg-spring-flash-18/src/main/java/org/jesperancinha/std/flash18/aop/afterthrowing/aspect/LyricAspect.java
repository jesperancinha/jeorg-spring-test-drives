package org.jesperancinha.std.flash18.aop.afterthrowing.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.jesperancinha.console.consolerizer.Consolerizer;
import org.springframework.stereotype.Component;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;

@Aspect
@Component
public class LyricAspect {
    @AfterThrowing(value = "execution(* org.jesperancinha.std.flash18.aop.afterthrowing.service.impl.LyricsService.*(..))",
            throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        BRIGHT_MAGENTA.printGenericLn("This is the whole joinPoint -> %s", joinPoint);
        BRIGHT_MAGENTA.printGenericLn("This is the jointPoint signature -> %s", joinPoint.getSignature());
        BRIGHT_MAGENTA.printGenericLn("The is the exception being thrown -> %s", ex.getMessage());
    }

    @AfterThrowing(value = "execution(* org.jesperancinha.std.flash18.aop.afterthrowing.service.impl.LyricsService.enumerateLyric1(..))",
            throwing = "ex")
    public void afterThrowingAdvice1(JoinPoint joinPoint, Exception ex) {
        GREEN.printGenericLn("This is the whole joinPoint -> %s", joinPoint);
        GREEN.printGenericLn("This is the jointPoint signature -> %s", joinPoint.getSignature());
        GREEN.printGenericLn("The is the exception being thrown -> %s", ex.getMessage());
    }

    @AfterThrowing(value = "execution(* org.jesperancinha.std.flash18.aop.afterthrowing.service.impl.LyricsService.enumerateLyric2(..))",
            throwing = "ex")
    public void afterThrowingAdvice2(JoinPoint joinPoint, Exception ex) {
        YELLOW.printGenericLn("This is the whole joinPoint -> %s", joinPoint);
        YELLOW.printGenericLn("This is the jointPoint signature -> %s", joinPoint.getSignature());
        YELLOW.printGenericLn("The is the exception being thrown -> %s", ex.getMessage());
    }

    @AfterThrowing(value = "execution(* org.jesperancinha.std.flash18.aop.afterthrowing.service.impl.LyricsService.enumerateLyric3(..))",
            throwing = "ex")
    public void afterThrowingAdvice3(JoinPoint joinPoint, Exception ex) {
        RED.printGenericLn("This is the whole joinPoint -> %s", joinPoint);
        RED.printGenericLn("This is the jointPoint signature -> %s", joinPoint.getSignature());
        RED.printGenericLn("The is the exception being thrown -> %s", ex.getMessage());
    }

    @AfterThrowing(value = "execution(* org.jesperancinha.std.flash18.aop.afterthrowing.service.impl.LyricsService.resultLyric*(..))",
            throwing = "ex")
    public void afterThrowingAdviceResults(JoinPoint joinPoint, Exception ex) {
        Consolerizer.printRainbowTitleLn("This is the whole joinPoint -> %s", joinPoint);
        Consolerizer.printRainbowTitleLn("This is the jointPoint signature -> %s", joinPoint.getSignature());
        Consolerizer.printRainbowTitleLn("The is the exception being thrown -> %s", ex.getMessage());
    }
}