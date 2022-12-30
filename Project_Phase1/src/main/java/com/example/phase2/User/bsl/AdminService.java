package com.example.phase2.User.bsl;

import com.example.phase2.User.Userdata.Userdata;
import com.example.phase2.User.models.Admin;
import com.example.phase2.User.models.Client;

public class AdminService {
    Userdata userdata;
    public AdminService(){
        userdata=new Userdata();
    }
    public void setActive(Admin admin){
        userdata.active(admin);
    }
    public boolean isExist(Admin admin){
        return userdata.isExist(admin);
    }
}
