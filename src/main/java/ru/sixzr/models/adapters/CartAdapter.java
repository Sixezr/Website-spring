package ru.sixzr.models.adapters;

import ru.sixzr.models.Cart;
import ru.sixzr.models.Product;
import ru.sixzr.models.collections.CustomProductCollections;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class CartAdapter {
    private static final DecimalFormat FORMAT = new DecimalFormat("#.##");;

    private List<Cart> cart;
    private CustomProductCollections products;
    private Double price;
    private Double priceDollars;
    private Double course;

    public CartAdapter(List<Cart> cart) {
        this.cart = cart;
        products = new CustomProductCollections();
        price = 0.0;

        for (Cart element : cart) {
            for (int i = 0; i < element.getCount(); i++) {
                products.add(element.getProduct());
                price += element.getProduct().getPrice();
            }
        }
    }

    public CartAdapter() {
    }

    public void addProduct(Product product) {
        products.add(product);
        price += product.getPrice();
    }

    public void removeProductByID(Long id) {
        for (Cart element : cart) {
            if (element.getProduct().getId() == id) {
                products.removeProductById(id);
                price -= element.getProduct().getPrice();
                return;
            }
        }
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            price -= product.getPrice();
        }
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public CustomProductCollections getProducts() {
        return products;
    }

    public void setProducts(CustomProductCollections products) {
        this.products = products;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPriceDollars() {
        return FORMAT.format(price / course);
    }

    public void setPriceDollars(Double priceDollars) {
        this.priceDollars = priceDollars;
    }

    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartAdapter that = (CartAdapter) o;
        return Objects.equals(cart, that.cart) && Objects.equals(products, that.products) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart, products, price);
    }

    @Override
    public String toString() {
        return "CartAdapter{" +
                "cart=" + cart +
                ", products=" + products +
                ", price=" + price +
                '}';
    }
}
