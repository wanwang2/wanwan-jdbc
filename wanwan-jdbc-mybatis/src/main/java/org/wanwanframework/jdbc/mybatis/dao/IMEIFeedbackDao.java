package org.wanwanframework.jdbc.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.wanwanframework.jdbc.mybatis.IMEIFeedbackVo;

@Component
public interface IMEIFeedbackDao {
	
	public List<IMEIFeedbackVo> queryCountByProvince(Map<String, Object> map);
}
