package com.mvc.controller;

import java.io.IOException;
import com.mvc.dao.ShowUsersDao;
import com.mvc.bean.UserProfileBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


public class ShowUsersServlet extends HttpServlet{
	public static final long serialVersionUID = 1L;
	public ShowUsersServlet(){		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		ShowUsersDao usersDao = new ShowUsersDao();
		List<UserProfileBean> users = usersDao.showUsers();
		try{
			request.setAttribute("users", users);
			request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
		}		
		catch (ServletException se){
			se.printStackTrace();
		}
		catch (IOException ie){
			ie.printStackTrace();
		}
	}
}