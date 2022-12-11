package com.example.wow1;

public class productUpload2 {
    String description,pic;

    public productUpload2(){

    }

    public productUpload2(String description, String pic) {
        this.description = description;
          this.pic=pic;
        }

    public productUpload2(String description) {

    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUser() {
        return description;
    }



    public void setUser(String description) {this.description = description;}


}
