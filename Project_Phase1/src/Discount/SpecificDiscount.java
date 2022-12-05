package Discount;

import java.util.LinkedList;

import Payment.Payment;
import Providers.ServiceProvider;

public class SpecificDiscount extends DiscountDecorator implements Subject {
	   private LinkedList<ServiceProvider>list=new LinkedList();
	   
	   public void Subscribe (ServiceProvider item){
		   list.add(item);
	   }
	   
	   public void checkDiscount(ServiceProvider name) {
		   boolean ok=false;
		   for (ServiceProvider temp : list) {
			    if(temp.getClass().equals(name.getClass())) {
					System.out.println("This ServiceProvider has SpecificDiscount");
					ok=true;
				}
	        }
		    if(!ok) {
			   System.out.println("This ServiceProvider do not have SpecificDiscount");
		    }
	   }
	   @Override
		 public void subscribe (ServiceProvider item){
			   list.add(item);
		   }

		@Override
		public void unsubscribe(ServiceProvider item) {
			// TODO Auto-generated method stub
			list.remove(item);
		}

		@Override
		public void notifyy() {
			// TODO Auto-generated method stub
			for (ServiceProvider temp : list) {
			    temp.update(0.1);
	        }
		}
	
}
