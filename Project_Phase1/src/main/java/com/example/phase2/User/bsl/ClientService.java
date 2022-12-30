package com.example.phase2.User.bsl;

import com.example.phase2.User.Userdata.Userdata;
import com.example.phase2.User.models.Client;
import com.example.phase2.User.models.User;

public class ClientService {
    Userdata userdata;
    public ClientService(){
        userdata=new Userdata();
    }
    public void registerClient(Client user){
        userdata.addUser(user);
    }
    public void setActive(Client client){
        userdata.active(client);
    }
    public boolean isExist(Client client){
        return userdata.isExist(client);
    }
}
