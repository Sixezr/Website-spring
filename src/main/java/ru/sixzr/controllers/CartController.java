package ru.sixzr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import ru.sixzr.models.adapters.CartAdapter;
import ru.sixzr.services.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String index(ModelMap map, Authentication authentication) {
        CartAdapter cartAdapter = cartService.getUserCart(authentication);
        map.put("cart", cartAdapter);
        return "security/cart";
    }

    @PostMapping
    public String clearCart(
            @RequestParam String action,
            @RequestParam(required = false) String productID,
            Authentication authentication
    ) {
        switch (action) {
            case "clearAll":
                cartService.clearCart(authentication);
                return "redirect:" + UriComponentsBuilder.fromPath("/cart").build();
            case "add":
                cartService.addProduct(authentication, productID);
                return "redirect:" + UriComponentsBuilder.fromPath("/cart").build();
            case "remove":
                break;
        }
        return "security/cart";
    }
}
