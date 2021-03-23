package org.jesperancinha.std.action.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CodAspect {

    @Before("within(org.jesperancinha.std.action.aop.methods..*)")
    public void withinTheCode() {
        ConsolerizerComposer.outSpace()
                .none()
                .white("We are going to catch a")
                .magenta("CodFish")
                .white("!")
                .magenta("You see? We always say that")
                .red("within")
                .magenta("...")
                .newLine()
                .reset();
    }
}
