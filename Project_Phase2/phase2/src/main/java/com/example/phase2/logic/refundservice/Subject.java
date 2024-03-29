package com.example.phase2.logic.refundservice;

import com.example.phase2.models.refundrequest.RefundRequest;

public interface Subject {
    void subscribe(RefundRequest refundRequest);
    void unSubscribe (int id);
    void notify (int id);
}