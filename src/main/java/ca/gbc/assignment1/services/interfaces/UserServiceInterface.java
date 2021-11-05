package ca.gbc.assignment1.services.interfaces;

import ca.gbc.assignment1.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceInterface extends CrudRepository<User, Long> {

    User getByEmail(String email);

}
