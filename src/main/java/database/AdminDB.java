package database;

import entity.Admin;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class AdminDB {
	@Getter
	static List <Admin> admins= new ArrayList<>();
	private AdminDB() {
		throw new IllegalStateException("Utility class");
	}
	static{
		admins.add(new Admin("21","ali","123"));
		admins.add(new Admin("22","eman","123"));
		admins.add(new Admin("23","wadia","123"));
		admins.add(new Admin("24","loay","123"));
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


}
