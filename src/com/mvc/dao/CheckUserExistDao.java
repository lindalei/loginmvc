package com.mvc.dao;
import com.mvc.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;

public class CheckUserExistDao {
	public String checkUserExist (int id){
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;		
		
		try{
			con = DBConnection.createConnection();
			String query = "select UserID from userprofiles";
			preparedStatement = con.prepareStatement(query);
			results = preparedStatement.executeQuery();
			while (results.next()){
				System.out.println("results UserID is:"+results.getInt(1));
				if(results.getInt(1) == id){
					return "Exist";
				}
			}			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return "user not exist";	
		}
	
	
	}

