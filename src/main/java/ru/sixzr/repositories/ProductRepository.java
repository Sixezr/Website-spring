package ru.sixzr.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sixzr.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
