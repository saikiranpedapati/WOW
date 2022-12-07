package com.example.wow1;

public class userLogin {
    String user;
    String email;
    String phone;
    String pass;
    //String Uri;
    public userLogin(){

    }


    public userLogin(String user, String email, String phone, String pass) {
        this.user = user;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
      // this.Uri=Uri;


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
    /*public String getUri() {
        return Uri;
    }*/

    public void setUser(String user) {this.user = user;}

    public void setEmail(String email) {this.email = email;}

    public void setPhone(String phone) {this.phone = phone;}

    public void setPass(String pass) {this.pass = pass;}
    /*public void setUri(String Uri) {this.Uri = Uri;}*/


}
