package org.jesperancinha.std.flash5.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
@SequenceGenerator(
        name = "potatoSequenceGenerator",
        sequenceName = "potatoSequence",
        initialValue = 50,
        allocationSize = 15)
public class Potato {

    @Id
    @GeneratedValue(generator = "potatoSequenceGenerator")
    @Column(unique = true)
    private Long id;

    @Column
    private String form;

    @Column
    private LocalDateTime localDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
