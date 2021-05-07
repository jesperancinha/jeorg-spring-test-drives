package org.jesperancinha.std.action.aop.catchers;

import org.aspectj.lang.JoinPoint;
import org.jesperancinha.std.action.aop.aspects.BonitoAspect2;
import org.jesperancinha.std.action.aop.beans.Bonito2Service;
import org.jesperancinha.std.action.aop.catchers.BonitoCatcher;
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
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {
        BonitoCatcher.class,
        BonitoAspect2.class
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
class BonitoCatcherTest {

    @MockBean
    private Bonito2Service bonito2Service;

    @Autowired
    private BonitoCatcher bonitoCatcher;

    @Captor
    private ArgumentCaptor<JoinPoint> joinPointArgumentCaptor;

    @Test
    void testCatchWithNet_whenCalled_thenTriggerAllAdvices() {
        bonitoCatcher.catchWithNet();

        verify(bonito2Service, only()).beforeAnyCatch(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getSignature().toString()).isEqualTo("Bonito org.jesperancinha.std.action.aop.catchers.BonitoCatcher.catchWithNet()");
    }

    @Test
    void testCatchWithFishingPole_whenCalled_thenTriggerAllAdvices() {
        bonitoCatcher.catchWithFishingPole();

        verify(bonito2Service, only()).beforeAnyCatch(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getSignature().toString()).isEqualTo("Bonito org.jesperancinha.std.action.aop.catchers.BonitoCatcher.catchWithFishingPole()");
    }

    @Test
    void testCatchByHand_whenCalled_thenTriggerAllAdvices() {
        bonitoCatcher.catchByHand();

        verify(bonito2Service, only()).beforeAnyCatch(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getSignature().toString()).isEqualTo("Bonito org.jesperancinha.std.action.aop.catchers.BonitoCatcher.catchByHand()");
    }

    @Test
    void testCatchByHandExtra_whenCalled_thenTriggerAllAdvices() {
        bonitoCatcher.catchByHandExtra();

        verify(bonito2Service, only()).beforeAnyCatch(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getSignature().toString()).isEqualTo("void org.jesperancinha.std.action.aop.catchers.BonitoCatcher.catchByHandExtra()");
    }

    @Test
    void testCatchWithClaws_whenCalled_thenTriggerAllAdvices() {
        bonitoCatcher.catchWithClaws();

        verify(bonito2Service, times(1)).beforeAnyCatch(joinPointArgumentCaptor.capture());
        verify(bonito2Service, times(1)).waitForFishCatch(joinPointArgumentCaptor.capture());
        final var allValues = joinPointArgumentCaptor.getAllValues();
        assertThat(allValues).hasSize(2);
        assertThat(allValues.stream()
                .map(JoinPoint::getSignature)
                .map(Object::toString))
                .contains("Bonito org.jesperancinha.std.action.aop.catchers.BonitoCatcher.catchWithClaws()", "Bonito org.jesperancinha.std.action.aop.catchers.BonitoCatcher.catchWithClaws()");
    }

    @Test
    void testCatchWithSuperSonicWaves_whenCalled_thenTriggerAllAdvices() {
        bonitoCatcher.catchWithSuperSonicWaves();

        verify(bonito2Service, only()).beforeAnyCatch(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getSignature().toString()).isEqualTo("Bonito org.jesperancinha.std.action.aop.catchers.BonitoCatcher.catchWithSuperSonicWaves()");
    }

    @Test
    void testCatchWithABucket_whenCalled_thenTriggerAllAdvices() {
        bonitoCatcher.catchWithABucket();

        verify(bonito2Service, only()).beforeAnyCatch(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getSignature().toString()).isEqualTo("Bonito org.jesperancinha.std.action.aop.catchers.BonitoCatcher.catchWithABucket()");
    }

    @Test
    void testCatchWithLove_whenCalled_thenTriggerAllAdvices() {
        bonitoCatcher.catchWithLove();

        verify(bonito2Service, only()).beforeAnyCatch(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getSignature().toString()).isEqualTo("Bonito org.jesperancinha.std.action.aop.catchers.BonitoCatcher.catchWithLove()");
    }
}