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
import ru.sixzr.exceptions.CreatingProductException;
import ru.sixzr.models.forms.CreatingProductForm;
import ru.sixzr.services.MenuService;

import javax.validation.Valid;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public String index(ModelMap map) {
        return "";
    }

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createIndex(ModelMap map) {
        map.put("creatingProductForm", new CreatingProductForm());
        return "security/create_product";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createHandler(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("creatingProductForm") @Valid CreatingProductForm creatingProductForm,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            try {
                menuService.createProduct(creatingProductForm);
                redirectAttributes.addFlashAttribute("message", "ok");
                return "redirect:" + UriComponentsBuilder.fromPath("/menu/create").build();
            } catch (CreatingProductException e) {
                result.rejectValue("error", "menu.error", "Повторите попытку, неизвестная ошибка");
            }
        }
        return "security/create_product";
    }
}
