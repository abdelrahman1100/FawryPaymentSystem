package com.example.phase2.models.transaction;

import com.example.phase2.models.refundrequest.RefundRequest;

public class RefundRequestTransaction extends Transaction {
    RefundRequest refundRequest;
    public RefundRequestTransaction(RefundRequest refundRequest){
        this.refundRequest=refundRequest;
        this.type="RefundRequestTransaction";
    }
}
