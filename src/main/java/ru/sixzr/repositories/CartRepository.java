package ru.sixzr.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.sixzr.models.Cart;

import javax.transaction.Transactional;
import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {
    List<Cart> findAllByUserID(Long userID);

    @Transactional
    void deleteAllByUserID(Long userID);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "insert into cart(user_id, product_id) values (:userID, :productID) on conflict (user_id, product_id) do update set count = cart.count + 1")
    void addProductByID(@Param("userID") Long userID,
                        @Param("productID")Long productID);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "update cart set count = cart.count - 1 where user_id = :userID and product_id = :productID")
    void removeProductByID(@Param("userID") Long userID,
                           @Param("productID")Long productID);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "delete from cart where user_id = :userID and product_id = :productID")
    void removeByProductID(@Param("userID") Long userID,
                           @Param("productID")Long productID);
}
