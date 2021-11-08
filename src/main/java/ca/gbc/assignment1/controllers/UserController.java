package ca.gbc.assignment1.controllers;

import ca.gbc.assignment1.models.User;
import ca.gbc.assignment1.services.interfaces.UserServiceInterface;
import ca.gbc.assignment1.services.maps.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/*********************************************************************************
 * Project: Receipe Book
 * Assignment: < assignment #1 >
 * Author(s): Rutik Patel
 * Student Number: 101235165
 * Date: 3rd Oct
 * Description: implement login functionality, sign up and profile etc.
 *********************************************************************************/

@Controller
public class UserController {

    @Autowired
    private UserMap userService;

    @GetMapping({
            "/login",
            "/login.html"
    })
    public String login(HttpServletRequest request, Model model) {
        boolean isLoggedIn = request.getSession().getAttribute("userId") != null;
        if (isLoggedIn) {
            return "redirect:/recipe/all";
        }
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping({
            "/login",
            "/login.html"
    })
    public String loginSubmit(HttpServletRequest request, @ModelAttribute User user, Model model) {
        boolean userFound = false;
        User userAccount = userService.getByEmail(user.getEmail());
        if (userAccount != null && userAccount.getPassword().equals(user.getPassword())) {
            request.getSession().setAttribute("userId", userAccount.getId());
            userFound = true;
        }
        model.addAttribute("userFound", userFound);
        return "redirect:/recipe/all";
    }

    @GetMapping({
            "/signup",
            "/signup.html"
    })
    public String signup(HttpServletRequest request, Model model) {
        boolean isLoggedIn = request.getSession().getAttribute("userId") != null;
        if (isLoggedIn) {
            return "redirect:/recipe/all";
        }
        model.addAttribute("user", new User());
        return "user/signup";
    }

    @PostMapping({
            "/signup",
            "/signup.html"
    })
    public String signupSubmit(HttpServletRequest request, @ModelAttribute User user, Model model) {
        boolean userCreated = userService.save(user);
        if (userCreated) {
            request.getSession().setAttribute("userId", user.getId());
            return "redirect:/recipe/all";
        }
        return "user/signup";
    }

    @GetMapping({"/profile/{id}"})
    public String profile(HttpServletRequest request, @PathVariable Long id, Model model) {
        boolean isLoggedIn = request.getSession().getAttribute("userId") != null;
        System.out.println(isLoggedIn);
        if(isLoggedIn) {
            User user = userService.getById(id).get();
            model.addAttribute("user", user);
            model.addAttribute("recipes", user.getRecipes());

            return "user/profile";
        }

        model.addAttribute("userId", request.getSession().getAttribute("userId"));

        return "redirect:login";
    }




    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("userId");
        return "redirect:/";
    }


}
