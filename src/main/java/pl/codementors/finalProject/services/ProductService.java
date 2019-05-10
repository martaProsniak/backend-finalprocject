package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.Product;


public interface ProductService {

    Iterable<Product> findAll();
    Product getProductById(Integer Id);
    Product saveProduct(Product product);
    void deleteProduct(Integer Id);

}
