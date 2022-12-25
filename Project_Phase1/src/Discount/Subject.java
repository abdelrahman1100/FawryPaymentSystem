package Discount;

import Providers.ServiceProvider;

public interface Subject {
	public void subscribe(ServiceProvider item);
	public void unsubscribe(ServiceProvider item);
	public void notifyy();
}
