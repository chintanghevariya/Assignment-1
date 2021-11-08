package ca.gbc.assignment1.models;

import javax.persistence.*;

@Entity
public class Recipe {

    /*********************************************************************************
     * Project: Receipe Book
     * Assignment: < assignment #1 >
     * Author(s): Shrey Patel
     * Student Number: 101281313
     * Date: 2nd Oct
     * Description: implement getters and setters
     *********************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String recipeName, steps, ingredients;
    private boolean isFavorite;

    @ManyToOne
    @JoinColumn(name="creator_id", nullable = false)
    private User creator;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCreator(User user) {
        creator = user;
    }

    public User getCreator() { return creator; }

    public String getIngredients() {
        return ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
