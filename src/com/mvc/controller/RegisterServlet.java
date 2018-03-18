package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.*;

public class RegisterServlet extends HttpServlet{
	public static final long serialVersionUID = 1L;
	public RegisterServlet(){		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		RegisterBean registerBean = new RegisterBean();
		registerBean.setFullName(fullName);
		registerBean.setEmail(email);
		registerBean.setUserName(userName);
		registerBean.setPassword(password);
		
		RegisterDao registerDao = new RegisterDao();
		ShowUsersDao usersDao = new ShowUsersDao();
		int userID;
		String userRegisteredName = registerDao.registerUser(registerBean);
		if (!"RegisterFailed".equals(userRegisteredName)){
			userID = usersDao.getUserIDByName(userRegisteredName);
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("userID", userID);
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		
		}
		else{
			request.setAttribute("errMsg", userRegisteredName);
			try{
				request.getRequestDispatcher("/Register.jsp").forward(request, response);
			}
			catch (ServletException se){
				se.printStackTrace();
			}
			catch (IOException ie){
				ie.printStackTrace();
			}
		}
		
	}
	
		
}
