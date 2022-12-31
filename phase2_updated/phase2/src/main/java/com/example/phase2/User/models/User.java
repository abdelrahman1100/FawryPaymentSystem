package com.example.phase2.User.models;

public abstract class User {
    protected int id;
    protected String name;
    protected String password;
    protected String role;

    public String getName(){
        return name;
    }
    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public abstract void setservice(String s);
}
