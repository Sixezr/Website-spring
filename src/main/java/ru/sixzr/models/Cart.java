package ru.sixzr.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.*;

@DynamicUpdate
@Entity
@Table(name = "cart", schema = "public")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userID;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(userID, cart.userID) && Objects.equals(product, cart.product) && Objects.equals(count, cart.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, product, count);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userID=" + userID +
                ", products=" + product +
                ", count=" + count +
                '}';
    }
}
