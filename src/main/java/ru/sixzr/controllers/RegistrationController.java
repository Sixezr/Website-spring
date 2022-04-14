package ru.sixzr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
import ru.sixzr.exceptions.NotUniqueEmailException;
import ru.sixzr.exceptions.NotUniquePhoneException;
import ru.sixzr.models.User;
import ru.sixzr.services.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    @PreAuthorize("isAnonymous()")
    public String index(ModelMap map) {
        map.put("user", new User());
        return "security/register";
    }

    @PostMapping
    @PreAuthorize("isAnonymous()")
    public String registerHandler(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("user") @Valid User user,
            BindingResult result,
            ModelMap map
    ) {
        if (!result.hasErrors()) {
            try {
                registrationService.registerUser(user);
                return "redirect:" + UriComponentsBuilder.fromPath("/account").build();
            } catch (NotUniqueEmailException e) {
                result.rejectValue("email", "entry.duplicate", "Данный E-Mail уже используется");
            } catch (NotUniquePhoneException e) {
                result.rejectValue("phone", "entry.duplicate", "Данный номер телефона уже используется");
            }
        }
        return "security/register";
    }
}
