package org.wanwanframework.jdbc.jdbcTemplate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import oracle.jdbc.internal.OracleTypes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
public class ProcedureTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String EXECUTE_PROCEDURE = "{call coco.adder(?, ?, ?)}";

	@Test
	public void testAdd() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Integer param2Value = (Integer) jdbcTemplate.execute(new CallableStatementCreator() {
			public CallableStatement createCallableStatement(Connection con) throws SQLException {

				CallableStatement cs = con.prepareCall(EXECUTE_PROCEDURE);
				cs.setInt(1, 18);// 设置输入参数的值
				cs.setInt(2, 33);// 设置输入参数的值
				cs.registerOutParameter(3, OracleTypes.INTEGER);// 注册输出参数的类型
				return cs;
			}
		}, new CallableStatementCallback() {
			public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
				cs.execute();
				return cs.getInt(3);// 获取输出参数的值
			}
		});
		System.out.println("param2Value:" + param2Value);
	}
}
