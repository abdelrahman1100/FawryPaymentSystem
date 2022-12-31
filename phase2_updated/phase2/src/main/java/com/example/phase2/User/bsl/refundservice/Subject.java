package com.example.phase2.User.bsl.refundservice;

import com.example.phase2.User.models.RefundRequest;

public interface Subject {
    void subscribe(RefundRequest refundRequest);
    void unSubscribe (int id);
    void notify (int id);
}