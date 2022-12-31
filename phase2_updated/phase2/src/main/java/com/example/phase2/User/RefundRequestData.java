package com.example.phase2.User;

import com.example.phase2.User.bsl.clientservice.ClientService;
import com.example.phase2.User.models.RefundRequest;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
@Component
public class RefundRequestData {
    LinkedList<RefundRequest>refundRequests;
    public RefundRequestData() {
        this.refundRequests =new LinkedList<>();
    }
    public void addRefundRequest(RefundRequest refundRequest){
        refundRequests.add(refundRequest);
    }
    public void removeRefundRequest(int id){
        refundRequests.remove(getRefundRequest(id));
    }
    public RefundRequest getRefundRequest(int id){
        for (RefundRequest r: refundRequests) {
            if(r.getId()==id){
                return r;
            }
        }
        //handel exception
        return null;
    }

}
