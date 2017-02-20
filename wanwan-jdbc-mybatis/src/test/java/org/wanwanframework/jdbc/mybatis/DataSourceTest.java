package org.wanwanframework.jdbc.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wanwanframework.jdbc.mybatis.utils.ProcedureUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
public class DataSourceTest {

	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;

	@Test
	public void testSession() throws Exception {
		System.out.println("sqlSessionFactoryBean:" + sqlSessionFactoryBean);
		SqlSessionFactory f = ((SqlSessionFactory)sqlSessionFactoryBean.getObject());
		SqlSession session = f.openSession();
		System.out.println("session:" + session);
		ProcedureUtils.callProcedure(session);
	}

}
