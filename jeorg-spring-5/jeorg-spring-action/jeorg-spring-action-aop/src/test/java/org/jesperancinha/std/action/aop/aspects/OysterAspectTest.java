package org.jesperancinha.std.action.aop.aspects;

import org.jesperancinha.std.action.aop.beans.OysterService;
import org.jesperancinha.std.action.aop.model.Oyster;
import org.jesperancinha.std.action.aop.pickers.OysterPicker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {
        OysterAspect.class,
        OysterService.class,
        OysterPicker.class,
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
class OysterAspectTest {

    @Autowired
    private OysterPicker oysterPicker;

    @MockBean
    private OysterService oysterService;

    @Test
    void testOysterProcessing() {
        final var oyster = new Oyster();

        final Oyster pickup = oysterPicker.pickup(oyster);

        assertThat(pickup).isEqualTo(oyster);
    }
}