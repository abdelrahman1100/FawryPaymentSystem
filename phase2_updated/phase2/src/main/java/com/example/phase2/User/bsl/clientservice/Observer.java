package com.example.phase2.User.bsl.clientservice;

import com.example.phase2.User.models.Client;

public interface Observer {
    void update(int id, Client client);
}
