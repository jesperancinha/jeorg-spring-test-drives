package org.jesperancinha.std.action.aop.methods;

import org.aspectj.lang.JoinPoint;
import org.jesperancinha.std.action.aop.aspects.BonitoAspect2;
import org.jesperancinha.std.action.aop.aspects.GambaAspect;
import org.jesperancinha.std.action.aop.beans.Bonito4Service;
import org.jesperancinha.std.action.aop.beans.GambaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;


@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {
        GambaFoodCatcher.class,
        GambaAspect.class
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
class GambaFoodCatcherTest {

    @MockBean
    private GambaService gambaService;

    @Autowired
    private GambaFoodCatcher gambaFoodCatcher;

    @Captor
    private ArgumentCaptor<JoinPoint> joinPointArgumentCaptor;

    @Test
    void catchWithNet() {
        gambaFoodCatcher.catchWithNet();

        verify(gambaService, only()).beforeWithin(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getSignature().toString())
                .isEqualTo("Gamba org.jesperancinha.std.action.aop.methods.GambaFoodCatcher.catchWithNet()");
    }

    @Test
    void catchWithFishingPole() {
    }

    @Test
    void catchByHand() {
        gambaFoodCatcher.catchByHand();

        verify(gambaService, times(1)).beforeAnnotation(joinPointArgumentCaptor.capture());
//        verify(gambaService, times(1)).beforeWithinNoAtAnnotation(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getSignature().toString())
                .isEqualTo("Gamba org.jesperancinha.std.action.aop.methods.GambaFoodCatcher.catchByHand()");
    }

    @Test
    void catchByHandExtra() {
    }

    @Test
    void catchWithClaws() {
    }

    @Test
    void catchWithSuperSonicWaves() {
    }

    @Test
    void catchWithABucket() {
    }

    @Test
    void catchWithLove() {
    }
}