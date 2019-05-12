package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {

    private Cart cart;
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> addProduct(Product product) {
        products = cart.getProducts();
        products.add(product);
        cart.setProducts(products);
        return products;
    }
}
