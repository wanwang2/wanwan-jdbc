package org.wanwanframework.jdbc.jdbcTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
public class JDBCTemplateTest {

	@Autowired
	private JdbcTemplateDao jdbctemplatedao;
	
	@Test
	public void testTemplate() {
		jdbctemplatedao.query();
	}
}
