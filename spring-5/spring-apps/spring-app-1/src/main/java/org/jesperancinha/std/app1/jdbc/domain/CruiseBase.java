package org.jesperancinha.std.app1.jdbc.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
@Table
public abstract class CruiseBase {

    @Id
    @Column(updatable = false, unique = true)
    private Long id;

    private String tourOperator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTourOperator() {
        return tourOperator;
    }

    public void setTourOperator(String tourOperator) {
        this.tourOperator = tourOperator;
    }
}
