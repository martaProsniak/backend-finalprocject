package pl.codementors.finalProject.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;

    @ManyToOne
    @JoinColumn(name = "buyer", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"products", "password", "cart"})
    private LocalUser buyer;

    @Column(name = "total")
    private double value;

    @Column(name="address")
    private String address;

    @ElementCollection
    @Column(name="items")
    @JsonIgnoreProperties(value = {"seller", "cart"})
    private List<Product> items;

    public Order(LocalUser buyer, double value, String address, List<Product> items) {
        this.buyer = buyer;
        this.value = value;
        this.address = address;
        this.items = items;
    }

    public Order() {
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public LocalUser getBuyer() {
        return buyer;
    }

    public void setBuyer(LocalUser buyer) {
        this.buyer = buyer;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.value, value) == 0 &&
                Objects.equals(orderid, order.orderid) &&
                Objects.equals(buyer, order.buyer) &&
                Objects.equals(address, order.address) &&
                Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid, buyer, value, address, items);
    }
}
