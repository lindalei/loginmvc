package com.mvc.controller;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

public class LogoutServlet extends HttpServlet{
	public static final long serialVersionUID = 1L;
	public LogoutServlet(){		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession(false);
		//if(session!=null){
			//request.getSession(false).invalidate();
		HttpSession session = request.getSession(false);
		System.out.println("before logout session: "+request.getSession(false));
		session.invalidate();
//		    session.removeAttribute("userName");
//		    session.removeAttribute("userID");
			System.out.println("after logout session: "+request.getSession(false));
//			System.out.println("Logout session attribute: "+session.getAttribute("userName"));
//			System.out.println("Logout session attribute: "+session.getAttribute("userID"));
			out.print("You are successfully logged out!"); 
			out.close(); 
			//request.getRequestDispatcher("Home.jsp").include(request, response);
			//request.getRequestDispatcher("Home.jsp").forward(request, response);
//		}
//		else{
//			out.print("You haven't login,redundant logout action");
//		}
		
		
						
		
		
	}
	
		
}
