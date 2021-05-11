package org.jesperancinha.std.action.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jesperancinha.std.action.aop.beans.HarvestingService;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HarvestingAspect {

    private final HarvestingService harvestingService;

    public HarvestingAspect(HarvestingService harvestingService) {
        this.harvestingService = harvestingService;
    }

    @Before("this(org.jesperancinha.std.action.aop.fishing.Harvester)")
    public void thisHarvester(final JoinPoint joinPoint) {
        harvestingService.thisHarvester(joinPoint);
    }

    @Before("target(org.jesperancinha.std.action.aop.fishing.Shrimper)")
    public void targetShrimper(final JoinPoint joinPoint) {
        harvestingService.targetShrimper(joinPoint);
    }

    @Before("target(org.jesperancinha.std.action.aop.fishing.Harvester)")
    public void targetHarvester(final JoinPoint joinPoint) {
        harvestingService.targetHarvester(joinPoint);
    }

    @Before("target(org.jesperancinha.std.action.aop.fishing.Fisher)")
    public void targetFisher(final JoinPoint joinPoint) {
        harvestingService.targetFisher(joinPoint);
    }

    @Before("this(org.jesperancinha.std.action.aop.fishing.Fisher)")
    public void thisFisher(final JoinPoint joinPoint) {
        harvestingService.thisFisher(joinPoint);
    }

    @Before("this(org.jesperancinha.std.action.aop.fishing.Shrimper)")
    public void thisShrimper(final JoinPoint joinPoint) {
        harvestingService.thisShrimper(joinPoint);
    }
}
