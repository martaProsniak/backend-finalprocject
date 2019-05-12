package pl.codementors.finalProject.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

@Entity
@Table( name = "user")
public class LocalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    @Email
    private String login;

    @Column
    private Boolean accepted;

    @Column
    @Enumerated(value = EnumType.STRING)
    private LocalUserRole role;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public LocalUser(){}

    public LocalUser(Long id, String name, String surname, String login, Boolean accepted, LocalUserRole role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
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
}
