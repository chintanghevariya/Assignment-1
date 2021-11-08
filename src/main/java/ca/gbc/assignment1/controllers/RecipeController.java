package ca.gbc.assignment1.controllers;

import ca.gbc.assignment1.models.Recipe;
import ca.gbc.assignment1.models.User;
import ca.gbc.assignment1.services.maps.RecipeMap;
import ca.gbc.assignment1.services.maps.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
/*********************************************************************************
 * Project: Receipe Book
 * Assignment: < assignment #1 >
 * Author(s): Chintan Ghevariya
 * Student Number: 101236361
 * Date: 2nd Oct
 * Description: implement controller (listRecipes, getNewRecipes , Search, etc.)
 *********************************************************************************/
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
        model.addAttribute("userId", userId);
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
        model.addAttribute("userId", request.getSession().getAttribute("userId"));


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
        model.addAttribute("userId", userId);

        return "redirect:/recipe/all";
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
        model.addAttribute("recipe", recipe.get());
        model.addAttribute("userId", request.getSession().getAttribute("userId"));

        return "recipe/details";
    }

    @GetMapping({
            "/search"
    })
    public String search(HttpServletRequest request, Model model) {
        boolean isLoggedIn = request.getSession().getAttribute("userId") != null;
        if (!isLoggedIn) {
            return "redirect:/login";
        }
        model.addAttribute("userId", request.getSession().getAttribute("userId"));

        return "user/search";
    }

    @PostMapping({
            "/search"
    })
    public String postSearch(HttpServletRequest request, @RequestParam("search") String search, Model model) {
        boolean isLoggedIn = request.getSession().getAttribute("userId") != null;
        if (!isLoggedIn) {
            return "redirect:/login";
        }

        List<Recipe> recipes = recipeService.searchRecipes(search);
        System.out.println(recipes);
        model.addAttribute("recipes", recipes);
        model.addAttribute("userId", request.getSession().getAttribute("userId"));

        return "user/search";
    }



}
