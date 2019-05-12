package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.Cart;
import pl.codementors.finalProject.models.Product;

import java.util.List;

public interface CartService {
    List<Product> addProduct(Product product);
}
