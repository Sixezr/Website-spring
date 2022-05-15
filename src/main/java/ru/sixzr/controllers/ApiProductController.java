package ru.sixzr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sixzr.models.Product;
import ru.sixzr.services.ApiProductsService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*")
public class ApiProductController {

    @Autowired
    private ApiProductsService apiProductsService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> getProductsIndex() {
        return ResponseEntity.ok(apiProductsService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable String id) {
        try {
            Long identifier = Long.parseLong(id);
            Optional<Product> wrappedProduct = apiProductsService.getProductByID(identifier);
            return wrappedProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
