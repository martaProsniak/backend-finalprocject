package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.Order;
import pl.codementors.finalProject.models.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<Product> findAll();

    Product findOne(Long id);

    Product addProduct(Product product, Long id);

    Product editProduct(Product product);

    void deleteProduct(Long id);

    Product addProductToUser(Long productId, Long userId);

}
