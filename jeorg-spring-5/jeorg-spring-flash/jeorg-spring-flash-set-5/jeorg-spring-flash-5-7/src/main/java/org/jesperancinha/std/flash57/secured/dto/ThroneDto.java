package org.jesperancinha.std.flash57.secured.dto;

import org.jesperancinha.std.flash57.secured.services.ThroneType;

public class ThroneDto {

    private ThroneType throneType;

    private String keeper;

    public ThroneType getThroneType() {
        return throneType;
    }

    public void setThroneType(ThroneType throneType) {
        this.throneType = throneType;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    @Override
    public String toString() {
        return "JewelDto{" +
                "jewelType=" + throneType +
                ", guardian='" + keeper + '\'' +
                '}';
    }
}
