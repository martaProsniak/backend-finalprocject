package pl.codementors.finalProject.models;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class LocalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private String surname;

    @Column(unique = true)
    @Email
    private String login;

    @Column
    private String password;

    @Column
    private Boolean accepted;

    @Column
    @Enumerated(value = EnumType.STRING)
    private LocalUserRole role;

    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty
    @JsonIgnoreProperties(value = "buyer")
    private Cart cart;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "seller")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "buyer")
    private List<Order> orders = new ArrayList<>();

    public LocalUser(){}

    public LocalUser(Long id,
                     String name,
                     String surname,
                     String login,
                     String password,
                     Boolean accepted,
                     LocalUserRole role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.accepted = accepted;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public LocalUserRole getRole() {
        return role;
    }

    public void setRole(LocalUserRole role) {
        this.role = role;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}