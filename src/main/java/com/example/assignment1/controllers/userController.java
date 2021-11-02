package com.example.assignment1.controllers;

import com.example.assignment1.models.user;
import com.example.assignment1.services.maps.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class userController {
    @Autowired
    private UserMap userServices;
    @GetMapping({
            "login"
    })
    public String login(HttpServletRequest request, Model model){
        boolean loggedIn = request.getSession().getAttribute("uId") != null;
        if(!loggedIn){
            return "redirect:receipe/all";
        }
        model.addAttribute("user",new user());
        return "user/signin";
    }
    @PostMapping({
            "signin"
    })
    public String loginSubmit(HttpServletRequest request, @ModelAttribute user user, Model model) {
        boolean userFound = false;
        user userAcc = userServices.getByEmailId(user.getEmailId());
        if (userAcc != null && userAcc.getPassword().equals(user.getPassword())) {
            request.getSession().setAttribute("uId", userAcc.getId());
            userFound = true;
        }
        model.addAttribute("userFound", userFound);
        return "user/signin";
    }

    @GetMapping({
            "/signup",
            "/signup.html"
    })
    public String signup(HttpServletRequest request, Model model) {
        boolean isLoggedIn = request.getSession().getAttribute("uId") != null;
        if (isLoggedIn) {
            return "redirect:/receipe/all";
        }
        model.addAttribute("user", new user());
        return "user/signup";
    }

    @PostMapping({
            "/signup",
            "/signup.html"
    })
    public String signupSubmit(HttpServletRequest request, @ModelAttribute user user, Model model) {
        boolean userCreated = userServices.save(user);
        if (userCreated) {
            request.getSession().setAttribute("uId", user.getId());
            return "redirect:/receipe/all";
        }
        return "user/signup";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("userId");
        return "redirect:/main";
    }
}
