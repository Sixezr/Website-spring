package ru.sixzr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sixzr.exceptions.CreatingProductException;
import ru.sixzr.exceptions.NotFoundProductException;
import ru.sixzr.managers.FileManager;
import ru.sixzr.models.Product;
import ru.sixzr.models.forms.ProductForm;
import ru.sixzr.repositories.ProductRepository;

import java.io.IOException;
import java.io.InputStream;

@Service
public class MenuService {
    private static final String DELETE_ACTION = "delete";
    private static final String CHANGE_ACTION = "change";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FileManager fileManager;

    public void createProduct(ProductForm productForm) {
        try {
            InputStream is = productForm.getFile().getInputStream();
            String fileName = fileManager.uploadImage(is);

            Product product = new Product();
            product.setName(productForm.getName());
            product.setPrice(Double.valueOf(productForm.getPrice()));
            product.setImage(fileName);

            productRepository.save(product);
        } catch (IOException e) {
            throw new CreatingProductException("Unknown error", e);
        }
    }

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public ProductForm getProductFormById(String id) {
        long identifier = Long.parseLong(id);
        Product product = productRepository.findById(identifier)
                .orElseThrow(() -> new NotFoundProductException(id));

        ProductForm form = new ProductForm();
        form.setId(product.getId());
        form.setName(product.getName());
        form.setPrice(String.valueOf(product.getPrice()));
        return form;
    }

    public boolean editProduct(ProductForm productForm, String action) {
        if (action.equals(DELETE_ACTION)) {
            deleteProduct(productForm);
            return true;
        } else if (action.equals(CHANGE_ACTION)) {
            changeProduct(productForm);
        }
        return false;
    }

    private void deleteProduct(ProductForm productForm) {
        Product product = productRepository.findById(productForm.getId()).orElse(new Product());
        fileManager.deleteImage(product.getImage());
        productRepository.delete(product);
    }

    private void changeProduct(ProductForm productForm) {
        Product product = productRepository.findById(productForm.getId()).orElse(new Product());

        product.setName(productForm.getName());
        product.setPrice(Double.parseDouble(productForm.getPrice()));

        if (productForm.getFile().getSize() != 0) {
            try {
                fileManager.uploadNewImage(productForm.getFile().getInputStream(), product.getImage());
            } catch (IOException e) {
                throw new CreatingProductException("Unknown error", e);
            }
        }

        productRepository.save(product);
    }
}
