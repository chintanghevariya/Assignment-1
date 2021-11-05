package ca.gbc.assignment1.controllers;

import ca.gbc.assignment1.models.User;
import ca.gbc.assignment1.services.interfaces.UserServiceInterface;
import ca.gbc.assignment1.services.maps.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class IndexController {

    @RequestMapping({
            "",
            "/",
            "/index.html",
            "/index"
    })
    public String index() {
        return "index";
    }

}
