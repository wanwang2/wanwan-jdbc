package org.wanwanframework.jdbc.mybatis.utils;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.wanwanframework.jdbc.mybatis.UpdateEcCustIdVo;
import org.wanwanframework.jdbc.mybatis.dao.ReportMapper;

public class ProcedureUtils {

	public static void callProcedure(SqlSession sqlSession) {
		try {
			ReportMapper spMapper = sqlSession.getMapper(ReportMapper.class);
			UpdateEcCustIdVo vo = getUpdateEcCustIdParams(new Date(), 0);
			String r = spMapper.updateMonthReportEcCustId(vo);
			System.out.println("result:" + r);
		} catch (Exception e) {
			System.out.println("异常：" + e);
		} finally {
			sqlSession.close();
		}
	}

	protected static UpdateEcCustIdVo getUpdateEcCustIdParams(Date dataTime, int isWeekReport) {
		return new UpdateEcCustIdVo(IDateFormat.format(dataTime, "yyyy-MM-dd 00:00:00"),
				IDateFormat.format(dataTime.getTime(), "yyyy-MM-dd 23:59:59"), "0", isWeekReport);
	}
}
