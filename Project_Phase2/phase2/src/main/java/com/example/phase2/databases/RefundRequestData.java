package com.example.phase2.databases;

import com.example.phase2.models.refundrequest.RefundRequest;
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

    public LinkedList<RefundRequest> getRefundRequests() {
        return refundRequests;
    }
}
