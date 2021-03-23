package ru.romankuznetsov.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private int price;

    @ManyToMany(mappedBy = "products")
    private List<Person> persons;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return String.format("id: %s, title: %s, price: %s", id, title, price);
    }
}
