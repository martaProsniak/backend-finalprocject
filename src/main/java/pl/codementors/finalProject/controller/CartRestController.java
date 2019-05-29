package pl.codementors.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.Cart;
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
    public Cart addToCart(@PathVariable ("userId")Long userId,
                          @PathVariable ("productId") Long productId) {
        return  cartService.addProductToCart(userId, productId);
    }

    @GetMapping("/{id}")
    public Cart getCartById (@PathVariable Long id) {
        return cartService.findOne(id);
    }
}