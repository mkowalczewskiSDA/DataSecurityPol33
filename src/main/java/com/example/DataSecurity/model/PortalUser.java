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

}
