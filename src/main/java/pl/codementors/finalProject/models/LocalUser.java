package pl.codementors.finalProject.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value={ "cart", "products" }, allowGetters= true)
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

    @OneToOne
    @JsonProperty
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToMany(mappedBy = "localUser")
    @ElementCollection
    @JsonProperty
    private List<Product> products;

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
}