package ca.gbc.assignment1.services.maps;

import ca.gbc.assignment1.models.Recipe;
import ca.gbc.assignment1.services.interfaces.RecipeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeMap {

    @Autowired
    RecipeServiceInterface recipeService;

    public List<Recipe> getAll() {
        List<Recipe> recipes = new ArrayList<>();
        recipeService.findAll().forEach(recipe -> recipes.add(recipe));
        return recipes;
    }

    public Optional<Recipe> getById(Long id) {
        Optional<Recipe> recipe = recipeService.findById(id);
        return recipe;
    }

    public boolean save(Recipe recipe) {
        recipeService.save(recipe);
        return true;
    }

}
