package ru.sixzr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
import ru.sixzr.models.forms.CreatingProductForm;

import javax.validation.Valid;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping
    public String index(ModelMap map) {
        return "";
    }

    @GetMapping("/create")
    public String createIndex(ModelMap map) {
        map.put("creatingProductForm", new CreatingProductForm());
        return "security/create_product";
    }

    @PostMapping("/create")
    public String createHandler(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("creatingProductForm") @Valid CreatingProductForm creatingProductForm,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            return "redirect:" + UriComponentsBuilder.fromPath("/menu/create").build();
        }
        return "security/create_product";
    }
}
