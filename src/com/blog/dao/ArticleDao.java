package com.blog.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.blog.bean.Article;
import com.blog.bean.ArticleExample;
import com.blog.bean.ArticleWithBLOBs;
import com.blog.mapper.ArticleMapper;

import net.sf.json.JSONObject;

public class ArticleDao {
	 String resource = "mybatis.config.xml";

	public List<Article> getArticleInformationByArticleId(int articleId) {
		List<Article> la = new ArrayList<Article>();
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();

			ArticleExample example = new ArticleExample();
			example.createCriteria().andArticleIdEqualTo(articleId);
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			System.out.println("0000000000");
			List<ArticleWithBLOBs> lawb = mapper.selectByExampleWithBLOBs(example);
			// System.out.println("1111111111");
			for (ArticleWithBLOBs awb : lawb) {
				la.add(awb);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return la;
	}
	
	public   HashMap<String,String> getAllArticleList(){
		HashMap<String,String> hm = new HashMap<String,String>();
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();

			ArticleExample example = new ArticleExample();
			example.createCriteria().andArticleIdIsNotNull();
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			System.out.println("0000000000");
			List<ArticleWithBLOBs> lawb = mapper.selectByExampleWithBLOBs(example);
			System.out.println("1111111111");
			for (ArticleWithBLOBs awb : lawb) {
				System.out.println("22222");
				hm.put(awb.getArticleId().toString(),awb.getArticleTitle());
			}
			System.out.println(hm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hm;
	}
//	 public static void main(String[] args) {
//	
//		 JSONObject json = new JSONObject();
//		    HashMap<String, String> hm = getAllArticleList();
//		    json=JSONObject.fromObject(hm);
//		    System.out.println(json.toString());
//	 }

	public HashMap<String, String> queryArticleById(int articleId) {
		HashMap<String,String> hm = new HashMap<String,String>();
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();

			ArticleExample example = new ArticleExample();
			example.createCriteria().andArticleIdEqualTo(articleId);
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			//System.out.println("0000000000");
			List<ArticleWithBLOBs> lawb = mapper.selectByExampleWithBLOBs(example);
			//System.out.println("1111111111");
			for (ArticleWithBLOBs awb : lawb) {
				//System.out.println("22222");
				hm.put("articleId",awb.getArticleTitle());
				hm.put("articleTitle", awb.getArticleTitle());
				hm.put("articleContent", awb.getArticleContent());
			}
			//System.out.println(hm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hm;
	}

}
