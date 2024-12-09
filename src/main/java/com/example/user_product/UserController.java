package com.example.user_product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Fetch all users along with their products.
     *
     * @return List of users with their products
     */
    @GetMapping
    public List<User> getAllUsersWithProducts() {
        return userRepository.findAll();
    }
}
