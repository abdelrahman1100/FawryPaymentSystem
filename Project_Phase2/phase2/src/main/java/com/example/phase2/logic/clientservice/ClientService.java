package com.example.phase2.logic.clientservice;

import com.example.phase2.databases.RefundRequestData;
import com.example.phase2.databases.Userdata;
import com.example.phase2.models.user.Client;
import org.springframework.stereotype.Component;
@Component
public class ClientService implements Observer {
    public static int cntClient=1;
    RefundRequestData refundRequestData;
    Userdata userdata;
    public ClientService(RefundRequestData refundRequestData,Userdata userdata){
        this.refundRequestData=refundRequestData;
        this.userdata=userdata;
    }
    public void setRefundRequestData(RefundRequestData refundRequestData) {
        this.refundRequestData = refundRequestData;
    }
    public void registerClient(Client user){
        user.setId(cntClient);
        userdata.addUser(user);
        cntClient++;
    }
    public void setActive(Client client){
        userdata.active(client);
    }
    public boolean isExist(Client client){
        return userdata.isExist(client);
    }
    public boolean checkCardinality(Client client){
        return userdata.checkCardinality(client);
    }
    public String checkRefundStatus(int id){
        return refundRequestData.getRefundRequest(id).getStatus();
    }
    @Override
    public void update(int id, Client client) {
        if(checkRefundStatus(id).equals("accepted")){
            client.updateWallet(refundRequestData.getRefundRequest(id).getPaidAmount());
        }
    }
   public void addToWallet(int clientId,double amount){
        Client client=(Client) userdata.getUser(clientId,"client");
        client.updateWallet(amount);
    }
    public void updateWallet(int clientId,double paidAmount){
        Client client=(Client) userdata.getUser(clientId,"client");
        client.setWalletAmount(client.getWallet().getAmount()-paidAmount);
    }
    public void updateCreditCard(int clientId,double paidAmount){
        Client client=(Client) userdata.getUser(clientId,"client");
        client.setCreditCardAmount(client.getCreditCard().getAmount()-paidAmount);
    }
}
