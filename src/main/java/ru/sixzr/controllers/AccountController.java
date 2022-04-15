package ru.sixzr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sixzr.services.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public String index(ModelMap map, Authentication authentication) {
        map.put("user", accountService.getCurrentUser(authentication));
        return "security/account";
    }
}
