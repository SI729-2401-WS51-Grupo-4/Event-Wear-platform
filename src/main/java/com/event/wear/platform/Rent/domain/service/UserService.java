package com.event.wear.platform.Rent.domain.service;

import com.event.wear.platform.Rent.domain.model.entities.User;
import com.event.wear.platform.Rent.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct; // Updated import statement

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
    return userRepository.findAll();
}

    /*
@PostConstruct
public void createUsers() {
    User user1 = new User();
    user1.setUsername("user1");
    user1.setEmail("user1@example.com");

    User user2 = new User();
    user2.setUsername("user2");
    user2.setEmail("user2@example.com");

    userRepository.save(user1);
    userRepository.save(user2);
}
*/
}