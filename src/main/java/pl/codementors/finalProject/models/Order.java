package pl.codementors.finalProject.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
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
    private double orderTotalPrice;

    @Column(name="address")
    private String address;

    @OneToOne(targetEntity = Cart.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;

    public Order(@NotNull(message = "Login is mandatory") String login,
                 double orderTotalPrice,
                 String address) {
        this.login = login;
        this.orderTotalPrice = orderTotalPrice;
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

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
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
