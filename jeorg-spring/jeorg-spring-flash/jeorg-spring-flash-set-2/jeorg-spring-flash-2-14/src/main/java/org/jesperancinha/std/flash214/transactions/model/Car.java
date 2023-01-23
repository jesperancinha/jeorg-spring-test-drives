package org.jesperancinha.std.flash214.transactions.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private String brand;

    @Column
    private Integer year;

    @Column
    @Convert(converter = MovieAppearanceConverter.class)
    private String[] movieAppearances;

    @Transient
    public Car clone() {
        return new CarBuilder()
                .model(this.model)
                .brand(this.brand)
                .year(this.year)
                .movieAppearances(this.movieAppearances)
                .build();
    }
}
