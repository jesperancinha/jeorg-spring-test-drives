package org.jesperancinha.std.flash217.jtatransactionmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Marble {
    String name;

    String color;
}
