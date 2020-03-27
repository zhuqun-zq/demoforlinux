package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.blog.dao.ArticleDao;
import net.sf.json.JSONObject;

@WebServlet("/html/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDao ad = new ArticleDao();
	static Logger logger = Logger.getLogger(IndexServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action = request.getParameter("action");
		if("init".equals(action)){
			init(request,response);
		}
		if("queryArticleById".equals(action)){
			queryArticleById(request,response);
		}
	}
	
	protected void init(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		HashMap<String, String> hm = ad.getAllArticleList();
		json = JSONObject.fromObject(hm);
		out.println(json.toString());
		out.flush();
		out.close();
	}
	
	protected void queryArticleById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		int articleId = Integer.parseInt(request.getParameter("id"));
		HashMap<String, String> hm = ad.queryArticleById(articleId);
		json = JSONObject.fromObject(hm);
		out.println(json.toString());
		out.flush();
		out.close();
	}
}
