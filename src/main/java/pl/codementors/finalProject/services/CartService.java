package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Product;

import java.util.List;

public interface CartService {
    List<Cart> getCarts();
    Cart addCart();
    void deleteCart(Long cartId);
    Cart addProductToCart(Long cartId, Long productId);
    Cart deleFromCart(Long cartId, Long productId);
    Cart findOne (Long id);
    Double calculate(List<Product> products);
    boolean emptyCart(Long id);
}
