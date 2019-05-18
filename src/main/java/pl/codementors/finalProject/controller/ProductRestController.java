package pl.codementors.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.repo.LocalUserRepository;
import pl.codementors.finalProject.repo.ProductRepository;
import pl.codementors.finalProject.services.ProductService;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findOne(id);
    }

    @PostMapping("/products/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product userProduct) {
        return productService.addProduct(userProduct);
    }

    @PutMapping("/products/edit/{id}")
    public Product editProduct(@RequestBody Product product) {
        return productService.editProduct(product);
    }

    @PostMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/products/{productId}/addToUser/{userId}")
    public Product addProductToUser(@PathVariable("productId") Long productId,
                                    @PathVariable("userId") Long userId){
        return productService.addProductToUser(productId, userId);
    }


    /*
        @PostMapping("/product")
        public ResponseEntity<Product> createProduct(@RequestBody Product product) {

            Product newProduct = productService.addProduct(product);

            try {
                // Build a created response
                return ResponseEntity
                        .created(new URI("/product/" + newProduct.getId()))
                        .body(newProduct);
            } catch (URISyntaxException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
*/
}
