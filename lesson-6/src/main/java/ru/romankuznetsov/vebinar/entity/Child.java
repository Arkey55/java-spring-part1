package ru.romankuznetsov.vebinar.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "child")
public class Child {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    @Column(name = "name", length = 128)
    private String firstName;
    @Column(name = "last_name", length = 128)
    private String lastName;

    @ManyToMany
    @JoinTable(name = "person_child",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> persons;

    public Child() {
    }

    @Override
    public String toString() {
        return String.format("id: %s, firstName: %s, lastName: %s", id, firstName, lastName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
