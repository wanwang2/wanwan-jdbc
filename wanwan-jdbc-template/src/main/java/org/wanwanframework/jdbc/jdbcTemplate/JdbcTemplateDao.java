package org.wanwanframework.jdbc.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcTemplateDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String QUERY_ME = "select count(*) from me";
	
	/**
	 * 查询数量
	 */
	public void query() {
		List<Object> count = jdbcTemplate.query(QUERY_ME, new RowMapper<Object>(){

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
		System.out.println("count:" + count);
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
