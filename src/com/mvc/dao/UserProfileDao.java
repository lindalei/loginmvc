package com.mvc.dao;
import com.mvc.bean.*;
import com.mvc.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.ResultSet; 

public class UserProfileDao {
	public String userProfileSave(UserProfileBean userProfileBean)  throws SQLException {
		int userID = userProfileBean.getId();
		String nickName = userProfileBean.getNickName();
		String university = userProfileBean.getUniversity();
		String gender = userProfileBean.getGender();
		String birthPlace = userProfileBean.getBirthPlace();
		Date birthday = userProfileBean.getBirthday();
		String filePath = userProfileBean.getFilePath();
		java.sql.Date sql_birthday = new java.sql.Date(birthday.getTime());
		String introduction = userProfileBean.getIntroduction();
		String expectation = userProfileBean.getExpectation();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;		
		
			con = DBConnection.createConnection();
			String query = "insert into userprofiles(SLNo,UserID,nickName,University,Gender,Birthplace,Birthday,Image,Introduction, Expectation) values (NULL,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, userID);
			System.out.println("saving profile user id is: "+userID);
			preparedStatement.setString(2, nickName);
			preparedStatement.setString(3, university);
			preparedStatement.setString(4, gender);
			preparedStatement.setString(5, birthPlace);
			preparedStatement.setDate(6, sql_birthday);
			preparedStatement.setString(7, filePath);
			preparedStatement.setString(8, introduction);
			preparedStatement.setString(9, expectation);			
			
			int i = preparedStatement.executeUpdate();
			if (i!=0){		
				return "SUCCESS";
			}				
		return "Can't save user profile";			
		}
	
	public String deleteProfile (int id) throws SQLException{		
		Connection con = null;
		PreparedStatement preparedStatement = null;
			con = DBConnection.createConnection();
			String query = "delete from userprofiles where UserID = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);						
			int i = preparedStatement.executeUpdate();
			if (i!=0){		
				return "SUCCESS";
			}
		return "Delete profile fail";			
		}
	
	public UserProfileBean editProfile (int id) throws SQLException{		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
			con = DBConnection.createConnection();
			
			String query = "select * from userprofiles where UserID = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);						
			results = preparedStatement.executeQuery();
			UserProfileBean user = new UserProfileBean();	
			while (results.next()){	
				user.setId(results.getInt("UserID"));
				user.setNickName(results.getString("nickName"));
				user.setUniversity(results.getString("University"));
				user.setGender(results.getString("Gender"));
				user.setBirthPlace(results.getString("Birthplace"));
				user.setBirthday(results.getDate("Birthday"));
				user.setIntroduction(results.getString("Introduction"));
				user.setExpectation(results.getString("Expectation"));
				user.setFilePath(results.getString("Image"));					
				System.out.println("edited user id is:"+user.getId());
			}
			
			return user;		
	}
	
	public String updateProfile (UserProfileBean user) throws SQLException{		
		Connection con = null;
		PreparedStatement preparedStatement = null;

		
			con = DBConnection.createConnection();
					
			java.sql.Date sql_birthday = new java.sql.Date(user.getBirthday().getTime());
			String query = "update userprofiles set nickName=?,University=?,Gender=?,Birthplace=?,Birthday=?,Image=?,Introduction=?, Expectation=? where UserID = ? ";
			preparedStatement = con.prepareStatement(query);		
			preparedStatement.setString(1, user.getNickName());
			preparedStatement.setString(2, user.getUniversity());
			preparedStatement.setString(3, user.getGender());
			preparedStatement.setString(4, user.getBirthPlace());
			preparedStatement.setDate(5, sql_birthday);
			preparedStatement.setString(6, user.getFilePath());
			preparedStatement.setString(7, user.getIntroduction());
			preparedStatement.setString(8, user.getExpectation());
			preparedStatement.setInt(9, user.getId());
			
			int i = preparedStatement.executeUpdate();
			if (i!=0){		
				return "SUCCESS";
			}				
		return "Can't update user profile";			
		}
		
	}

