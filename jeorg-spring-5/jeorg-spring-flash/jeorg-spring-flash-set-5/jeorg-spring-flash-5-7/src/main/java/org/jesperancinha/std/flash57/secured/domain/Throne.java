package org.jesperancinha.std.flash57.secured.domain;

import org.jesperancinha.std.flash57.secured.services.ThroneType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Throne {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
	@Enumerated(EnumType.STRING)
    private ThroneType throneType;

    @Column
    private String keeper;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ThroneType getThroneType() {
        return throneType;
    }

    public void setThroneType(ThroneType throneType) {
        this.throneType = throneType;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    @Override
    public String toString() {
        return "Throne{" +
                "id=" + id +
                ", throneType=" + throneType +
                ", keeper='" + keeper + '\'' +
                '}';
    }
}
