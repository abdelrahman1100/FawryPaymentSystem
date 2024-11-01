package com.example.phase2.models;

import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.InternetProvider;
import com.example.phase2.models.serviceproviders.Landline;
import com.example.phase2.models.serviceproviders.MobileProvider;
import com.example.phase2.models.user.Client;
import jakarta.persistence.*;

@Entity
@Table
public class Transaction {
    @Id
    Long id;
    @JoinColumn
    @ManyToOne
    Client client;
    String paymentMethod;
    double amount;
    @JoinColumn
    @OneToOne
    Refund refund;
    @JoinColumn
    @ManyToOne
    MobileProvider mobileProvider;
    @JoinColumn
    @ManyToOne
    InternetProvider internetProvider;
    @JoinColumn
    @ManyToOne
    Landline landline;
    @JoinColumn
    @ManyToOne
    DonationProvider donationProvider;


    //??
    String provider;
    String serviceType;

    public Transaction() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public MobileProvider getMobileProvider() {
        return mobileProvider;
    }

    public void setMobileProvider(MobileProvider mobileProvider) {
        this.mobileProvider = mobileProvider;
    }

    public InternetProvider getInternetProvider() {
        return internetProvider;
    }

    public void setInternetProvider(InternetProvider internetProvider) {
        this.internetProvider = internetProvider;
    }

    public Landline getLandline() {
        return landline;
    }

    public void setLandline(Landline landline) {
        this.landline = landline;
    }

    public DonationProvider getDonationProvider() {
        return donationProvider;
    }

    public void setDonationProvider(DonationProvider donationProvider) {
        this.donationProvider = donationProvider;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Refund getRefund() {
        return refund;
    }

    public void setRefund(Refund refund) {
        this.refund = refund;
    }
}
