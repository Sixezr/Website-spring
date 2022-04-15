package ru.sixzr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sixzr.exceptions.NotUniquePhoneException;
import ru.sixzr.models.User;
import ru.sixzr.models.forms.AccountEditForm;
import ru.sixzr.repositories.UserRepository;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getCurrentUser(Authentication authentication) {
        String userName = authentication.getName();
        return userRepository.findByEmail(userName).orElse(new User());
    }

    public AccountEditForm getForm(Authentication authentication) {
        String userName = authentication.getName();
        User user = userRepository.findByEmail(userName).orElse(new User());

        AccountEditForm accountEditForm = new AccountEditForm();
        accountEditForm.setFirstName(user.getFirstName());
        accountEditForm.setSecondName(user.getSecondName());
        accountEditForm.setPhone(user.getPhone());

        return accountEditForm;
    }

    public void saveUser(Authentication authentication, AccountEditForm accountEditForm) {
        String userName = authentication.getName();
        User user = userRepository.findByEmail(userName).orElse(new User());

        if (!user.getPhone().equals(accountEditForm.getPhone()) && userRepository.existsByPhone(accountEditForm.getPhone())) {
            throw new NotUniquePhoneException("Duplicate key - phone field.");
        }

        user.setFirstName(accountEditForm.getFirstName());
        user.setSecondName(accountEditForm.getSecondName());
        user.setPhone(accountEditForm.getPhone());

        if (accountEditForm.getPassword() != null && !accountEditForm.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(accountEditForm.getPassword()));
        }
        userRepository.save(user);
    }
}
