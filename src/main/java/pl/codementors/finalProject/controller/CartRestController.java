package pl.codementors.finalProject.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.services.CartServiceImpl;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/cart/")
public class CartRestController {

    @Autowired
    private CartServiceImpl cartService;

    private Principal principal;

    @GetMapping(value = "list")
    public List<Cart> getCarts() throws Exception {
        return cartService.getCarts();
    }

    @PostMapping(value = "add")
    public Cart createCart(){
        return cartService.addCart();
    }

    @DeleteMapping(value = "delete/{cartId}")
    public void deleteCart(@PathVariable("cartId") Long cartId) throws Exception {
        cartService.deleteCart(cartId);
    }

    @PutMapping(value = "{cartId}/deleteProduct/{productId}")
    public Cart deleteFromCart(@PathVariable("cartId") Long cartId,
                               @PathVariable("productId") Long productId) throws Exception {
        return cartService.deleteFromCart(cartId, productId);
    }

    @PutMapping(value = "{cartId}/addProduct/{productId}")
    public Cart addProduct(@PathVariable("cartId") Long cartId,
                           @PathVariable("productId") Long productId) throws Exception {
        return cartService.addProductToCart(cartId, productId);
    }
}