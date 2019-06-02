package cn.cs.pojo;

import java.io.Serializable;

public class Address implements Serializable {
    private Integer id;
    private Integer userId;
    private String username;
    private String province;
    private String city;
    private String address;
    private String telephone;

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getUsername() {
        return username;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
