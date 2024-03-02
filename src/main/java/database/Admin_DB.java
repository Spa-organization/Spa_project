package database;

import Entities.Admin;
import java.util.ArrayList;
import java.util.List;

public class Admin_DB {
	static List <Admin> admins= new ArrayList<Admin>();
	private Admin_DB() {
		throw new IllegalStateException("Utility class");
	}
	static{
		admins.add(new Admin("1234","abdullah"));
		admins.add(new Admin("4321","younis"));
		admins.add(new Admin("4444","qusay"));
		admins.add(new Admin("5555","yanal"));
	}

	public static void addAdmin(String id,String password) {

		admins.add(new Admin(id, password));
	}

	public static List<Admin> getAdmins() {
		return admins;
	}








}
