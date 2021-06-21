package ru.yolshin.microgreen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.yolshin.microgreen.dto.RegisterUserDTO;
import ru.yolshin.microgreen.entity.User;
import ru.yolshin.microgreen.service.MicrogreenUserService;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class.getName());
    private MicrogreenUserService microgreenUserService;

    public UserController(MicrogreenUserService microgreenUserService) {
        this.microgreenUserService = microgreenUserService;
    }

    @GetMapping
    Iterable<User> findAll() {
        return microgreenUserService.findAll();
    }

    @GetMapping("find")
    Optional<User> findByPhone(@RequestParam String phone) {
        return this.microgreenUserService.getUserByPhone(phone);
    }

    @GetMapping("login")
    Optional<User> getUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof org.springframework.security.core.userdetails.User user) {
            String name = user.getUsername();
            return microgreenUserService.getUserByPhone(name);
        }

        return Optional.empty();
    }

    @PostMapping("register")
    User register(@RequestBody RegisterUserDTO userDTO) throws Exception {
        return microgreenUserService.register(userDTO);
    }
}
