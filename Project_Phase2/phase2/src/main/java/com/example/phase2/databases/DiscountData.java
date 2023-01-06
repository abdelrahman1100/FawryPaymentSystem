package com.example.phase2.databases;

import com.example.phase2.models.discount.Discount;
import com.example.phase2.models.discount.SpecificDiscount;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
@Component
public class DiscountData {
    LinkedList<Discount>list;
    public DiscountData(){
        this.list=new LinkedList<>();
    }
    public void addDiscount(Discount discount){
        list.add(discount);
    }
    public LinkedList<Discount>searchForDiscounts(String service){
        LinkedList<Discount>discounts=new LinkedList<>();
        for (Discount discount: list) {
            if(discount.getType().equals("SpecificDiscount")){
                SpecificDiscount specificDiscount= (SpecificDiscount) discount;
                if(specificDiscount.getService().equals(service)) {
                    discounts.add(discount);
                }
            }
            else {
                discounts.add(discount);
            }
        }
        return discounts;
    }
    public Boolean hasDiscount(String service){
        for (Discount discount: list) {
            if(discount.getType().equals("SpecificDiscount")){
                SpecificDiscount specificDiscount= (SpecificDiscount) discount;
                if(specificDiscount.getService().equals(service)) {
                    return true;
                }
            }
            else {
                return true;
            }
        }
        return false;
    }
}
