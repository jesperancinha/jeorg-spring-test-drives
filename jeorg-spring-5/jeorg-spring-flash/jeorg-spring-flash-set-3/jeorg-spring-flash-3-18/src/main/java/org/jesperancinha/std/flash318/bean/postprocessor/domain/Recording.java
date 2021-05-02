package org.jesperancinha.std.flash318.bean.postprocessor.domain;

import lombok.Data;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
public class Recording implements DisposableBean, InitializingBean {
    private String title;

    private Long years;

    private String studio;

    private String address;

    public Recording() {
    }

    public Recording(String title, Long years, String studio,
                     String address) {
        this.title = title;
        this.studio = studio;
        this.address = address;
        this.years = years;
    }

    @Override
    public String toString() {
        return "Recording{" +
                "title='" + title + '\'' +
                ", years=" + years +
                ", studio='" + studio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @PostConstruct
    public void postConstruct() {
        ConsolerizerComposer.outSpace()
                .green("🥦 - We pour the broccoli soup")
                .reset();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ConsolerizerComposer.outSpace()
                .green("🥦 - We are now eating the broccoli soup.")
                .reset();
    }

    @PreDestroy
    public void preDestroy() {
        ConsolerizerComposer.outSpace()
                .green("🥦 - We scoop the rest from the pan")
                .reset();
    }

    @Override
    public void destroy() {
        ConsolerizerComposer.outSpace()
                .green("🥦 - We've eaten the broccoli soup and now we're done.")
                .reset();

    }
}
