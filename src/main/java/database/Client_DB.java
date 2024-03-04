package database;

import Entities.Client;


import java.util.ArrayList;
import java.util.List;

public class Client_DB {
	public static boolean flag=true;

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
	public static void call()
	{
		new Client_DB();
	}

	public static List<Client> getClients() {
		return clients;
	}
	public static boolean check_validate_ID(String idd)
	{
		for( Client client:Client_DB.getClients() )
		{
            if (idd.equals(client.getId())) {
                flag = false;
                break;
            }

		}
		return flag;

	}

	public static boolean check_digit_validate (String idd)
	{
		int length=idd.length();
        return length == 4;
    }
	public static boolean check_idFormat_validate (String idd)
	{
		boolean is_digit=false;
		char []check= idd.toCharArray();
        for (char c : check) {
            if (Character.isDigit(c)) {
                is_digit = true;
            }
        }
		return   is_digit;
	}
	public  static boolean checkPassword_Strong(String pass)
	{

        return (pass.length()>2);
    }





}
