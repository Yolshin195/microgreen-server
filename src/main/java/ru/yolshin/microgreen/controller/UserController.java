package ru.yolshin.microgreen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yolshin.microgreen.dto.RegisterUserDTO;
import ru.yolshin.microgreen.entity.User;
import ru.yolshin.microgreen.repository.UserRepository;

import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("register")
    User register(@RequestBody RegisterUserDTO userDTO) throws Exception {
        logger.info(userDTO.toString());
        if (!userDTO.getPassword().equals(userDTO.getRepeatPassword())) {
            throw new Exception("Пароль не совпадает");
        }
        if (userRepository.existsByPhone(userDTO.getPhone())) {
            throw new Exception("Пользователь уже существует");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setPassword("{noop}" + userDTO.getPassword());
        user.setDate(new Date());
        user.setRoles(new String[]{"USER"});

        logger.info(user.toString());

        return userRepository.save(user);
    }
}
