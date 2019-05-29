package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.Product;

import java.util.List;


public interface ProductService {

    List<Product> findAll();

    List<Product> findAllForJsonView();

    Product findOne(Long id);

    Product addProduct(Product product, Long id);

    Product editProduct(Long id, Product product);

    void deleteProduct(Long id);

    Product addProductToUser(Long productId, Long userId);

}
