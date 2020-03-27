package com.blog.test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

//import bean.Article;
//import bean.ArticleExample;
//import bean.ArticleWithBLOBs;
//import dao.ArticleMapper;

public class Test {
	public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        InputStream is= Test.class.getClassLoader().getResource("generatorConfig.xml").openStream();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("生成代码成功，刷新项目，查看文件,然后执行TestMybatis.java");
		
//		String resource = "mybatis.config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session=sqlSessionFactory.openSession();
// 
//        ArticleExample example = new ArticleExample();
//        example.createCriteria().andArticleIdEqualTo(1);
//        ArticleMapper mapper = session.getMapper(ArticleMapper.class);
//        List<ArticleWithBLOBs> cs= mapper.selectByExampleWithBLOBs(example);
// 
//        for (ArticleWithBLOBs c : cs) {
//            System.out.println(c.getArticleTitle()+c.getArticleContent());
//        }
         
    }
}
