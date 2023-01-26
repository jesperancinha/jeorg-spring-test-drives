package org.jesperancinha.std.flash27.monitoring.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_ = @JsonCreator)
public class Details {
    @JsonProperty("database")
    public String database;
    @JsonProperty("result")
    public Integer result;
    @JsonProperty("validationQuery")
    public String validationQuery;
    @JsonProperty("total")
    public Long total;
    @JsonProperty("free")
    public Long free;
    @JsonProperty("threshold")
    public Long threshold;
    @JsonProperty("lyric")
    public String lyric;
    @JsonProperty("path")
    public String path;
    @JsonProperty("exists")
    public Boolean exists;
}
