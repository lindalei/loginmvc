package com.mvc.controller;

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


public class FilterServlet extends HttpServlet{
	public static final long serialVersionUID = 1L;
	public FilterServlet(){		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		Enumeration<String> en=request.getParameterNames();
		FilterBean filterBean = new FilterBean();
		FilterDao filterDao = new FilterDao();
		Map <String, String> map = new LinkedHashMap<String, String>();
		while(en.hasMoreElements()) //if there are more elements after the manipulated parameter, no matter whether the value is null
		{			
			Object objOri=en.nextElement();
			String param=(String)objOri;
			String value=request.getParameter(param);
			System.out.println("Parameter Name is '"+param+"' and Parameter Value is '"+value+"'");
			if(value.length()!=0){
				map.put(param, value);				
			}
		}
		filterBean.setMap(map);	
		List <UserProfileBean> usersFiltered = filterDao.filterUsers(filterBean);
		request.setAttribute("usersFiltered", usersFiltered);
		request.getRequestDispatcher("ShowFilteredUsers.jsp").forward(request, response);
	}
}