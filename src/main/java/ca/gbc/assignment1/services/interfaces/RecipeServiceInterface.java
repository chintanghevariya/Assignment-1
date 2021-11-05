package ca.gbc.assignment1.services.interfaces;

import ca.gbc.assignment1.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeServiceInterface extends CrudRepository<Recipe, Long> {
}
