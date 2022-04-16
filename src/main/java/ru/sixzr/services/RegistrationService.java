package ru.sixzr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sixzr.exceptions.NotUniqueEmailException;
import ru.sixzr.exceptions.NotUniquePhoneException;
import ru.sixzr.models.User;
import ru.sixzr.repositories.RoleRepository;
import ru.sixzr.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new NotUniqueEmailException("Duplicate key - email field.");
        }
        if (userRepository.findByPhone(user.getPhone()).isPresent()) {
            throw new NotUniquePhoneException("Duplicate key - phone field.");
        }
        String password = user.getPassword();
        user.addRole(roleRepository.findByRole("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        try {
            request.login(user.getEmail(), password);
        } catch (ServletException e) {
            System.out.println(e);
        }
    }
}
