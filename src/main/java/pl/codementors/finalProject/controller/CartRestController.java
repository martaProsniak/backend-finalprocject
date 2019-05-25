package pl.codementors.finalProject.controller;

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
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.services.CartServiceImpl;
import pl.codementors.finalProject.services.LocalUserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/cart")
public class CartRestController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private LocalUserService localUserService;

    @GetMapping(value = "/list")
    public List<Cart> getCarts() {
        return cartService.getCarts();
    }


    @DeleteMapping(value = "/delete/{cartId}")
    public void deleteCart(@PathVariable("cartId") Long cartId) {
        cartService.deleteCart(cartId);
    }

    @PutMapping(value = "/{cartId}/deleteProduct/{productId}")
    public Cart deleteFromCart(@PathVariable("cartId") Long cartId,
                               @PathVariable("productId") Long productId) {
        return cartService.deleFromCart(cartId, productId);
    }

    @PostMapping("/add/product/{productId}/{userId}")
    public Cart addToCart(@PathVariable ("userId")Long userId, @PathVariable ("productId") Long productId) {
        Cart cart;
        LocalUser buyer = localUserService.findOne(userId);
        if (buyer.getCart() == null) {
            cart = cartService.addCart();
        } else {
            cart = buyer.getCart();
        }
        Long cartId = cart.getId();
        cartService.addProductToCart(cartId, productId);
        cart.setBuyer(buyer);
        buyer.setCart(cart);
        localUserService.editUser(userId, buyer);
        return cart;
    }

}