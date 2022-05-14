package ru.sixzr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
import ru.sixzr.exceptions.CreatingProductException;
import ru.sixzr.models.forms.ProductForm;
import ru.sixzr.services.MenuService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public String index(ModelMap map) {
        map.put("products", menuService.getProducts());
        return "dynamic/menu_index";
    }

    @PostMapping
    @ResponseBody
    public String saveHandler(Principal principal, HttpServletResponse httpServletResponse) {
        if (principal == null) {
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return "not ok";
        }
        return "ok";
    }

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createIndex(ModelMap map) {
        map.put("productForm", new ProductForm());
        return "security/create_product";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String createHandler(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("productForm") @Valid ProductForm productForm,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            try {
                menuService.createProduct(productForm);
                redirectAttributes.addFlashAttribute("message", "ok");
                return "redirect:" + UriComponentsBuilder.fromPath("/menu/create").build();
            } catch (CreatingProductException e) {
                result.rejectValue("error", "menu.error", "Повторите попытку, неизвестная ошибка");
            }
        }
        return "security/create_product";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String editIndex(@PathVariable String id, ModelMap map) {
        map.put("productForm", menuService.getProductFormById(id));
        return "security/change_product";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String editHandler(
            @RequestParam String action,
            RedirectAttributes redirectAttributes,
            @ModelAttribute("productForm") @Valid ProductForm productForm,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            boolean isDeleted = menuService.editProduct(productForm, action);
            if (isDeleted) {
                redirectAttributes.addFlashAttribute("message", "Товар удален");
                return "redirect:" + UriComponentsBuilder.fromPath("/menu").build();
            } else {
                redirectAttributes.addFlashAttribute("message", "Товар изменен");
                return "redirect:" + UriComponentsBuilder.fromPath("/menu/edit/{id}").build();
            }
        }
        return "security/change_product";
    }
}
