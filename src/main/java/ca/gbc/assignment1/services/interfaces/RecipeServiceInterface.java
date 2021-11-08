package ca.gbc.assignment1.services.interfaces;

import ca.gbc.assignment1.models.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*********************************************************************************
 * Project: Receipe Book
 * Assignment: < assignment #1 >
 * Author(s): Chintan Ghevariya
 * Student Number: 101236361
 * Date: 5th Oct
 * Description: implement and handle receipe service interface as well as search query
 *********************************************************************************/

@Repository
public interface RecipeServiceInterface extends CrudRepository<Recipe, Long> {

    @Query("SElECT recipe FROM Recipe recipe WHERE LOWER(recipe.recipeName) LIKE %:name%")
    List<Recipe> searchByRecipeName(@Param("name") String name);

}
