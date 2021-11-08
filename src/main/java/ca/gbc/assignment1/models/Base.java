package ca.gbc.assignment1.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/*********************************************************************************
 * Project: Receipe Book
 * Assignment: < assignment #1 >
 * Author(s): Nishtha patel
 * Student Number: 101241116
 * Date: 1st Oct
 * Description: implement getter and setters
 *********************************************************************************/

public class Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
