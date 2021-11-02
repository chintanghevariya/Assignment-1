package com.example.assignment1.services.maps;

import com.example.assignment1.models.receipe;
import com.example.assignment1.services.interfaces.receipeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReceipeMap {
    @Autowired
    receipeInterface receipeService;
    public List<receipe> getAll(){
        List<receipe> receipes = new ArrayList<>();
        receipeService.findAll().forEach(receipe -> receipes.add(receipe));
        return receipes;
    }

    public Optional<receipe> getById(Long id){
        Optional<receipe> receipe = receipeService.findById(id);
        return receipe;
    }

    public boolean save(receipe receipe){
        receipeService.save(receipe);
        return true;
    }

}
