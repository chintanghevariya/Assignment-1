package com.example.assignment1.services.interfaces;

import com.example.assignment1.models.user;
import org.springframework.data.repository.CrudRepository;

public interface userInterface extends CrudRepository<user,Long> {
    user getByEmailId(String emailId);
}
