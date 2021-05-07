package org.jesperancinha.std.action.aop;

import org.jesperancinha.std.action.aop.aspects.BonitoAspect;
import org.jesperancinha.std.action.aop.aspects.BonitoAspect2;
import org.jesperancinha.std.action.aop.aspects.BonitoAspect3;
import org.jesperancinha.std.action.aop.aspects.CodAspect;
import org.jesperancinha.std.action.aop.beans.Bonito1Service;
import org.jesperancinha.std.action.aop.beans.Bonito2Service;
import org.jesperancinha.std.action.aop.beans.Bonito3Service;
import org.jesperancinha.std.action.aop.beans.CodService;
import org.jesperancinha.std.action.aop.catchers.BonitoCatcher;
import org.jesperancinha.std.action.aop.catchers.cod.CodCatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ComponentScan({
        "org.jesperancinha.std.action.aop.catchers.cod",
        "org.jesperancinha.std.action.aop.catchers",
        "org.jesperancinha.std.action.aop.beans",
        "org.jesperancinha.std.action.aop.aspects"
})
@ContextConfiguration(classes = {
        BonitoCatcher.class, CodCatcher.class,
        BonitoAspect.class, BonitoAspect2.class, BonitoAspect3.class, CodAspect.class,
        Bonito1Service.class, Bonito2Service.class, Bonito3Service.class, CodService.class
})
class JeorgActionAOPLauncherExtensionTest {

    @Autowired
    private BonitoCatcher bonitoCatcher;

    @Autowired
    private CodCatcher codCatcher;

    @Test
    void testContext() {
        bonitoCatcher.catchByHand();
        bonitoCatcher.catchByHandExtra();
        bonitoCatcher.catchWithClaws();
        codCatcher.catchByHand();
    }
}