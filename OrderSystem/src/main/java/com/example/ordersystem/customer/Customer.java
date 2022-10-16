package com.example.ordersystem.customer;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    private Integer id;

    @Column(nullable=false)
    private String customer;

    private Integer registrationCode;

    private String email;

    private Integer telephone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(Integer registrationCode) {
        this.registrationCode = registrationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }
}
