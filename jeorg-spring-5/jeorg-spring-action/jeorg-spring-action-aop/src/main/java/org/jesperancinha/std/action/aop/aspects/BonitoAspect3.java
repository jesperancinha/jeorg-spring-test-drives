package org.jesperancinha.std.action.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BonitoAspect3 {


    @Pointcut("execution(public org.jesperancinha.std.action.aop.model.Bonito org.jesperancinha.std.action.aop.methods.BonitoCatcher.catchWithClaws())")
    public void waitPrivatelyForFishCatchWithClaw() {
    }

    @Pointcut("execution(public org.jesperancinha.std.action.aop.model.Bonito org.jesperancinha.std.action.aop.methods.BonitoCatcher.catchByHand())")
    public void waitPrivatelyForFishCatchWithHand() {
    }

    @Before("waitPrivatelyForFishCatchWithClaw() || waitPrivatelyForFishCatchWithHand()")
    public void waitForFishCatch(){
        ConsolerizerComposer.outSpace()
                .bgYellow()
                .unicorns(100)
                .reset()
                .red("We send a red light when we catch by hand or by claw")
                .reset();
    }
    @Before("!waitPrivatelyForFishCatchWithClaw() && waitPrivatelyForFishCatchWithHand()")
    public void waitForFishNoClawCatch(){
        ConsolerizerComposer.outSpace()
                .bgYellow()
                .unicorns(100)
                .reset()
                .cyan("We send a cyan light when we don't catch by claw")
                .reset();
    }

}
