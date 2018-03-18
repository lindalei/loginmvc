package com.mvc.controller;

import java.io.*;
//import java.io.*;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	//public static final long serialVersionUID = 1L;
	public TestServlet(){		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

		String testName = request.getParameter("testName");
		System.out.println("test encoding is "+request.getCharacterEncoding());
		System.out.println("testName is "+testName);
	}

	
}
