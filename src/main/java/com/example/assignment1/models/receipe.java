package com.example.assignment1.models;

import javax.persistence.*;

public class receipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String receipeName;
    private boolean favourite;

    @ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    private user person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceipeName() {
        return receipeName;
    }

    public void setReceipeName(String receipeName) {
        this.receipeName = receipeName;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public user getPerson() {
        return person;
    }

    public void setPerson(user person) {
        this.person = person;
    }
}
