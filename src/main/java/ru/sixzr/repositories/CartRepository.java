package ru.sixzr.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.sixzr.models.Cart;

import javax.transaction.Transactional;
import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {
    List<Cart> findAllByUserID(Long userID);

    @Transactional
    void deleteAllByUserID(Long userID);
}
