package com.steelzack.b2b2java8.comparing;

import java.util.Date;

import lombok.Builder;

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
