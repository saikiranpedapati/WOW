package com.example.wow1;

public class userLogin {
    String user;
    String email;
    String phone;
    String pass;
    public userLogin(){

    }


    public userLogin(String user, String email, String phone, String pass) {
        this.user = user;
        this.email = email;
        this.phone = phone;
        this.pass = pass;


    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPass() {
        return pass;
    }

    public void setUser(String user) {this.user = user;}

    public void setEmail(String email) {this.email = email;}

    public void setPhone(String phone) {this.phone = phone;}

    public void setPass(String pass) {this.pass = pass;}


}
