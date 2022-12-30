package com.example.phase2.Discount;

import com.example.phase2.Providers.ServiceProvider;

public interface Subject {
	public void subscribe(ServiceProvider item);
	public void unsubscribe(ServiceProvider item);
	public void notifyy();
}
