package com.mvc.dao;
import com.mvc.bean.*;
import com.mvc.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;


public class SearchUsersDao {
	public List<UserProfileBean> searchUsers (String keywordRaw){
		String keyword ="'%"+keywordRaw+"%'";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		//String sql = "select * from userprofiles where nickName LIKE keyword' OR Gender LIKE keyword OR University LIKE keyword OR Birthplace LIKE keyword OR Birthday LIKE keyword OR Introduction LIKE keyword OR Expectation Like keyword";
		//String sql = "select * from userprofiles where nickName LIKE @keyword";
		StringBuilder sql = new StringBuilder("select * from userprofiles where nickName LIKE ");
		sql.append(keyword);
		sql.append(" OR ");
		sql.append("University LIKE binary ");
		sql.append(keyword);
		sql.append(" OR ");
		sql.append("Birthday LIKE binary ");
		sql.append(keyword);
		sql.append(" OR ");
		sql.append("Introduction LIKE binary ");
		sql.append(keyword);
		sql.append(" OR ");
		sql.append("Expectation LIKE binary ");
		sql.append(keyword);
		System.out.println(sql);
		List<UserProfileBean> usersSearched = new ArrayList<UserProfileBean>();
		try{
			con = DBConnection.createConnection();
			preparedStatement = con.prepareStatement(sql.toString());
			results = preparedStatement.executeQuery();
			while(results.next()){
				UserProfileBean user = new UserProfileBean();
				user.setNickName(results.getString("nickName"));
				user.setUniversity(results.getString("University"));
				user.setGender(results.getString("Gender"));
				user.setBirthPlace(results.getString("Birthplace"));
				user.setBirthday(results.getDate("Birthday"));
				user.setIntroduction(results.getString("Introduction"));
				user.setExpectation(results.getString("Expectation"));
				usersSearched.add(user);		
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return usersSearched;			
		}
	}
