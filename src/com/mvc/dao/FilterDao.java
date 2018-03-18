package com.mvc.dao;
import com.mvc.bean.*;
import com.mvc.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;


public class FilterDao {
	public List<UserProfileBean> filterUsers (FilterBean filter){
		Connection con = DBConnection.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		List<UserProfileBean> usersFiltered = new ArrayList<UserProfileBean>();
		Map<String, String> map = (LinkedHashMap<String,String>)filter.getMap();
		List<Entry<String,String>> entryList =
			    new ArrayList<Entry<String, String>>(map.entrySet());
		StringBuilder sql = new StringBuilder("select * from userprofiles where ");
		Iterator<Entry<String,String>> entries = entryList.iterator();
		while(entries.hasNext()){
			Entry<String,String> entry = (Entry<String,String>)entries.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			sql.append(key);
			sql.append("=");
			sql.append("'");
			sql.append(value);
			sql.append("'");
			if(!entry.equals(entryList.get(entryList.size()-1))){
				sql.append(" and ");
			}						
		}		
		System.out.println(sql.toString());
		try{
			preparedStatement = con.prepareStatement(sql.toString());
			results = preparedStatement.executeQuery();
			while (results.next()){
				UserProfileBean user = new UserProfileBean();
				user.setNickName(results.getString("nickName"));
				user.setUniversity(results.getString("University"));
				user.setGender(results.getString("Gender"));
				user.setBirthPlace(results.getString("Birthplace"));
				user.setBirthday(results.getDate("Birthday"));
				user.setIntroduction(results.getString("Introduction"));
				user.setExpectation(results.getString("Expectation"));
				usersFiltered.add(user);
			}	
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return usersFiltered;			
		}
	}
