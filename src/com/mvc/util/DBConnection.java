package com.mvc.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	 static Connection con = null;
	 public static Connection createConnection(){
//		Connection con = null;
//		String url = "jdbc:mysql://localhost:3306/lindaDB?useUnicode=true&characterEncoding=utf8";
//		String user = "root";
//		String pwd = "Initial0";
//		try{
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//		}
//		catch (ClassNotFoundException e){
//			e.printStackTrace();
//		}
//		con = DriverManager.getConnection(url, user, pwd);
//		}
//		catch (Exception e){
//			e.printStackTrace();
//		}
//		return con;	
		String url = "jdbc:mysql://localhost:3306/lindaDB?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String pwd = "Initial0";
        if (con != null) return con;
        // get db, user, pass from settings file
        return createConnection(url, user, pwd);
    }

	    private static Connection createConnection(String url,String user,String password){
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            con=DriverManager.getConnection(url,user,password);
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	        return con;        
	    }
	}
