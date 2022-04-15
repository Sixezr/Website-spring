package ru.sixzr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
import ru.sixzr.exceptions.NotUniquePhoneException;
import ru.sixzr.models.forms.AccountEditForm;
import ru.sixzr.services.AccountService;

import javax.validation.Valid;

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

    @GetMapping("/edit")
    @PreAuthorize("isAuthenticated()")
    public String editIndex(ModelMap map, Authentication authentication) {
        map.put("accountEditForm", accountService.getForm(authentication));
        return "security/account_edit";
    }

    @PostMapping("/edit")
    @PreAuthorize("isAuthenticated()")
    public String editAccount(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("accountEditForm") @Valid AccountEditForm accountEditForm,
            BindingResult result,
            ModelMap map,
            Authentication authentication
    ) {
        if (!result.hasErrors()) {
            try {
                accountService.saveUser(authentication, accountEditForm);
                redirectAttributes.addFlashAttribute("message", "Данные были изменены");
                return "redirect:" + UriComponentsBuilder.fromPath("/account").build();
            } catch (NotUniquePhoneException e) {
                result.rejectValue("phone", "entry.duplicate", "Данный номер телефона уже используется");
            }
        }
        return "security/account_edit";
    }
}
