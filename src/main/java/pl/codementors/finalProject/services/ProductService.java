package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.Product;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> listAllProducts();
    Product getProductById(Integer Id);
    Product saveProduct(Product product);
    void deleteProduct(Integer Id);

}
