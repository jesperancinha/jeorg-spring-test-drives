package org.jesperancinha.std.old.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Cacheable("detailCache")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(name = "detail",
        schema = "public")
public class DetailEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Transient
    private String city;

}
