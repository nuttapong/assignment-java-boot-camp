package com.skooldio.bootcamp.week01.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    private int id;
    private String username;
    private String realName;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<ShippingAddress> shippingAddressList;

    public User(){}

    public User(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ShippingAddress> getShippingAddressList() {
        return shippingAddressList;
    }

    public void setShippingAddressList(List<ShippingAddress> shippingAddressList) {
        this.shippingAddressList = shippingAddressList;
    }
}
