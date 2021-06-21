package ru.yolshin.microgreen.service;

import org.springframework.stereotype.Service;
import ru.yolshin.microgreen.dto.RegisterUserDTO;
import ru.yolshin.microgreen.entity.Role;
import ru.yolshin.microgreen.entity.User;
import ru.yolshin.microgreen.repository.RoleRepository;
import ru.yolshin.microgreen.repository.UserRepository;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class MicrogreenUserService {
    UserRepository userRepository;
    RoleRepository roleRepository;

    public MicrogreenUserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    public User register(RegisterUserDTO userDTO) throws Exception {
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
        user.setRoles(createUserRoleIsNotExist("USER"));

        return userRepository.save(user);
    }

    public User createUserIsNotExist(String username, String phone) {
        Optional<User> user = userRepository.findByPhone(phone);

        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setDate(new Date());
            newUser.setUsername(username);
            newUser.setPhone(phone);
            newUser.setRoles(createUserRoleIsNotExist("ANONYMOUS"));

            return userRepository.save(newUser);
        }

        return user.get();
    }

    public Set<Role> createUserRoleIsNotExist(String roleName) {
        Optional<Role> role = roleRepository.findByAuthority(roleName);

        if (role.isEmpty()) {
            return Set.of(roleRepository.save(new Role(roleName)));
        }

        return Set.of(role.get());
    }
}
