package pl.codementors.finalProject.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cart")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cart {

    @Id
    @GeneratedValue
    private Long cartid;

    @OneToMany(mappedBy = "cart")
    private List<Product> products;

    @OneToOne(mappedBy = "cart")
    private LocalUser localUser;

    private double price; //stores product copy price while ordering

    @OneToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
    private Product product;

    public Cart() {
    }

    public Cart(Product product) {
        this.product = product;
        System.out.println("Price" + product.getPrice());
        this.price = product.getPrice();
    }

    public Cart(Long id) {
        this.cartid = id;
    }

    public Long getId() {
        return cartid;
    }

    public void setId(Long id) {
        this.cartid = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalUser getLocalUser() {
        return localUser;
    }

    public void setLocalUser(LocalUser localUser) {
        this.localUser = localUser;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart addProduct(Product product) {
        Cart cart = new Cart();
        products.add(product);
        cart.setProducts(products);
        return cart;
    }

    public List<Product> removeProduct(Product product) {
        products.remove(product);
        return products;
    }
}
