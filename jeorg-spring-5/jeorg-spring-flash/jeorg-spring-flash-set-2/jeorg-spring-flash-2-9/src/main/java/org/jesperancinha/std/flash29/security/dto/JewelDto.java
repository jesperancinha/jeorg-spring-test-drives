package org.jesperancinha.std.flash29.security.dto;

import org.jesperancinha.std.flash29.security.services.JewelType;

public class JewelDto {

    private JewelType jewelType;

    private String guardian;

    public JewelType getJewelType() {
        return jewelType;
    }

    public void setJewelType(JewelType jewelType) {
        this.jewelType = jewelType;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    @Override
    public String toString() {
        return "JewelDto{" +
                "jewelType=" + jewelType +
                ", guardian='" + guardian + '\'' +
                '}';
    }
}
