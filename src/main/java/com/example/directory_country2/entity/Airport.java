package com.example.directory_country2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @Column(name = "codeIATA")
    private String codeIATA;

    @Column(name = "name")
    private String name;

    @Column(name = "nameOfCountry")
    private String nameOfCountry;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Airport airport = (Airport) o;
        return codeIATA != null && Objects.equals(codeIATA, airport.codeIATA);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
