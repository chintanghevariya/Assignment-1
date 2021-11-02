package com.example.assignment1.controllers;
import com.example.assignment1.models.receipe;
import com.example.assignment1.models.user;
import com.example.assignment1.services.maps.ReceipeMap;
import com.example.assignment1.services.maps.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class receipeController {

    @Autowired
    ReceipeMap receipeService;

    @Autowired
    UserMap userService;

    @GetMapping({
            "/receipe/all"
    })

    public String displayReceipes(HttpServletRequest request, Model model){
        Long uId = (long) request.getSession().getAttribute("uId");
        boolean loggedIn = uId != null;
        if(!loggedIn){
            return "redirect:/singIn";
        }
        user currentUser = userService.getById(uId).get();
        List<receipe> receipes = currentUser.getReceipes();
        model.addAttribute("receipes",receipes);
        model.addAttribute("Authorised",loggedIn);

        return "receipes/display";
    }

    @GetMapping({
            "/receipe/new"
    })

    public String getNewReceipes(HttpServletRequest request, Model model){
        boolean loggedIn = request.getSession().getAttribute("uId") != null;
        if(!loggedIn){
            return "redirect:/signIn";
        }
        model.addAttribute("receipe", new receipe());
        return "receipe/form";
    }

    @PostMapping({
            "/receipe/new"
    })
    public String postNewRecipe(HttpServletRequest request, @ModelAttribute receipe receipe, Model model) {
        Long userId = (Long) request.getSession().getAttribute("uId");
        boolean loggedIn = userId != null;
        if (!loggedIn) {
            return "redirect:/signIn";
        }
        Optional<user> currentUser = userService.getById(userId);
        receipe.setPerson(currentUser.get());
        receipeService.save(receipe);
        return "receipe/form";
    }

    @GetMapping({
            "/receipe/{uid}"
    })
    public String getReceipe(HttpServletRequest request, @PathVariable Long id, Model model) {
        boolean loggedIn = request.getSession().getAttribute("uId") != null;
        if (!loggedIn) {
            return "redirect:/signIn";
        }
        Optional<receipe> receipe = receipeService.getById(id);
        model.addAttribute("receipe", receipe);
        return "receipe/form";
    }
}
