package database;

import Entities.Client;


import java.util.ArrayList;
import java.util.List;

public class Client_DB {
	static List<Client> clients= new ArrayList<Client>();
	private Client_DB() {
		throw new IllegalStateException("Utility class");
	}
	static{
		clients.add(new Client("1111","passing"));
		clients.add(new Client("2222","omg"));
		clients.add(new Client("6666","momo"));
		clients.add(new Client("7777","shosho"));
	}
	public static void addClient(String id,String password) {

		clients.add(new Client(id, password));
	}

	public static List<Client> getClients() {
		return clients;
	}

}
