package com.example.phase2.models.user;

public class Admin extends User {
   public Admin(String name,String password,int id){
        this.name=name;
        this.password=password;
        this.role="admin";
        this.id=id;
    }

}
