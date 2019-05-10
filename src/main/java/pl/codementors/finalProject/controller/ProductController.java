package pl.codementors.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.services.ProductService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productService.findAll();
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
        public Product getProductById (@PathVariable Integer id) {
        return productService.getProductById(id);
        }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

}
