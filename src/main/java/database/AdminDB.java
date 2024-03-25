package database;

import Entities.Admin;
import java.util.ArrayList;
import java.util.List;

public class AdminDB {
	static List <Admin> admins= new ArrayList<>();
	private AdminDB() {
		throw new IllegalStateException("Utility class");
	}
	static{
		admins.add(new Admin("21","admin1","123"));
		admins.add(new Admin("22","admin2","123"));
		admins.add(new Admin("23","admin3","123"));
		admins.add(new Admin("24","admin4","123"));
	}

	public static boolean addAdmin(String id,String name,String password) {
		boolean flage = true;
		for(Admin admin:admins){
			if(admin.getId().equals(id)){
				flage=false;
				break;
			}
		}
		if(flage)
			admins.add(new Admin(id,name, password));
		return flage;
	}

	public static List<Admin> getAdmins() {
		return admins;
	}








}
