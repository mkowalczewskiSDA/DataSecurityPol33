package com.example.DataSecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
    private int id;
    @Column(name = "ORD_PRICE")
    private double price;
    @Column(name = "ORD_TITLE")
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORD_PU_ID", referencedColumnName = "PU_ID")
    private PortalUser portalUser;

}
