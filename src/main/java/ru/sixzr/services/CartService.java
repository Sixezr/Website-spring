package ru.sixzr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.sixzr.exceptions.NotIDException;
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

    public CartAdapter getUserCart(Authentication authentication) {
        Optional<User> wrappedUser = userRepository.findByEmail(authentication.getName());
        if (!wrappedUser.isPresent()) {
            return new CartAdapter();
        }
        List<Cart> cart = cartRepository.findAllByUserID(wrappedUser.get().getId());
        return new CartAdapter(cart);
    }

    public void clearCart(Authentication authentication) {
        Optional<User> wrappedUser = userRepository.findByEmail(authentication.getName());
        if (!wrappedUser.isPresent()) { return; }
        cartRepository.deleteAllByUserID(wrappedUser.get().getId());
    }

    public void addProduct(Authentication authentication, String id) {
        Optional<User> wrappedUser = userRepository.findByEmail(authentication.getName());
        if (!wrappedUser.isPresent()) { return; }
        try {
            Long identifier = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new NotIDException("Not int", e);
        }
    }
}
