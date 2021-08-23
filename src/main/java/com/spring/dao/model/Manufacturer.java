package com.spring.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturer_id")
    private UUID id;

    @Getter
    @Setter
    @Column(name = "manufacturer_name")
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER)
    private Set<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(UUID id, String manufacturer_name, Set<Product> products) {
        this.id = id;
        this.name = manufacturer_name;
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manufacturer)) return false;
        Manufacturer that = (Manufacturer) o;
        return id.equals(that.id) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturer_id=" + id +
                ", manufacturer_name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
