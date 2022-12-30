package User;


import java.util.LinkedList;

import java.util.Map;

import Discount.DiscountDecorator;
import Providers.ServiceProvider;
import Services.Service;
import Userdata.Userdata;
public class Funds implements Subject {
public LinkedList<pair>list=new LinkedList();

    public LinkedList<pair> getList() {
        return list;
    }

    @Override
    public void subscirbe(Client observer, ServiceProvider s) {
        pair p=new pair();
        p.first=observer;
        p.second=s;
        list.add(p);
    }

    @Override
    public void unsubscirbe(Client observer) {

    }

    @Override
    public void notify(Client observer,String s) {
        Client.update(s);
    }
}