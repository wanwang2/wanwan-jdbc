package org.wanwanframework.jdbc.mybatis.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.wanwanframework.jdbc.mybatis.IMEIFeedbackVo;

@Component
public interface IMEIFeedbackMapper {
	
	public List<IMEIFeedbackVo> queryCountByProvince();
}
