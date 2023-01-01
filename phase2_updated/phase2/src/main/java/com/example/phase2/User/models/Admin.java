package com.example.phase2.User.models;

import java.util.LinkedList;


import com.example.phase2.Discount.Subject;
import com.example.phase2.Providers.ServiceProvider;
import com.example.phase2.User.Userdata.Userdata;

public class Admin extends User{
   public Admin(String name,String password,int id){
        this.name=name;
        this.password=password;
        this.role="admin";
        this.id=id;
    }
    @Override
    public void setservice(String s) {
        // TODO Auto-generated method stub
    }

}
