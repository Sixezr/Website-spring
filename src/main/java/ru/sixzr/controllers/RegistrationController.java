package ru.sixzr.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sixzr.models.User;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    @PreAuthorize("isAnonymous()")
    public String index(ModelMap map) {
        map.put("user", new User());
        return "security/register";
    }
}
