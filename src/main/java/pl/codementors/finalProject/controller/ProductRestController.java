package pl.codementors.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.repo.ProductRepository;
import pl.codementors.finalProject.services.ProductService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }


        @PostMapping("/product")
        public ResponseEntity<Product> createProduct(@RequestBody Product product) {

            Product newProduct = productService.saveProduct(product);

            try {
                // Build a created response
                return ResponseEntity
                        .created(new URI("/product/" + newProduct.getId()))
                        .body(newProduct);
            } catch (URISyntaxException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @GetMapping("/products/{id}")
        public Product getProductById (@PathVariable Long id) {
        return productService.findOne(id);
        }

    @PostMapping("/products/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product userProduct) {
        return productService.saveProduct(userProduct);
    }

}
