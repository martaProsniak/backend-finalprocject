package pl.codementors.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.services.ProductService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/products")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findOne(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product userProduct) {
        return productService.addProduct(userProduct);
    }

    @PutMapping("/edit/{id}")
    public Product editProduct(@RequestBody Product product) {
        return productService.editProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/{productId}/addToUser/{userId}")
    public Product addProductToUser(@PathVariable("productId") Long productId,
                                    @PathVariable("userId") Long userId){
        return productService.addProductToUser(productId, userId);
    }
}
