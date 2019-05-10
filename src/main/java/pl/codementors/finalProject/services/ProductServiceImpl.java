package pl.codementors.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codementors.finalProject.models.Product;
import pl.codementors.finalProject.repo.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }


    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }


    @Override
    public Product saveProduct(Product product) {
       return  productRepository.save(product);
    }




}
