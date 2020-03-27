package com.blog.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.blog.bean.User;
import com.blog.bean.UserExample;
import com.blog.mapper.UserMapper;

public class UserDao {
	String resource = "mybatis.config.xml";

	public int getUserInformation(String userName, String password) {
		int flag = 0;// 0 初始化 1正确 2没有此用户 3有用户但是密码错误
		String truePassword = null;
		List<User> lu = new ArrayList<User>();
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();

			UserExample example = new UserExample();
			example.createCriteria().andUsernameEqualTo(userName);
			UserMapper mapper = session.getMapper(UserMapper.class);

			lu = mapper.selectByExample(example);
			if (lu.size() == 0) {
				flag = 2;
			} else {
				truePassword = lu.get(0).getPassword();
				if (truePassword.equals(password)) {
					flag = 1;
				} else {
					flag = 3;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public void registerNewUser(User user) {
		int flag = 0;// 0 初始化 1正确 2没有此用户 3有用户但是密码错误
		String truePassword = null;
		List<User> lu = new ArrayList<User>();
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();

			UserExample example = new UserExample();
			UserMapper mapper = session.getMapper(UserMapper.class);
			System.out.println(mapper.insert(user));
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 @Test
	 public void test(){
		 User u = new User();
		 u.setPassword("sdf");
		 registerNewUser(u);
	 }
	
}
