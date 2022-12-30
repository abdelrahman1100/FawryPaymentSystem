package com.example.phase2.User.models;

import java.util.LinkedList;


import com.example.phase2.Discount.Subject;
import com.example.phase2.Providers.ServiceProvider;
import com.example.phase2.User.Userdata.Userdata;

public class Admin extends User{
    public static int cnt=1;
   public Admin(String name,String password,String role){
        this.name=name;
        this.password=password;
        this.role=role;
        this.id=cnt;
        cnt++;
    }

}
