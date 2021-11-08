package ca.gbc.assignment1.services.interfaces;

import ca.gbc.assignment1.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*********************************************************************************
        * Project: Receipe Book
        * Assignment: < assignment #1 >
        * Author(s): Rutik Patel
        * Student Number: 101235165
        * Date: 5th Oct
        * Description: implement user services interface
        *********************************************************************************/

@Repository
public interface UserServiceInterface extends CrudRepository<User, Long> {

    User getByEmail(String email);

}
