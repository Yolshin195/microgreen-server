package ru.yolshin.microgreen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.yolshin.microgreen.entity.User;
import ru.yolshin.microgreen.repository.UserRepository;

public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    User findById(@RequestParam long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    @PostMapping
    User save(@RequestBody User user) {
        return this.userRepository.save(user);
    }
}
