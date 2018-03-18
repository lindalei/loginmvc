package com.mvc.dao;
import com.mvc.bean.*;
import com.mvc.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;

public class LoginDao {
	public int userValidate (LoginBean registerBean){
		String userName = registerBean.getUserName();
		String password = registerBean.getPassword();
		
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String userNameDB = "";
		String passwordDB = "";
		
		try{
			con = DBConnection.createConnection();
			String query = "select SlNo, userName,password from users";
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			int userID;
			while(resultSet.next()){
				userNameDB = resultSet.getString("userName");
				passwordDB = resultSet.getString("password");
				if(userName.equals(userNameDB)&&password.equals(passwordDB)){
					userID = resultSet.getInt(1);
					System.out.println("userID is: "+userID);
					return userID;
				}	
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}	
		return 0;
	}
}
