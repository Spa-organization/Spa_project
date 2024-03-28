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
		clients.add(new Client("11","clint1","123","qsay.3w@gmail.com"));
		clients.add(new Client("12","clint2","123","younism381@gmail.com"));
		clients.add(new Client("13","clint3","123","abdullahshabib33@gmail.com"));
		clients.add(new Client("14","clint4","123","qsay.3w@gmail.com"));
	}
	public static boolean addClient(String id,String name,String password,String email) {
		boolean flag = true;
		for(Client client:clients){
			if(client.getId().equals(id)){
				flag=false;
				break;
			}
		}
		if(flag)
			clients.add(new Client(id, name,password,email));
		return flag;
	}

	public static List<Client> getClients() {
		return clients;
	}



}
