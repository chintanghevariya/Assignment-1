package ca.gbc.assignment1.models;

import javax.persistence.*;
import java.util.List;
/*********************************************************************************
 * Project: Receipe Book
 * Assignment: < assignment #1 >
 * Author(s): Shrey Patel
 * Student Number: 101281313
 * Date: 2nd Oct
 * Description: implement getters and setters
 *********************************************************************************/

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName, lastName, email, password;

    @OneToMany(mappedBy = "creator")
    private List<Recipe> recipes;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
