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
            .autoWrite()
            .file("/tmp/jeorg-spring-kotlin-mastery-1.txt")
            .bgOrange("1. postProcessBeanFactory")
            .red(ConsolerizerComposer.title("This is phase BeanFactoryPostProcessor"))
            .blue("This is bean %s", beanFactory)
        for ( beanName in beanFactory.getBeanDefinitionNames()) {
            ConsolerizerComposer.outSpace()
                .ln()
                .autoWrite()
                .file("/tmp/jeorg-spring-kotlin-mastery-1.txt")
                .brightBlue("Found bean %s", beanName)
        }
    }
}

