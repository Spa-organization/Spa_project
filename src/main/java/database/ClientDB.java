package database;

import entity.Client;


import java.util.ArrayList;
import java.util.List;

public class ClientDB {
	static List<Client> clients= new ArrayList<>();
	private ClientDB() {
		throw new IllegalStateException("Utility class");
	}
	static{
		clients.add(new Client("11","clint1","123"));
		clients.add(new Client("12","clint2","123"));
		clients.add(new Client("13","clint3","123"));
		clients.add(new Client("14","clint4","123"));
	}
	public static boolean addClient(String id,String name,String password) {
		boolean flage = true;
		for(Client client:clients){
			if(client.getId().equals(id)){
				flage=false;
				break;
			}
		}
		if(flage)
			clients.add(new Client(id, name,password));
		return flage;
	}

	public static List<Client> getClients() {
		return clients;
	}



}
