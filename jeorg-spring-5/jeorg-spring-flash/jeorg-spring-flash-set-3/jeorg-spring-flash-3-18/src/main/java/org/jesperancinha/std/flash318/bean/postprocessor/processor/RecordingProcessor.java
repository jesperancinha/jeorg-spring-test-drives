package org.jesperancinha.std.flash318.bean.postprocessor.processor;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class RecordingProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("recording")) {
            ConsolerizerColor.BRIGHT_BLUE.printGenericLn("Recording of %s started", bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("recording")) {
            ConsolerizerColor.RED.printGenericLn("Recording of %s ended", bean);
        }
        return bean;
    }
}
