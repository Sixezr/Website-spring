package ru.sixzr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.sixzr.exceptions.NotIDException;
import ru.sixzr.managers.NetworkManager;
import ru.sixzr.models.Cart;
import ru.sixzr.models.User;
import ru.sixzr.models.adapters.CartAdapter;
import ru.sixzr.repositories.CartRepository;
import ru.sixzr.repositories.ProductRepository;
import ru.sixzr.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NetworkManager networkManager;

    public CartAdapter getUserCart(Authentication authentication) {
        Optional<User> wrappedUser = userRepository.findByEmail(authentication.getName());
        if (!wrappedUser.isPresent()) {
            return new CartAdapter();
        }
        List<Cart> cart = cartRepository.findAllByUserID(wrappedUser.get().getId());
        CartAdapter cartAdapter = new CartAdapter(cart);
        cartAdapter.setCourse(networkManager.getDollarCourse());
        return cartAdapter;
    }

    public void clearCart(Authentication authentication) {
        Optional<User> wrappedUser = userRepository.findByEmail(authentication.getName());
        if (!wrappedUser.isPresent()) {
            return;
        }
        cartRepository.deleteAllByUserID(wrappedUser.get().getId());
    }

    public void addProduct(Authentication authentication, String id) {
        Optional<User> wrappedUser = userRepository.findByEmail(authentication.getName());
        if (!wrappedUser.isPresent()) {
            return;
        }
        try {
            Long identifier = Long.parseLong(id);
            cartRepository.addProductByID(wrappedUser.get().getId(), identifier);
        } catch (NumberFormatException e) {
            throw new NotIDException("Not int", e);
        }
    }

    public void deleteProduct(Authentication authentication, String id) {
        Optional<User> wrappedUser = userRepository.findByEmail(authentication.getName());
        if (!wrappedUser.isPresent()) { return; }
        long identifier = -1L;
        try {
            identifier = Long.parseLong(id);
            cartRepository.removeProductByID(wrappedUser.get().getId(), identifier);
        } catch (NumberFormatException e) {
            throw new NotIDException("Not int", e);
        } catch (Exception e) {
            cartRepository.removeByProductID(wrappedUser.get().getId(), identifier);
        }
    }
}
