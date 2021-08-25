package com.spring.dao.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturer_id")
    private UUID id;

    @Column(name = "manufacturer_name")
    private String name;

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
        if (!(o instanceof Manufacturer that)) return false;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
