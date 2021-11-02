package com.example.assignment1.services.interfaces;

import com.example.assignment1.models.receipe;
import org.springframework.data.repository.CrudRepository;

public interface receipeInterface extends CrudRepository<receipe,Long> {
}
