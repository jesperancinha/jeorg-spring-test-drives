package org.jesperancinha.std.flash215.beanpostprocessor.bean;

import java.util.ArrayList;
import java.util.List;

public class Cheese {
    private String name;

    private String url;

    private final List<String> checks = new ArrayList<>();

    public Cheese(){
        //CDI
    }
    public Cheese(String name) {
        this.name = name;
    }

    public Cheese(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getChecks() {
        return checks;
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", checks=" + checks +
                '}';
    }
}
