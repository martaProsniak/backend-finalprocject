package pl.codementors.finalProject.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.codementors.finalProject.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
