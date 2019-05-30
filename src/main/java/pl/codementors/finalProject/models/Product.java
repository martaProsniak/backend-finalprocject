package pl.codementors.finalProject.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "product_id")
    private Long id;

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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cartid")
    @JsonIgnoreProperties(value = {"products", "cartValue", "buyer"})
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "seller", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"products", "password", "cart", "orders"})
    private LocalUser seller;

    public Product() {
    }

    public Product(String name,
                   String description,
                   double price,
                   boolean available,
                   String url) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long productid) {
        this.id = productid;
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

    public boolean getAvailable() {
        return available;
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

    public LocalUser getSeller() {
        return seller;
    }

    public void setSeller(LocalUser seller) {
        this.seller = seller;
    }
}