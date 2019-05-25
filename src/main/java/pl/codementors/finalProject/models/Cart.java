package pl.codementors.finalProject.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
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

    @OneToOne
    @JsonIgnoreProperties(value = {"products", "password"})
    private LocalUser buyer;

    @OneToOne
    @JoinColumn(referencedColumnName = "orderid")
    @JsonIgnore
    private Order order;

    public Cart() {
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

    public LocalUser getBuyer() {
        return buyer;
    }

    public void setBuyer(LocalUser buyer) {
        this.buyer = buyer;
    }
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
