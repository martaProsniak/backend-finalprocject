package pl.codementors.finalProject.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "products")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productid;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    private boolean available;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(referencedColumnName = "cartid")
    @JsonIgnore
    private Cart cart;

    public Product() {
    }

    public Product(String name, String description, double price, boolean available, String url) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    public Long getId() {
        return productid;
    }

    public void setId(Long productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
