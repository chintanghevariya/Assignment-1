package ca.gbc.assignment1.services.maps;

import ca.gbc.assignment1.models.User;
import ca.gbc.assignment1.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*********************************************************************************
 * Project: Receipe Book
 * Assignment: < assignment #1 >
 * Author(s): Shrey Patel
 * Student Number: 101281313
 * Date: 2nd Oct
 * Description: implemented userMaps
 *********************************************************************************/

@Service
public class UserMap {

    @Autowired
    private UserServiceInterface userService;

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        userService.findAll().forEach(user -> users.add(user));
        return users;
    }

    public boolean save(User user) {
        System.out.println(userService);
        userService.save(user);
        return true;
    }

    public User getByEmail(String email) {
        List<User> allUsers  = getAll();
        for (User user : allUsers) {
            if (user.getEmail().equals(email)) {
                System.out.println("here");
                return user;
            }
        }
        return null;
    }

    public Optional<User> getById(Long id) {
        Optional<User> user = userService.findById(id);
        return user;
    }


}
