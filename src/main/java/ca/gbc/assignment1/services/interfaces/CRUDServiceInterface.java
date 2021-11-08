package ca.gbc.assignment1.services.interfaces;

import java.util.Set;

/*********************************************************************************
 * Project: Receipe Book
 * Assignment: < assignment #1 >
 * Author(s): Nishtha patel
 * Student Number: 101241116
 * Date: 1st Oct
 * Description: implement and hanle CRUD
 *********************************************************************************/

public interface CRUDServiceInterface<T> {

    boolean create(T object);
    Set<T> getAll();
    T getById(Long id);
    boolean update(Long id, T object);
    boolean delete(Long id);

}
