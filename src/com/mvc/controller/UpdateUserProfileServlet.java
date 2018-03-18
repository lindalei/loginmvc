package com.mvc.controller;

import java.io.*;
import javax.servlet.http.*;
//import java.io.*;
import java.text.ParseException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.ServletConfig;

import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;
//import java.text.DateFormat;
import java.util.Locale;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import javazoom.upload.MultipartFormDataRequest;
//import com.oreilly.servlet.MultipartRequest;
//import org.apache.commons.io.output.*;
import java.util.List;
//import java.io.*;
//import javax.servlet.http.Part;
import com.mvc.bean.UserProfileBean;
import com.mvc.dao.UserProfileDao;

public class UpdateUserProfileServlet extends HttpServlet{
	public static final long serialVersionUID = 1L;
	public UpdateUserProfileServlet(){		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		Integer userID = (Integer)(session.getAttribute("userID"));
		int userId = Integer.parseInt(userID.toString());
		System.out.println("session userId is:"+userId);
		int maxFilesize = 500*1024;
		String filePathBase = "/images/";

		File file;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(maxFilesize);
		List <FileItem> items;
		try{
			items = upload.parseRequest(request);
			Iterator<FileItem> i = items.iterator();
			UserProfileDao userProfileDao = new UserProfileDao();	
			try{
				UserProfileBean userProfileBean = userProfileDao.editProfile(userId);
			System.out.println("updated user id is:"+userProfileBean.getId());
			String enc = request.getCharacterEncoding();
			System.out.println("Encoding is: "+enc);
			String year ="";
			String month ="";
			String day = "";
			String birth = "";
			while (i.hasNext()){						
				FileItem item = (FileItem)i.next();
				if(!item.isFormField()){
					String fileName = item.getName();
					String filePath;
					if(fileName.lastIndexOf("\\")>=0){
						filePath = filePathBase+fileName.substring(fileName.lastIndexOf("\\"));
						file = new File(filePath);
					}
					else{
						filePath = filePathBase+fileName.substring(fileName.lastIndexOf("\\")+1);
						file = new File(filePath);
					}				
					try{
						item.write(file);
						System.out.println("filePath before save is: "+filePath);
						userProfileBean.setFilePath("/pictures/"+fileName);
						System.out.println("filePath after save is: "+filePath);
						System.out.println("Uploaded Filename: " + fileName);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				else{
					String fieldName = item.getFieldName();
					String value =  item.getString("UTF-8").trim();
				    System.out.print("request paramter name is: "+fieldName+"	");
				    System.out.print("request paramter is: "+value+"	");
				    if ("nickName".equals(fieldName)){
				    	userProfileBean.setNickName(value);
				    }
				    else if ("university".equals(fieldName)){
				    	userProfileBean.setUniversity(value);
				    }
				    else if ("gender".equals(fieldName)){
				    	userProfileBean.setGender(value);
				    }
				    else if ("birthPlace".equals(fieldName)){
				    	userProfileBean.setBirthPlace(value);
				    }				    
				    else if ("introduction".equals(fieldName)){
				    	userProfileBean.setIntroduction(value);
				    }
				    else if ("expectation".equals(fieldName)){
				    	userProfileBean.setUniversity(value);
				    }
				    else if ("DateOfBirth_Month".equals(fieldName)){
				    	month = value;
				    }
				    else if ("DateOfBirth_Day".equals(fieldName)){
				    	day = value;
				    }
				    else if ("DateOfBirth_Year".equals(fieldName)){
				    	year = value;
				    }
				}
			}
			    birth = month+"-"+day+"-"+year;
				SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy",Locale.ENGLISH);
				Date birthday;			
			    System.out.println("birth string is: "+birth);
				try{			
					birthday = formatter.parse(birth);
				}
				catch (ParseException e){
					e.printStackTrace();
					return;
				}
				userProfileBean.setBirthday(birthday);									
				String userProfileUpdated = userProfileDao.updateProfile(userProfileBean);
				if (userProfileUpdated.equals("SUCCESS")){			
						//request.setAttribute("nickName", nickName);
						request.getRequestDispatcher("/Home.jsp").forward(request, response);
				}
				else{
					//request.setAttribute("errMsg", userProfileSaved);	
					out.print(userProfileUpdated);
					request.getRequestDispatcher("/editProfile.jsp").forward(request, response);
						
				}	
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}	
		catch (FileUploadException e){
			e.printStackTrace();
		}
//	}	
//	else{
//		out.print("you have to login for further action");
//	}
	}
	
}
