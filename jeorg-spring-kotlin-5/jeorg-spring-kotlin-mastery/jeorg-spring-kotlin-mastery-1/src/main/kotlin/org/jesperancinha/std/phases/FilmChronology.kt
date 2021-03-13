package org.jesperancinha.std.phases

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component

@Component
class FilmChronology : BeanPostProcessor {
    @Throws(BeansException::class)
    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        ConsolerizerComposer.outSpace()
            .ln()
            .black()
            .bgOrange("1. postProcessAfterInitialization")
            .red(ConsolerizerComposer.title("This is phase postProcessAfterInitialization"))
            .blue("This is bean %s", beanName)
            .toConsoleLn();
        return bean
    }

    @Throws(BeansException::class)
    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        ConsolerizerComposer.outSpace()
            .ln()
            .black()
            .bgOrange("2. postProcessBeforeInitialization")
            .red(ConsolerizerComposer.title("This is phase postProcessBeforeInitialization"))
            .blue("This is bean %s", beanName)
            .toConsoleLn();
        return bean
    }
}