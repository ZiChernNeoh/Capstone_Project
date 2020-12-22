package com.capstone.group2;

public class Member {
    private String fullname;
    private String email;
    private String password;
    private String dob;
    private boolean termofservice;

    public Member(String fullname, String email, String password, String dob, boolean termofservice, boolean vendoraccount){
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.termofservice = termofservice;
    }

    public Member(){

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isTermofservice() {
        return termofservice;
    }

    public void setTermofservice(boolean termofservice) {
        this.termofservice = termofservice;
    }
}
