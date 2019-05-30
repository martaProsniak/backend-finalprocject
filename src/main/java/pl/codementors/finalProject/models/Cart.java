package pl.codementors.finalProject.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column
    private Double cartValue;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"seller", "cart"})
    private List<Product> products;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value = {"products", "password", "orders", "cart"})
    private LocalUser buyer;

    public Cart(){}

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

    public Double getCartValue() {
        return cartValue;
    }

    public void setCartValue(Double cartValue) {
        this.cartValue = cartValue;
    }
}