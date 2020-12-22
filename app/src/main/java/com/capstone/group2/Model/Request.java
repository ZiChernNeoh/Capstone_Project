package com.capstone.group2.Model;

import java.util.List;

public class Request {
    private String name;
    private String total;
    private List<Order> foods; //list of foods
    private String status;
    private String email;
    private String phone;

    public Request() {
    }

    public Request(String total, List<Order> foods) {
        this.total = total;
        this.foods = foods;
        this.status = "0"; //Placed & Default = 0, In Process = 1, Success = 2
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
}
