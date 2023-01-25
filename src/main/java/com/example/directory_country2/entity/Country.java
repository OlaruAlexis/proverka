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
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "code")
    private Long codeISO;
    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Country country = (Country) o;
        return codeISO != null && Objects.equals(codeISO, country.codeISO);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
