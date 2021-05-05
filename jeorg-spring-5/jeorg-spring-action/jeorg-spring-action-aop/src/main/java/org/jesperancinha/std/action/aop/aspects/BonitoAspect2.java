package org.jesperancinha.std.action.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jesperancinha.std.action.aop.beans.Bonito2Service;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BonitoAspect2 {

    private final Bonito2Service bonito2Service;

    public BonitoAspect2(Bonito2Service bonito2Service) {
        this.bonito2Service = bonito2Service;
    }

    @Pointcut("execution(public org.jesperancinha.std.action.aop.model.Bonito org.jesperancinha.std.action.aop.methods.BonitoCatcher.catchWithClaws())")
    public void waitPrivatelyForFishCatch() {
        bonito2Service.waitPrivatelyForFishCatch();
    }

    @Before("waitPrivatelyForFishCatch()")
    public void waitForFishCatch() {
        bonito2Service.waitForFishCatch();
    }
}
