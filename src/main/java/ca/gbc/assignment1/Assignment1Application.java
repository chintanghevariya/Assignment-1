package ca.gbc.assignment1;

import ca.gbc.assignment1.models.User;
import ca.gbc.assignment1.services.interfaces.UserServiceInterface;
import ca.gbc.assignment1.services.maps.UserMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment1Application {

	public static void main(String[] args) {
		System.out.println("Working on port 4000!");

		SpringApplication.run(Assignment1Application.class, args);
	}

}
