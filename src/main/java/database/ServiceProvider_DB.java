package database;


import Entities.ServiceProvider;
import login.LoginAsServiceProvider;

import java.util.ArrayList;
import java.util.List;

public class ServiceProvider_DB {
	static List<ServiceProvider> serviceProviders= new ArrayList<ServiceProvider>();
	private ServiceProvider_DB() {
		throw new IllegalStateException("Utility class");
	}
	static{
		serviceProviders.add(new ServiceProvider("2323","true Pass"));
		serviceProviders.add(new ServiceProvider("3434","0025"));
		serviceProviders.add(new ServiceProvider("5656","hello"));
		serviceProviders.add(new ServiceProvider("7654","heyThere"));
	}
	public static void addServiceProviders(String id,String password) {

		serviceProviders.add(new ServiceProvider(id, password));
	}

	public static List<ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}




}
