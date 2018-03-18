package com.mvc.controller;

import java.io.*;
import javax.servlet.http.*;
//import java.io.*;
import com.mvc.dao.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserProfileValidateServlet extends HttpServlet{
	public static final long serialVersionUID = 1L;
	public UserProfileValidateServlet(){		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		System.out.println("UserProfile session: "+session);
		//System.out.println("UserProfile session attribute: "+session.getAttribute("userName"));
		if(session.getAttribute("userID")!=null){	
			//request.getRequestDispatcher("UserProfile.jsp").include(request, response);
			CheckUserExistDao userExist = new CheckUserExistDao();			
			Integer userID = (Integer)(session.getAttribute("userID"));
			int userId = Integer.parseInt(userID.toString());
			System.out.println("int userId is:"+userId);
			System.out.println("check user exist is:"+userExist.checkUserExist(userId));
			if("Exist".equals(userExist.checkUserExist(userId))){
				response.sendRedirect("UserDetails.jsp?id="+userId);
			}
			else{
				response.sendRedirect("UserProfile.jsp");
			}
			
		}
		else{
			out.print("Please login to view your profile");
			//request.getRequestDispatcher("Login.jsp").include(request, response);
			response.sendRedirect("Login.jsp");
			
		}
	}
	
}
