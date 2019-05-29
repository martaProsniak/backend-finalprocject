package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.Exceptions.ExceptionResponse;
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
    public Product addProduct(Product product, Long id) {
        LocalUser seller = localUserRepository.findOne(id);
        product.setSeller(seller);
        return productRepository.save(product);
    }

    @Override
    public Product editProduct(Long id, Product product) {
        Product productUpdated = productRepository.findOne(id);

        productUpdated.setName(product.getName());
        productUpdated.setDescription(product.getDescription());
        productUpdated.setPrice(product.getPrice());
        productUpdated.setAvailable(product.getAvailable());
        productUpdated.setUrl(product.getUrl());
        productUpdated.setSeller(product.getSeller());

        return productRepository.save(productUpdated);
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
        product.setSeller(localUser);
        localUser.setProducts(products);
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> findAllForJsonView() {
      List<Product> productsForJson = productRepository.findAll();
        for (Product p : productsForJson) {
            p.setSeller(null);
        }
        return productsForJson;
    }
}
