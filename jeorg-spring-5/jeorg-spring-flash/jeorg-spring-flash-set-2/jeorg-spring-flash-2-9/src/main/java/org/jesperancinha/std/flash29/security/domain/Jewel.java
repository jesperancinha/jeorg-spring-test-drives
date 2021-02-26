package org.jesperancinha.std.flash29.security.domain;


import org.jesperancinha.std.flash29.security.services.JewelType;

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
public class Jewel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
	@Enumerated(EnumType.STRING)
    private JewelType jewelType;

    @Column
    private String guardian;

	public JewelType getJewelType() {
		return jewelType;
	}

	public void setJewelType(JewelType jewelType) {
		this.jewelType = jewelType;
	}

	public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String owner) {
        this.guardian = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Jewel{" +
                "id=" + id +
                ", jewelType=" + jewelType +
                ", guardian='" + guardian + '\'' +
                '}';
    }
}
