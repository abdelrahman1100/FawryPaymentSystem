package com.example.phase2.models.Services;

import com.example.phase2.models.Providers.ServiceProvider;

public interface Service {

	public String getName();
	public void setName(String name);
	public double getCost();
	public void showProvidersList();
	public void ShowPaymentMethod();

	public void setProvider(ServiceProvider provider);
	public boolean checkPaymentMethod(String paymentMethod) ;
	public ServiceProvider getProvider();

}
