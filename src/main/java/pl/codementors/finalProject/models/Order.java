package pl.codementors.finalProject.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;

    @Basic(optional = false)
    @Column(name = "login")
    private String login;

    @Column(name = "total")
    private double value;

    @Column(name="address")
    private String address;

    @OneToOne(targetEntity = Cart.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"cartValue", "buyer", "order"})
    private Cart cart;

    public Order(@NotNull(message = "Login is mandatory") String login,
                 double value,
                 String address) {
        this.login = login;
        this.value = value;
        this.address = address;
    }

    public Order() {
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderid, order.orderid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid);
    }

}
