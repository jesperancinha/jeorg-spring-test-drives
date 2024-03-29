package org.jesperancinha.std.action.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jesperancinha.std.action.aop.beans.GambaService;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GambaAspect {

    private final GambaService gambaService;

    public GambaAspect(GambaService gambaService) {
        this.gambaService = gambaService;
    }

    @Before("execution(public * org.jesperancinha.std.action.aop.catchers.GambaFoodCatcher.*()) " +
            "&& within(org.jesperancinha.std.action.aop.catchers.G*))")
    public void beforeWithin(final JoinPoint joinPoint) {
        gambaService.beforeWithin(joinPoint);
    }

    @Before("execution(public * org.jesperancinha.std.action.aop.catchers.GambaFoodCatcher.catchByHand()) " +
            "&& @annotation(org.jesperancinha.std.action.aop.annotations.Master))")
    public void beforeWithinNoAtAnnotation(final JoinPoint joinPoint) {
        gambaService.beforeWithinNoAtAnnotation(joinPoint);

    }

    @Before("@within(org.jesperancinha.std.action.aop.annotations.Master)")
    public void beforeWithinAnnotation(final JoinPoint joinPoint) {
        gambaService.beforeWithinAnnotation(joinPoint);
    }

    @Before("execution(@org.jesperancinha.std.action.aop.annotations.Master public * org.jesperancinha.std.action.aop.catchers.GambaFoodCatcher.*()))")
    public void beforeExecution(final JoinPoint joinPoint) {
        gambaService.beforeExecution(joinPoint);
    }

    @Before("@annotation(org.jesperancinha.std.action.aop.annotations.Master)")
    public void beforeAnnotation(final JoinPoint joinPoint) {
        gambaService.beforeAnnotation(joinPoint);
    }
}
