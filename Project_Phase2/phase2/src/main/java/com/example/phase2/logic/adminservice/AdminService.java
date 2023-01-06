package com.example.phase2.logic.adminservice;

import com.example.phase2.databases.RefundRequestData;
import com.example.phase2.databases.Userdata;
import com.example.phase2.models.user.Admin;
import org.springframework.stereotype.Component;
@Component
public class AdminService {
    RefundRequestData refundRequestData;
    Userdata userdata;
    public AdminService(RefundRequestData refundRequestData,Userdata userdata){
        this.refundRequestData=refundRequestData;
        this.userdata=userdata;
    }

    public void setRefundRequestData(RefundRequestData refundRequestData) {
        this.refundRequestData = refundRequestData;
    }

    public void setActive(Admin admin){
        userdata.active(admin);
    }
    public boolean isExist(Admin admin){
        return userdata.isExist(admin);
    }
    public boolean checkCardinality(Admin user){
        return userdata.checkCardinality(user);
    }
    public void processRefundRequests(int id,String status){
        refundRequestData.getRefundRequest(id).setStatus(status);
    }
}
