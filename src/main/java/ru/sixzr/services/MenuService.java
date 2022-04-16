package ru.sixzr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sixzr.exceptions.CreatingProductException;
import ru.sixzr.managers.FileManager;
import ru.sixzr.models.Product;
import ru.sixzr.models.forms.CreatingProductForm;
import ru.sixzr.repositories.ProductRepository;

import java.io.IOException;
import java.io.InputStream;

@Service
public class MenuService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FileManager fileManager;

    public void createProduct(CreatingProductForm creatingProductForm) {
        try {
            InputStream is = creatingProductForm.getFile().getInputStream();
            String fileName = fileManager.uploadImage(is);

            Product product = new Product();
            product.setName(creatingProductForm.getName());
            product.setPrice(Double.valueOf(creatingProductForm.getPrice()));
            product.setImage(fileName);

            productRepository.save(product);
        } catch (IOException e) {
            throw new CreatingProductException("Unknown error", e);
        }
    }

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }
}
