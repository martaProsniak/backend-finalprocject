package pl.codementors.finalProject.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "user")
public class LocalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    @NotEmpty
    private String name;

    @Column
    private String surname;

    @Column
    @Email
    @NotNull
    @NotEmpty
    private String login;

    @Column
    private Boolean accepted;

    @Column
    @NotNull
    @NotEmpty
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    public LocalUser(){}

    public LocalUser(Long id, String name, String surname, String login, Boolean accepted, UserRole role) {
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
