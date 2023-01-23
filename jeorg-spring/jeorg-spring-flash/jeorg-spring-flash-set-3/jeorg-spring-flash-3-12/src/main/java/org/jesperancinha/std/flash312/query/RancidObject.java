package org.jesperancinha.std.flash312.query;

import lombok.Data;

@Data
public class RancidObject {
    private String name;

    public RancidObject(String name) {
        this.name = name;
    }
}
