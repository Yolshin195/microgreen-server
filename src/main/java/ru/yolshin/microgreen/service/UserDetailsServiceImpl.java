package ru.yolshin.microgreen.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.yolshin.microgreen.repository.UserRepository;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info(s);
        var user = userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(s));
        logger.info(user.toString());
        return new User(user.getUsername(), user.getPassword(), Arrays.stream(user.getRoles()).map(SimpleGrantedAuthority::new).collect(Collectors.toSet()));
    }
}
