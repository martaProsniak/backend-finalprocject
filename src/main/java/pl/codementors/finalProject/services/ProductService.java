package pl.codementors.finalProject.services;

import pl.codementors.finalProject.models.Product;


public interface ProductService {

    Iterable<Product> findAll();
    Product findOne(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);

}
