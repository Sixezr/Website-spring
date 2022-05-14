package ru.sixzr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sixzr.models.Product;
import ru.sixzr.repositories.ProductRepository;

import java.util.Optional;

@Service
public class ApiProductsService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductByID(Long id) {
        return productRepository.findById(id);
    }
}
