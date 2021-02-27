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

    public Order() {
    }

    public Order(int id, double price, String title, PortalUser portalUser) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.portalUser = portalUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PortalUser getPortalUser() {
        return portalUser;
    }

    public void setPortalUser(PortalUser portalUser) {
        this.portalUser = portalUser;
    }
}
