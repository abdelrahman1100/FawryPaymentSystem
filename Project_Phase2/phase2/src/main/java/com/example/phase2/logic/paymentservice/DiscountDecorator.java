package com.example.phase2.logic.paymentservice;

import com.example.phase2.models.Providers.ServiceProvider;
import com.example.phase2.models.Services.Service;
import com.example.phase2.databases.DiscountData;
import com.example.phase2.models.discount.Discount;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
@Component
public class DiscountDecorator extends PaymentService {
    DiscountData discountData;
    public DiscountDecorator(DiscountData discountData){
        this.discountData=discountData;
    }
    public double pay(Service service){
        String serviceName=service.getName();
        double cost=service.getCost();
        LinkedList<Discount>list=discountData.searchForDiscounts(serviceName);
        for (Discount discount:
             list) {
            cost=cost*discount.getDiscountValue();
        }
        return cost;
    }
}
