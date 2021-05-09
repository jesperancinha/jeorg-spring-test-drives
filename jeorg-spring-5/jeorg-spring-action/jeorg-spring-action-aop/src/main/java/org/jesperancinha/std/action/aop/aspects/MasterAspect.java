package org.jesperancinha.std.action.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jesperancinha.std.action.aop.annotations.Master;
import org.jesperancinha.std.action.aop.beans.MasterService;
import org.springframework.stereotype.Component;

@Master
@Aspect
@Component
public class MasterAspect {

    private final MasterService masterService;

    public MasterAspect(MasterService masterService) {
        this.masterService = masterService;
    }

    @Before("within(@org.jesperancinha.std.action.aop.annotations.Master org.jesperancinha.std.action.aop.catchers.*)")
    public void masterize(final JoinPoint joinPoint) {
        masterService.masterize(joinPoint);
    }
}
