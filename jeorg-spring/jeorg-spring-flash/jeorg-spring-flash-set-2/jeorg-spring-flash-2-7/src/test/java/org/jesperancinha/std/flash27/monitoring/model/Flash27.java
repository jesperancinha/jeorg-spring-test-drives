package org.jesperancinha.std.flash27.monitoring.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_ = @JsonCreator)
public class Flash27 {
    @JsonProperty("status")
    String status;
    @JsonProperty("details")
    Details details;
}
