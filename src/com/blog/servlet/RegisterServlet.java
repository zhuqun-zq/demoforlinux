package com.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.blog.dao.UserDao;

@WebServlet("/html/register")
public class RegisterServlet extends HttpServlet {
	UserDao ud = new UserDao();
	static Logger logger = Logger.getLogger(LoginServlet.class);

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("11111111111");
		logger.debug("欢迎双方都发生");
		String userName=request.getParameter("userName");
		String password = request.getParameter("password");
		String  secondPassword = request.getParameter("secondPassword");
	}
}
