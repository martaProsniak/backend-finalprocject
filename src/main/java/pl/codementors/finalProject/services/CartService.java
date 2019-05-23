package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCarts() throws Exception;
    Cart addCart();
    void deleteCart(Long cartId) throws Exception;
    Cart addProductToCart(Long cartId, Long productId) throws Exception;
    Cart deleteFromCart(Long cartId, Long productId) throws Exception;
}
