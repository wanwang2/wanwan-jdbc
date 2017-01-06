package org.wanwanframework.jdbc.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wanwanframework.jdbc.mybatis.dao.IMEIFeedbackMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
public class FeedbackTest {

	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;
	
	@Test
	public void testFeedback() throws Exception {
		SqlSessionFactory f = ((SqlSessionFactory)sqlSessionFactoryBean.getObject());
		SqlSession session = f.openSession();
		IMEIFeedbackMapper feedbackMapper = session.getMapper(IMEIFeedbackMapper.class);
		List<IMEIFeedbackVo> list = feedbackMapper.queryCountByProvince();
		System.out.println("map:" + list);
	}
	
}
