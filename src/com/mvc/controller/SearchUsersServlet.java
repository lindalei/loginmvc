package com.mvc.controller;
import java.io.*;
//import java.io.IOException;
//import com.mvc.dao.ShowUsersDao;
import com.mvc.bean.UserProfileBean;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.mvc.bean.*;
import com.mvc.dao.*;


public class SearchUsersServlet extends HttpServlet{
	public static final long serialVersionUID = 1L;
	public SearchUsersServlet(){		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		System.out.println("search Encoding is: "+request.getCharacterEncoding());
		String searchKeyword = request.getParameter("search");
		System.out.println("keyword is : "+searchKeyword);
		SearchUsersDao dao = new SearchUsersDao();
		List<UserProfileBean> usersSearched = dao.searchUsers(searchKeyword);
		request.setAttribute("usersSearched", usersSearched);
		request.getRequestDispatcher("ShowSearchedUsers.jsp").forward(request, response);
	}
}