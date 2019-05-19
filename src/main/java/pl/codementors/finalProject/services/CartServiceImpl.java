package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.repo.CartRepository;
import pl.codementors.finalProject.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Cart> getCarts() throws Exception {
        if(cartRepository.findAll().size() <= 0) {
            throw new Exception("Lista Cart jest pusta");
        }
        return cartRepository.findAll();
    }

    @Override
    public Cart addCart() {
        Cart cart = new Cart();
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public void deleteCart(Long cartId) throws Exception {
        Optional<Cart> cart = Optional.ofNullable(cartRepository.findOne(cartId));
        if(!cart.isPresent()){
            throw new Exception("Nie znaleziono tekiego Carta");
        }
        cartRepository.delete(cart.get());
    }

    @Override
    public Cart addProductToCart(Long cartId, Long productId) throws Exception {
        Optional<Cart> cartOptional = Optional.ofNullable(cartRepository.findOne(cartId));
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findOne(productId));

        if(!cartOptional.isPresent()){
            throw new Exception("Nie znaleziono Carta");
        }
        if(!productOptional.isPresent()){
            throw new Exception("Nie znaleziono takiego produktu");
        }

        Cart cart = cartOptional.get();
        Product product = productOptional.get();

        List<Product> products = cart.getProducts();
        products.add(product);
        cart.setProducts(products);
        product.setCart(cart);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart deleteFromCart(Long cartId, Long productId) throws Exception {
        Optional<Cart> cartOptional = Optional.ofNullable(cartRepository.findOne(cartId));
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findOne(productId));

        if(!cartOptional.isPresent()){
            throw new Exception("Nie znaleziono Carta");
        }
        if(!productOptional.isPresent()){
            throw new Exception("Nie znaleziono takiego produktu");
        }

        Cart cart = cartOptional.get();
        Product product = productOptional.get();

        if(!cart.getProducts().contains(product)){
            throw new Exception("Nie ma takiego produktu w Carcie");
        }

        List<Product> products = cart.getProducts();
        products.remove(product);
        cart.setProducts(products);
        product.setCart(null);
        cartRepository.save(cart);
        return cart;
    }
}