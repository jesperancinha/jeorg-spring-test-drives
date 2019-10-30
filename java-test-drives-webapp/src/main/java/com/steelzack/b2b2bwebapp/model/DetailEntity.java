package com.steelzack.b2b2bwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Cacheable("detailCache")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(name = "detail", catalog = "test", schema = "public")
public class DetailEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name ="name")
    private String name;

    @Transient
    private String city;

}
