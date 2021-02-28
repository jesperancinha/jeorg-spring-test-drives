package org.jesperancinha.std.flash214.transactions.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String[] getMovieAppearances() {
        return movieAppearances;
    }

    public void setMovieAppearances(String[] movieAppearances) {
        this.movieAppearances = movieAppearances;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", movieAppearances=" + Arrays.toString(movieAppearances) +
                '}';
    }
}
