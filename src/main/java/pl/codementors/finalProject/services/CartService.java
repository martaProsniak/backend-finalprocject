package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCarts();
    Cart addCart();
    void deleteCart(Long cartId);
    Cart addProductToCart(Long cartId, Long productId);
    Cart deleFromCart(Long cartId, Long productId);
}
