package com.capstone.group2.Model;

public class User {
    private String fullname;
    private String email;

    public User(){

    }

    public User(String name, String Email){
        fullname = name;
        email = Email;
    }

    public String getFullname(){
        return fullname;
    }

    public void setFullname(String name){
        fullname = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String Email){
        email = Email;
    }

}
