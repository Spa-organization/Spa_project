package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Client {
	String pass,name;
	int id;
	
	public String get_name() {
		try

		{
		String url="jdbc:postgresql://localhost:5432/postgres";
		Connection con = DriverManager.getConnection(url,"postgre","123");
		Class.forName("org.postgresql.Driver");	
		String sql = "select name from Spa.users where role='Customer'";
	    java.sql.Statement stmt =  con.createStatement();
	    ResultSet rs =  stmt.executeQuery(sql);
	    if(rs.next())
	    { name=rs.getString("name");}
	    
		
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
			
		return name;
	}


	public String get_Pass()
	{
		try

		{
		String url="jdbc:postgresql://localhost:5432/postgres";
		Connection con = DriverManager.getConnection(url,"postgre","123");
		Class.forName("org.postgresql.Driver");	
		String sql = "select password from Spa.users where role='Admin'";
	    java.sql.Statement stmt =  con.createStatement();
	    ResultSet rs =  stmt.executeQuery(sql);
	    if(rs.next())
	    { pass=rs.getString("password");}
	    
		
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
			
		return pass;
	}
	public int get_Customer_id() 
	{
		try

		{
		String url="jdbc:postgresql://localhost:5432/postgres";
		Connection con = DriverManager.getConnection(url,"postgre","123");
		Class.forName("org.postgresql.Driver");	
		String sql = "select userid from Spa.users where role='Admin'";
	    java.sql.Statement stmt =  con.createStatement();
	    ResultSet rs =  stmt.executeQuery(sql);
	    if(rs.next())
	    { id=rs.getInt("userid");}
	    
		
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
			
		return id;
		
	}
}
