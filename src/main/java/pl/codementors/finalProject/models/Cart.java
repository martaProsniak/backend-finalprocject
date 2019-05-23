package pl.codementors.finalProject.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cart")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cart {

    @Id
    @GeneratedValue
    private Long cartid;

    @OneToMany(mappedBy = "cart")
    private List<Product> products;

    @OneToOne(mappedBy = "cart")
    private LocalUser localUser;

    public Cart(){}

    public Cart(Long id) {
        this.cartid = id;
    }

    public Long getId() {
        return cartid;
    }

    public void setId(Long id) {
        this.cartid = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalUser getLocalUser() {
        return localUser;
    }

    public void setLocalUser(LocalUser localUser) {
        this.localUser = localUser;
    }

    @Override
    public String toString() {
        return "Cart{" + "cartid=" + cartid + ", products=" + products + ", localUser=" + localUser + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartid != null ? !cartid.equals(cart.cartid) : cart.cartid != null) return false;
        if (products != null ? !products.equals(cart.products) : cart.products != null) return false;
        return localUser != null ? localUser.equals(cart.localUser) : cart.localUser == null;
    }

    @Override
    public int hashCode() {
        int result = cartid != null ? cartid.hashCode() : 0;
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + (localUser != null ? localUser.hashCode() : 0);
        return result;
    }
}