package org.jesperancinha.b2b2java8.comparing;

import lombok.Builder;

import java.util.Date;

/**
 * Created by jesperancinha on 10-5-16.
 */
@Builder
class Plant {
    String scientificName;
    int height;
    Date birthday;

    String getScientificName() {
        return scientificName;
    }

    int getHeight() {
        return height;
    }

    Date getPlantingDate() {
        return birthday;
    }
}
