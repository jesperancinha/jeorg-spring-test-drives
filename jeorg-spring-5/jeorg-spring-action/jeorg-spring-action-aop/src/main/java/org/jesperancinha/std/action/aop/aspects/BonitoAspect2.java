package org.jesperancinha.std.action.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BonitoAspect2 {

    @Pointcut("execution(public org.jesperancinha.std.action.aop.model.Bonito org.jesperancinha.std.action.aop.methods.BonitoCatcher.catchWithClaws())")
    public void waitPrivatelyForFishCatch() {
    }

    @Before("waitPrivatelyForFishCatch()")
    public void waitForFishCatch(){
        ConsolerizerComposer.outSpace()
                .bgBlue()
                .unicorns(100)
                .reset()
                .blue("Waiting for fish...");
    }
}
