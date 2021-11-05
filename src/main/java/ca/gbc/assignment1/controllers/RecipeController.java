package ca.gbc.assignment1.controllers;

import ca.gbc.assignment1.models.Recipe;
import ca.gbc.assignment1.models.User;
import ca.gbc.assignment1.services.maps.RecipeMap;
import ca.gbc.assignment1.services.maps.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    @Autowired
    RecipeMap recipeService;

    @Autowired
    UserMap userService;

    @GetMapping({
            "/recipe/all"
    })
    public String listRecipes(HttpServletRequest request, Model model) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        boolean isLoggedIn = userId != null;
        if (!isLoggedIn) {
            return "redirect:/login";
        }
        User currentUser = userService.getById(userId).get();
        List<Recipe> recipes = currentUser.getRecipes();
        model.addAttribute("recipes", recipes);
        model.addAttribute("authenticated", isLoggedIn);
        return "recipe/list";
    }

    @GetMapping({
            "/recipe/new"
    })
    public String getNewRecipe(HttpServletRequest request, Model model) {
        boolean isLoggedIn = request.getSession().getAttribute("userId") != null;
        if (!isLoggedIn) {
            return "redirect:/login";
        }
        model.addAttribute("recipe", new Recipe());
        return "recipe/form";
    }

    @PostMapping({
            "/recipe/new"
    })
    public String postNewRecipe(HttpServletRequest request, @ModelAttribute Recipe recipe, Model model) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        boolean isLoggedIn = userId != null;
        if (!isLoggedIn) {
            return "redirect:/login";
        }
        Optional<User> currentUser = userService.getById(userId);
        recipe.setCreator(currentUser.get());
        recipeService.save(recipe);
        return "recipe/form";
    }

    @GetMapping({
            "/recipe/{id}"
    })
    public String getRecipe(HttpServletRequest request, @PathVariable Long id, Model model) {
        boolean isLoggedIn = request.getSession().getAttribute("userId") != null;
        if (!isLoggedIn) {
            return "redirect:/login";
        }
        Optional<Recipe> recipe = recipeService.getById(id);
        model.addAttribute("recipe", recipe);
        return "recipe/form";
    }

}
