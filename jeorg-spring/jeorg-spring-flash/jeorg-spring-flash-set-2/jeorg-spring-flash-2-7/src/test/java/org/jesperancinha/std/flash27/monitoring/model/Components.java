package org.jesperancinha.std.flash27.monitoring.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_ = @JsonCreator)
public class Components {
    @JsonProperty("db")
    public DataBaseF27 db;
    @JsonProperty("diskSpace")
    public DiskSpace diskSpace;
    @JsonProperty("flash27")
    public Flash27 flash27;
    @JsonProperty("ping")
    public Ping ping;
}
