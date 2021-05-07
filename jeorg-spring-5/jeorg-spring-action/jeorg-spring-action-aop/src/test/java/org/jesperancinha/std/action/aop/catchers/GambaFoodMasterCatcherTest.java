package org.jesperancinha.std.action.aop.catchers;

import org.aspectj.lang.JoinPoint;
import org.jesperancinha.std.action.aop.aspects.BonitoAspect;
import org.jesperancinha.std.action.aop.aspects.BonitoAspect2;
import org.jesperancinha.std.action.aop.aspects.BonitoAspect3;
import org.jesperancinha.std.action.aop.aspects.BonitoAspect4;
import org.jesperancinha.std.action.aop.aspects.GambaAspect;
import org.jesperancinha.std.action.aop.aspects.MasterAspect;
import org.jesperancinha.std.action.aop.beans.Bonito1Service;
import org.jesperancinha.std.action.aop.beans.Bonito2Service;
import org.jesperancinha.std.action.aop.beans.Bonito3Service;
import org.jesperancinha.std.action.aop.beans.Bonito4Service;
import org.jesperancinha.std.action.aop.beans.CodService;
import org.jesperancinha.std.action.aop.beans.GambaService;
import org.jesperancinha.std.action.aop.beans.MasterService;
import org.jesperancinha.std.action.aop.beans.TunaService;
import org.jesperancinha.std.action.aop.catchers.BonitoCatcher;
import org.jesperancinha.std.action.aop.catchers.GambaFoodCatcher;
import org.jesperancinha.std.action.aop.catchers.MackerelCatcher;
import org.jesperancinha.std.action.aop.catchers.MegaTunaCatcher;
import org.jesperancinha.std.action.aop.catchers.SardineCatcher;
import org.jesperancinha.std.action.aop.catchers.ShrimpCatcher;
import org.jesperancinha.std.action.aop.catchers.TunaCatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;


@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {
        GambaFoodCatcher.class,
        BonitoCatcher.class,
        MackerelCatcher.class,
        MegaTunaCatcher.class,
        SardineCatcher.class,
        ShrimpCatcher.class,
        TunaCatcher.class,
        GambaAspect.class,
        MasterAspect.class,
        BonitoAspect.class,
        BonitoAspect2.class,
        BonitoAspect3.class,
        BonitoAspect4.class
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
class GambaFoodMasterCatcherTest {

    @MockBean
    private GambaService gambaService;

    @MockBean
    private MasterService masterService;

    @MockBean
    private TunaService tunaService;

    @MockBean
    private CodService codService;

    @MockBean
    private Bonito1Service bonito1Service;

    @MockBean
    private Bonito2Service bonito2Service;

    @MockBean
    private Bonito3Service bonito3Service;

    @MockBean
    private Bonito4Service bonito4Service;

    @Autowired
    private GambaFoodCatcher gambaFoodCatcher;

    @Autowired
    private BonitoCatcher bonitoCatcher;

    @Autowired
    private MackerelCatcher mackerelCatcher;

    @Autowired
    private MegaTunaCatcher megaTunaCatcher;

    @Autowired
    private SardineCatcher sardineCatcher;

    @Autowired
    private ShrimpCatcher shrimpCatcher;

    @Autowired
    private TunaCatcher tunaCatcher;

    @Captor
    private ArgumentCaptor<JoinPoint> joinPointArgumentCaptor;

    @Test
    void testCatchWithNet_whenCallingMasterAnnotatedMethod_thenTriggerTheRightAdvices() {
        gambaFoodCatcher.catchWithNet();
        bonitoCatcher.catchWithNet();
        mackerelCatcher.catchWithNet();
        megaTunaCatcher.catchWithNet();
        sardineCatcher.catchWithNet();
        shrimpCatcher.catchWithNet();
        tunaCatcher.catchWithNet();

        verify(gambaService, times(1)).beforeWithin(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getSignature().toString())
                .isEqualTo("Gamba org.jesperancinha.std.action.aop.catchers.GambaFoodCatcher.catchWithNet()");
        verify(gambaService, times(1)).beforeWithinAnnotation(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue2 = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue2.getSignature().toString())
                .isEqualTo("Gamba org.jesperancinha.std.action.aop.catchers.GambaFoodCatcher.catchWithNet()");
        verify(masterService, only()).masterize(joinPointArgumentCaptor.capture());
        final var joinPointArgumentCaptorValue1 = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue1.getSignature().toString())
                .isEqualTo("Gamba org.jesperancinha.std.action.aop.catchers.GambaFoodCatcher.catchWithNet()");
        verifyNoInteractions(tunaService);
        verifyNoInteractions(codService);
        verifyNoInteractions(bonito4Service);
        verifyNoInteractions(bonito3Service);
        verify(bonito2Service, atLeast(1)).beforeAnyCatch(joinPointArgumentCaptor.capture());
        final var allValuesForBonito2Service = joinPointArgumentCaptor.getAllValues();
        IntStream.range(3, allValuesForBonito2Service.size()-1)
                .forEach(i-> assertThat(joinPointArgumentCaptorValue1.getSignature().toString())
                        .isNotEqualTo("Gamba org.jesperancinha.std.action.aop.catchers.GambaFoodCatcher.catchWithNet()"));
        verifyNoInteractions(bonito1Service);
    }
}