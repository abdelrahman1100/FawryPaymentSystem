package com.example.phase2.logic.refundservice;

import com.example.phase2.databases.RefundRequestData;
import com.example.phase2.databases.Userdata;
import com.example.phase2.logic.clientservice.ClientService;
import com.example.phase2.models.user.Client;
import com.example.phase2.models.refundrequest.RefundRequest;
import org.springframework.stereotype.Component;
@Component
public class RefundService implements Subject {
  private   RefundRequestData refundRequestData;
    Userdata userdata;
    ClientService clientService;
    public RefundService(ClientService clientService,RefundRequestData refundRequestData,Userdata userdata){
        this.refundRequestData=refundRequestData;
        this.clientService=clientService;
        this.userdata=userdata;
    }

    public RefundRequestData getRefundRequestData() {
        return refundRequestData;
    }

    @Override
    public void subscribe(RefundRequest refundRequest) {
        refundRequestData.addRefundRequest(refundRequest);
    }

    @Override
    public void unSubscribe(int id) {
        refundRequestData.removeRefundRequest(id);
    }

    @Override
    public void notify(int id) {
        RefundRequest refundRequest=refundRequestData.getRefundRequest(id);
        Client client = (Client) userdata.getUser(refundRequest.getClient(),"client");
        clientService.update(id,client);
    }
}
