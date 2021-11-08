package ca.gbc.assignment1.controllers;

import ca.gbc.assignment1.models.User;
import ca.gbc.assignment1.services.interfaces.UserServiceInterface;
import ca.gbc.assignment1.services.maps.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
/*********************************************************************************
* Project: Receipe Book
        * Assignment: < assignment #1 >
        * Author(s): Nishtha patel
        * Student Number: 101241116
        * Date: 1st Oct
        * Description: implement index get
        *********************************************************************************/
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
