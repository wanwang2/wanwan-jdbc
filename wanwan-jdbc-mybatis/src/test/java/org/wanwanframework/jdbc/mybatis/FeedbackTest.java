package org.wanwanframework.jdbc.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wanwanframework.jdbc.mybatis.dao.IMEIFeedbackDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
public class FeedbackTest {

	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;
	
	@Test
	public void testFeedback() throws Exception {
		SqlSessionFactory f = ((SqlSessionFactory)sqlSessionFactoryBean.getObject());
		SqlSession session = f.openSession();
		IMEIFeedbackDao feedbackMapper = session.getMapper(IMEIFeedbackDao.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", 1);
		map.put("endIndex", 3);
		List<IMEIFeedbackVo> list = feedbackMapper.queryCountByProvince(map);
		System.out.println("list.size:" + list.size());
	}
	
	private static final String QUERY_RULE_LIST = "org.wanwanframework.jdbc.mybatis.dao.IMEIFeedbackDao.queryCountByProvince";
	
	//@Test
	public void testFeedback2() throws Exception {
		SqlSessionFactory f = ((SqlSessionFactory)sqlSessionFactoryBean.getObject());
		SqlSession session = f.openSession();
		List<IMEIFeedbackVo> list = session.selectList(QUERY_RULE_LIST);
		System.out.println("map:" + list);
	}
}
