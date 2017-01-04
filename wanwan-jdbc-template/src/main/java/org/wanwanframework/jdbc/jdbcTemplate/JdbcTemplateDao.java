package org.wanwanframework.jdbc.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 连接用Dao
 * @author coco
 *
 */
public class JdbcTemplateDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//@Autowired
	private String tableName;
	
	/**
	 * 查询数量
	 */
	public String query() {
		String countSql = "select count(*) from " + tableName;
		String count = jdbcTemplate.queryForObject(countSql, null, String.class);
		System.out.println("count:" + count);
		return count;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
