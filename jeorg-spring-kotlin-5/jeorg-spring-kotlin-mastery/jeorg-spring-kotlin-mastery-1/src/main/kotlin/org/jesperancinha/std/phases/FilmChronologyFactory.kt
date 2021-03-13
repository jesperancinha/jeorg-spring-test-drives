package org.jesperancinha.std.phases

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.stereotype.Component

@Component
class FilmChronologyFactory: BeanFactoryPostProcessor {
    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
        ConsolerizerComposer.outSpace()
            .ln()
            .black()
            .bgOrange("1. postProcessBeanFactory")
            .red(ConsolerizerComposer.title("This is phase BeanFactoryPostProcessor"))
            .blue("This is bean %s", beanFactory)
            .toConsoleLn();
        for ( beanName in beanFactory.getBeanDefinitionNames()) {
            ConsolerizerComposer.outSpace()
                .ln()
                .brightBlue("Found bean %s", beanName)
                .toConsoleLn();
        }
    }
}

