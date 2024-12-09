package com.example.user_product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DatabaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create User 1
        User user1 = new User("Alice Johnson", "alice@example.com");
        Product product1 = new Product("MacBook Pro", 1500.00);
        Product product2 = new Product("iPhone 13", 1200.00);
        user1.addProduct(product1);
        user1.addProduct(product2);

        // Create User 2
        User user2 = new User("Bob Smith", "bob@example.com");
        Product product3 = new Product("Samsung Galaxy S21", 800.00);
        Product product4 = new Product("Dell XPS 13", 1000.00);
        user2.addProduct(product3);
        user2.addProduct(product4);

        // Save Users (Products will also be saved due to cascade)
        userRepository.save(user1);
        userRepository.save(user2);

        System.out.println("Database initialized with sample data!");
    }
}

