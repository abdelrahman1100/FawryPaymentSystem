package com.example.phase2.dto;

public class PaymentRequest {
    private Long clientId;
    private Long providerId;
    private double amount;
    private String paymentMethod;

    public PaymentRequest() {}

    public PaymentRequest(Long clientId, Long providerId, double amount, String paymentMethod) {
        this.clientId = clientId;
        this.providerId = providerId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
