package com.example.assignment1.services.maps;


import com.example.assignment1.models.user;
import com.example.assignment1.services.interfaces.userInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserMap {

    @Autowired
    private userInterface userServices;

    public List<user> getAll(){
        List<user> users = new ArrayList<>();
        userServices.findAll().forEach(user -> users.add(user));
        return users;
    }
    public boolean save(user user){
        userServices.save(user);
        return  true;
    }

    public user getByEmailId(String emailId){
        List<user> allUsers = getAll();
        for(user user : allUsers){
            if(user.getEmailId().equals(emailId)){
                return user;
            }
        }
        return null;
    }

    public Optional<user> getById(Long id){
        Optional<user> user = userServices.findById(id);
        return user;
    }

}
