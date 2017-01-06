package org.wanwanframework.jdbc.mybatis;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IMEIFeedbackVo implements Serializable {
	// 省份
	private int province;
	// 本月机卡分离总数
	private int total; 
	// 已经反馈原因数据
	private int feedbackData;
	// 未反馈原因数据
	private int notFeedbackData;
	// 首次反馈时间
	private int firstFeedTime;
	// 最后反馈时间
	private int lastFeedTime;
	// 未反馈原因数据占比
	private int notFeedbackPercent;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	public int getFeedbackData() {
		return feedbackData;
	}
	public void setFeedbackData(int feedbackData) {
		this.feedbackData = feedbackData;
	}
	public int getNotFeedbackData() {
		return notFeedbackData;
	}
	public void setNotFeedbackData(int notFeedbackData) {
		this.notFeedbackData = notFeedbackData;
	}
	public int getFirstFeedTime() {
		return firstFeedTime;
	}
	public void setFirstFeedTime(int firstFeedTime) {
		this.firstFeedTime = firstFeedTime;
	}
	public int getLastFeedTime() {
		return lastFeedTime;
	}
	public void setLastFeedTime(int lastFeedTime) {
		this.lastFeedTime = lastFeedTime;
	}
	public int getNotFeedbackPercent() {
		return notFeedbackPercent;
	}
	public void setNotFeedbackPercent(int notFeedbackPercent) {
		this.notFeedbackPercent = notFeedbackPercent;
	}
	
	
}
