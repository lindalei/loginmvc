package com.mvc.controller;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

public class LoginServlet extends HttpServlet{
	public static final long serialVersionUID = 1L;
	public LoginServlet(){		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();		
		LoginBean loginBean = new LoginBean();
		loginBean.setUserName(userName);
		loginBean.setPassword(password);
		
		LoginDao loginDao = new LoginDao();
		int userlogined = loginDao.userValidate(loginBean);
		if (userlogined!=0){	
			HttpSession session = request.getSession();
			session.setAttribute("userID", userlogined);
			session.setAttribute("userName", userName);
			//request.setAttribute("userName", userName);
			request.getRequestDispatcher("/Home.jsp").include(request, response);		
		}
		else{
			//request.setAttribute("errMsg", userlogined);						
			request.getRequestDispatcher("/Login.jsp").include(request, response);
			out.print(userlogined);
						
		}
		
	}
	
		
}
