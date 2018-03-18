package com.mvc.dao;
import com.mvc.bean.*;
import com.mvc.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ShowUsersDao {
	public List<UserProfileBean> showUsers (){
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		List<UserProfileBean> users = new ArrayList<UserProfileBean>();
		
		try{
			con = DBConnection.createConnection();
			String query = "select * from userprofiles";
			preparedStatement = con.prepareStatement(query);
			results = preparedStatement.executeQuery();
			while (results.next()){
				UserProfileBean user = new UserProfileBean();
				user.setId(results.getInt(2));
				System.out.println("each id is:"+results.getInt(1));
				user.setNickName(results.getString("nickName"));
				user.setUniversity(results.getString("University"));
				user.setGender(results.getString("Gender"));
				user.setBirthPlace(results.getString("Birthplace"));
				user.setBirthday(results.getDate("Birthday"));
				user.setIntroduction(results.getString("Introduction"));
				user.setExpectation(results.getString("Expectation"));
				user.setFilePath(results.getString("Image"));
				users.add(user);
			}			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return users;	
		}
	
	public UserProfileBean getUserById(int id){
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		UserProfileBean user = new UserProfileBean();
		
		try{
			con = DBConnection.createConnection();
			String query = "select * from userprofiles where UserID=?";
			preparedStatement = con.prepareStatement(query);	
			preparedStatement.setInt(1, id);
			results = preparedStatement.executeQuery();
			
			while (results.next()){	
				user.setId(results.getInt(2));
				//System.out.println(results.getInt(0));
				System.out.println("user id is:"+results.getInt(2));
				user.setNickName(results.getString("nickName"));
				user.setUniversity(results.getString("University"));
				user.setGender(results.getString("Gender"));
				user.setBirthPlace(results.getString("Birthplace"));
				user.setBirthday(results.getDate("Birthday"));
				user.setIntroduction(results.getString("Introduction"));
				user.setExpectation(results.getString("Expectation"));
				user.setFilePath(results.getString("Image"));
			}			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return user;	
		}
	public int getUserIDByName(String userName){
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		int userID;
		try{
			con = DBConnection.createConnection();
			String query = "select SlNo from users where userName=?";
			preparedStatement = con.prepareStatement(query);	
			preparedStatement.setString(1, userName);
			results = preparedStatement.executeQuery();
			
			while (results.next()){	
				userID = results.getInt(1);
				return userID;
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return -1;	
		}
	}

