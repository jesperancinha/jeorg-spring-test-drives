package org.jesperancinha.std.flash44.handler.mapping;

public class SpringBeanMappedInstance {
    private String name;

    private Integer order;

    private String type;

    public SpringBeanMappedInstance(String name, Integer order, String type) {
        this.name = name;
        this.order = order;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
