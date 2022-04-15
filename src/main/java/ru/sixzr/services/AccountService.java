package ru.sixzr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.sixzr.models.User;
import ru.sixzr.repositories.UserRepository;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    public User getCurrentUser(Authentication authentication) {
        String userName = authentication.getName();
        return userRepository.findByEmail(userName).orElse(new User());
    }
}
