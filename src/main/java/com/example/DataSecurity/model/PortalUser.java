package com.example.DataSecurity.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "portal_user")
public class PortalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PU_ID")
    private int id;
    @Column(name = "PU_LOGIN")
    private String login;
    @Column(name = "PU_FIRSTNAME")
    private String firstName;
    @Column(name = "PU_LASTNAME")
    private String lastName;
    @Column(name = "PU_EMAIL", unique = true)
    private String email;
    @Column(name = "PU_PASSWORD")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "portal_user_roles", joinColumns = @JoinColumn(name = "PUR_PU_ID"), inverseJoinColumns = @JoinColumn(name = "PUR_RO_ID"))
    private Set<Role> roles;

    public PortalUser() {
    }

    public PortalUser(int id, String login, String firstName, String lastName, String email, String password, Set<Role> roles) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
