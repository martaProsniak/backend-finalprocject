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
    private String login;

    private double orderTotalPrice;

    @OneToOne(targetEntity = Cart.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cartList;

    public Order(@NotNull(message = "Login is mandatory") String login,
                 double orderTotalPrice) {
        this.login = login;
        this.orderTotalPrice = orderTotalPrice;
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

    public Cart getCartList() {
        return cartList;
    }

    public void setCartList(Cart cartList) {
        this.cartList = cartList;
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

    public Order addCartToOrder (Cart cart) {
        Order order = new Order();
        order.setCartList(cartList);
        return order;
    }
}
