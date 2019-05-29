package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.repo.CartRepository;
import pl.codementors.finalProject.repo.LocalUserRepository;
import pl.codementors.finalProject.repo.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LocalUserRepository localUserRepository;

    @Override
    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addCart() {
        Cart cart = new Cart();
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public void deleteCart(Long cartId) {
        Cart cart = cartRepository.findOne(cartId);
        cartRepository.delete(cart);
    }

    @Override
    public Cart addProductToCart(Long userId, Long productId) {
        Cart cart;
        LocalUser buyer = localUserRepository.findOne(userId);
        if (buyer.getCart() == null) {
            cart = addCart();
        } else {
            cart = buyer.getCart();
        }
        Long cartId = cart.getId();
        Product product = productRepository.findOne(productId);

        List<Product> productsInCart;
        if (cart.getProducts()==null){
            productsInCart = new ArrayList<>();
            productsInCart.add(product);
            cart.setProducts(productsInCart);
        } else {
            productsInCart = cart.getProducts();
            productsInCart.add(product);
        }

        cart.setCartValue(calculate(cart.getProducts()));
        cart.setBuyer(buyer);
        buyer.setCart(cart);
        product.setCart(cart);
        product.setAvailable(false);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart deleFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findOne(cartId);
        Product product = productRepository.findOne(productId);
        cart.getProducts().remove(product);
        product.setCart(null);
        product.setAvailable(true);
        cart.setCartValue(calculate(cart.getProducts()));
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public boolean emptyCart(Long id) {

        if (cartRepository.findOne(id) != null) {
            cartRepository.delete(cartRepository.findOne(id).getId());
            return true;
        } else  {
            return false;
        }
    }

    @Override
    public Cart findOne(Long id) {
        return this.cartRepository.findOne(id);
    }

    @Override
    public Double calculate(List<Product> products) {
        Double sum = 0.0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }
}
