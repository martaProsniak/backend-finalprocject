package pl.codementors.finalProject.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
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

    private boolean paymentStatus;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @OneToMany(targetEntity = Cart.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Cart> cartList;

    public Order(@NotNull(message = "Login is mandatory") String login,
                 double orderTotalPrice, boolean paymentStatus,
                 List<Cart> cartList) {
        this.login = login;
        this.orderTotalPrice = orderTotalPrice;
        this.paymentStatus = paymentStatus;
        this.cartList = cartList;
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

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
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
}
