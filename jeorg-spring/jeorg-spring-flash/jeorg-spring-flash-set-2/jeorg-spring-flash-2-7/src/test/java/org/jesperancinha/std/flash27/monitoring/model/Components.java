package org.jesperancinha.std.flash27.monitoring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Components(@JsonProperty("db") DataBaseF27 db,
                         @JsonProperty("diskSpace") DiskSpace diskSpace,
                         @JsonProperty("flash27") Flash27 flash27,
                         @JsonProperty("ping") Ping ping) {
}
