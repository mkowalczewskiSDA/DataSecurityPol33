package com.example.DataSecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RO_ID")
    private int id;
    @Column(name = "RO_NAME")
    private String name;

}
