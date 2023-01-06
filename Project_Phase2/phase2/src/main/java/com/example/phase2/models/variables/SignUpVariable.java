package com.example.phase2.models.variables;

public class SignUpVariable {
    String name,password;
    String creditCardId;
    String creditCardPassword;
    public SignUpVariable(String name,String password,String creditCardId,String creditCardPassword){
        this.name=name;
        this.password=password;
        this.creditCardId=creditCardId;
        this.creditCardPassword=creditCardPassword;
    }
    public String getCreditCardId() {
        return creditCardId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getCreditCardPassword() {
        return creditCardPassword;
    }
}
