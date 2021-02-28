package org.jesperancinha.std.flash214.transactions.model;

import javax.persistence.AttributeConverter;

public class MovieAppearanceConverter implements AttributeConverter<String[], String> {

    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        return String.join(",", attribute);
    }

    @Override
    public String[] convertToEntityAttribute(String dbData) {
        return dbData.split(",");
    }
}
