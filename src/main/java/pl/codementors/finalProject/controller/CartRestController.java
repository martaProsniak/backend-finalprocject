package pl.codementors.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.repo.CartRepository;
import pl.codementors.finalProject.repo.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartRestController {

    //TODO move to service
    private Cart cart = new Cart();
    private Product product = new Product();

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/cart/list")
    public List<Cart> getCart(){
        return cartRepository.findAll();
    }

    @PostMapping(value = "/cart/add")
    public Cart create(){
        Cart newCart = new Cart();
        cartRepository.save(newCart);
        return newCart;
    }

    @PutMapping(value = "/cart/{cartId}/add/product/{productId}")
    public Cart cartAddProduct(@PathVariable("cartId") Long cartId,
                               @PathVariable("productId") Long productId){
        List<Product> products = new ArrayList<>();
        cart = cartRepository.findOne(cartId);
        product = productRepository.findOne(productId);
        products.add(product);
        cart.setProducts(products);
        product.setCart(cart);
        cartRepository.save(cart);
        return cart;
    }
}