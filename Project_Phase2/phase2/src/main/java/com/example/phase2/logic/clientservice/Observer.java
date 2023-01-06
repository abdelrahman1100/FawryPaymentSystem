package com.example.phase2.logic.clientservice;

import com.example.phase2.models.user.Client;

public interface Observer {
    void update(int id, Client client);
}
