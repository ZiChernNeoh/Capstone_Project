package com.capstone.group2.Model;

public class Vorder {
    private String ProductID;
    private String ProductName;
    private String Price;
    private String Quantity;

    public Vorder() {
    }

    public Vorder(String productid, String productname, String price, String quantity) {
        ProductID = productid;
        ProductName = productname;
        Price = price;
        Quantity = quantity;
    }

    public String getProductid() {
        return ProductID;
    }

    public void setProductid(String productid) {
        ProductID = productid;
    }

    public String getProductname() {
        return ProductName;
    }

    public void setProductname(String productname) {
        ProductName = productname;
    }

    public String getPrice() {
        return Price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
