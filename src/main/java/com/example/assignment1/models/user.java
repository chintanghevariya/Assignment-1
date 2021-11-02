package com.example.assignment1.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fName, lName, emailId, password;

    @OneToMany(mappedBy="person")
    private List<receipe> receipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<receipe> getReceipes() {
        return receipes;
    }

    public void setReceipes(List<receipe> receipes) {
        this.receipes = receipes;
    }
}
