package com.example.phase2;

import com.example.phase2.models.serviceproviders.DonationProvider;
import com.example.phase2.models.serviceproviders.InternetProvider;
import com.example.phase2.models.serviceproviders.MobileProvider;
import com.example.phase2.services.donationservices.DonationProviderService;
import com.example.phase2.services.internetservices.InternetProviderService;
import com.example.phase2.services.mobileservices.MobileProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Phase2Application {
	@Autowired
	MobileProviderService mobileProviderService;
	@Autowired
	InternetProviderService internetProviderService;
	@Autowired
	DonationProviderService donationProviderService;
	Phase2Application(){
		mobileProviderService.createProvider(new MobileProvider("We"));
		mobileProviderService.createProvider(new MobileProvider("Vodafone"));
		mobileProviderService.createProvider(new MobileProvider("Orange"));
		mobileProviderService.createProvider(new MobileProvider("Etisalat"));

		internetProviderService.createProvider(new InternetProvider("We"));
		internetProviderService.createProvider(new InternetProvider("Vodafone"));
		internetProviderService.createProvider(new InternetProvider("Orange"));
		internetProviderService.createProvider(new InternetProvider("Etisalat"));

		donationProviderService.createProvider(new DonationProvider("Cancer Hospital"));
		donationProviderService.createProvider(new DonationProvider("Schools"));
		donationProviderService.createProvider(new DonationProvider("NGOs"));
	}
	public static void main(String[] args) {
		SpringApplication.run(Phase2Application.class, args);
	}

}
