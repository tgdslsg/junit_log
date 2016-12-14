package com.lsg.Entity;

/**
 * Created by tgdsl on 2016/12/13.
 */
public class User {
    private Integer id;
    private String uaername;
    private Integer age;
    private String address;
    private  String tel;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uaername='" + uaername + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUaername() {
        return uaername;
    }

    public void setUaername(String uaername) {
        this.uaername = uaername;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
