package org.wanwanframework.jdbc.mybatis.dao;

import org.springframework.stereotype.Component;
import org.wanwanframework.jdbc.mybatis.UpdateEcCustIdVo;

@Component
public interface ReportMapper {
	
    String updateMonthReportEcCustId(UpdateEcCustIdVo vo);
}
