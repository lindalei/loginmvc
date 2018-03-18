package com.mvc.dao;
import com.mvc.bean.*;
import com.mvc.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterDao {
	public String registerUser (RegisterBean registerBean){
		String fullName = registerBean.getFullName();
		String email = registerBean.getEmail();
		String userName = registerBean.getUserName();
		String password = registerBean.getPassword();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		
	try{
		con = DBConnection.createConnection();
		String query = "insert into users(SLNo,fullName,Email,userName,password) values (NULL,?,?,?,?)";
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, fullName);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, userName);
		preparedStatement.setString(4, password);		
		int i = preparedStatement.executeUpdate();
		
		if (i!=0){		
			return userName;
		}
	}		
	catch (SQLException e){
		e.printStackTrace();
	}
	return "RegisterFailed";
		
	}
}
