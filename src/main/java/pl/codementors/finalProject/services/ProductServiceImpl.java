package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.repo.LocalUserRepository;
import pl.codementors.finalProject.repo.ProductRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private LocalUserRepository localUserRepository;

    @Override
    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product editProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Product addProductToUser(Long productId, Long userId){
        Product product = productRepository.findOne(productId);
        LocalUser localUser = localUserRepository.findOne(userId);
        List<Product> products = localUser.getProducts();
        products.add(product);
        product.setLocalUser(localUser);
        localUser.setProducts(products);
        productRepository.save(product);
        return product;
    }
}
