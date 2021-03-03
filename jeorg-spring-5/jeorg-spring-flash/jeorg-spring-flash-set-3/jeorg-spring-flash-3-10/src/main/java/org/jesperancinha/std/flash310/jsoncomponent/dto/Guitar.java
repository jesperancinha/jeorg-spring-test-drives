package org.jesperancinha.std.flash310.jsoncomponent.dto;

import org.springframework.data.annotation.Transient;

public class Guitar {
    private String brand;

    private String model;

    private Long value;

    @Transient
    private String currency;

    public Guitar() {
    }

    public Guitar(String brand, String model, Long value, String currency) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.currency = currency;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
