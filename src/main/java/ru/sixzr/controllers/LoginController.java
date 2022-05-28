package ru.sixzr.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sixzr.models.forms.LoginForm;

@Controller
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @GetMapping
    @PreAuthorize("isAnonymous()")
    public String login(@RequestParam(required = false) String error, @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap map) {
        map.put("error", error);
        return "security/login";
    }
}
