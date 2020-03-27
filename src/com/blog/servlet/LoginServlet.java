package com.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.blog.dao.UserDao;

public class LoginServlet extends HttpServlet {
	UserDao ud = new UserDao();
	static Logger logger = Logger.getLogger(LoginServlet.class);

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		logger.debug("用户输入的用户名："+userName);
		logger.debug("用户输入的密码："+password);
		int flag = ud.getUserInformation(userName, password);
		if (flag == 1) {
			request.getSession().setAttribute("userName", userName);
			response.sendRedirect("./index.html");
		}
		if(flag == 2){
			response.getWriter().println("No UserName");
		}
		if(flag == 3){
			response.getWriter().println("password wrong");
		}

	}
}
