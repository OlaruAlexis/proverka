package com.example.directory_country2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "currency")
public class Currency {

    @Id
    private Long codeIso;

    private String name;

    private String nameOfCountry;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(codeIso, currency.codeIso) && Objects.equals(name, currency.name) && Objects.equals(nameOfCountry, currency.nameOfCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeIso, name, nameOfCountry);
    }
}
