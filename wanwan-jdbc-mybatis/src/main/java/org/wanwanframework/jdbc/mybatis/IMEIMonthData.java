package org.wanwanframework.jdbc.mybatis;

import java.util.Date;

/**
 * 月数据模型
 * 
 * @author coco
 *
 */
public class IMEIMonthData {

	private String serialNumber; // '序号 从数据文件中采集'
	private String provinceId; // '归属省'
	private String ctiyBelong; // '归属地市'
	private int userCount; // '用户数 '
	private Date importTime; // '导入时间 卡号+导入时间 索引'
	private String importBatchId; // '导入批次 '
	private String eccustName; // '集团客户名称 '
	private String eccustId; // '集团客户Id '
	private String rateImei; // '机卡分离率 '
	private String feedback; // '反馈信息 '
	private String exceptionType; // '异常原因类别 '
	private Date dataTime; // '数据时间 文件名转换为时间：查询条件 (卡号+数据时间 索引) 分区'
	private double risklevelRatioZero; // '风险等级0占比 白色预警'
	private double risklevelRatioOne; // '风险等级1占比 蓝色预警'
	private double risklevelRatioTwo; // '风险等级2占比 黄色预警'
	private double risklevelRatioThree; // '风险等级3占比 红色预警'
	private Date firstFeedbackTime; // '最早反馈时间'
	private Date lastFeedbackTime; // '最晚反馈时间'

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCtiyBelong() {
		return ctiyBelong;
	}

	public void setCtiyBelong(String ctiyBelong) {
		this.ctiyBelong = ctiyBelong;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public Date getImportTime() {
		return importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public String getImportBatchId() {
		return importBatchId;
	}

	public void setImportBatchId(String importBatchId) {
		this.importBatchId = importBatchId;
	}

	public String getEccustName() {
		return eccustName;
	}

	public void setEccustName(String eccustName) {
		this.eccustName = eccustName;
	}

	public String getEccustId() {
		return eccustId;
	}

	public void setEccustId(String eccustId) {
		this.eccustId = eccustId;
	}

	public String getRateImei() {
		return rateImei;
	}

	public void setRateImei(String rateImei) {
		this.rateImei = rateImei;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public Date getDataTime() {
		return dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	public double getRisklevelRatioZero() {
		return risklevelRatioZero;
	}

	public void setRisklevelRatioZero(double risklevelRatioZero) {
		this.risklevelRatioZero = risklevelRatioZero;
	}

	public double getRisklevelRatioOne() {
		return risklevelRatioOne;
	}

	public void setRisklevelRatioOne(double risklevelRatioOne) {
		this.risklevelRatioOne = risklevelRatioOne;
	}

	public double getRisklevelRatioTwo() {
		return risklevelRatioTwo;
	}

	public void setRisklevelRatioTwo(double risklevelRatioTwo) {
		this.risklevelRatioTwo = risklevelRatioTwo;
	}

	public double getRisklevelRatioThree() {
		return risklevelRatioThree;
	}

	public void setRisklevelRatioThree(double risklevelRatioThree) {
		this.risklevelRatioThree = risklevelRatioThree;
	}

	public Date getFirstFeedbackTime() {
		return firstFeedbackTime;
	}

	public void setFirstFeedbackTime(Date firstFeedbackTime) {
		this.firstFeedbackTime = firstFeedbackTime;
	}

	public Date getLastFeedbackTime() {
		return lastFeedbackTime;
	}

	public void setLastFeedbackTime(Date lastFeedbackTime) {
		this.lastFeedbackTime = lastFeedbackTime;
	}

	@Override
	public String toString() {
		return "IMEIMonthData [serialNumber=" + serialNumber + ", provinceId=" + provinceId + ", ctiyBelong="
				+ ctiyBelong + ", userCount=" + userCount + ", importTime=" + importTime + ", importBatchId="
				+ importBatchId + ", eccustName=" + eccustName + ", eccustId=" + eccustId + ", rateImei=" + rateImei
				+ ", feedback=" + feedback + ", exceptionType=" + exceptionType + ", dataTime=" + dataTime
				+ ", risklevelRatioZero=" + risklevelRatioZero + ", risklevelRatioOne=" + risklevelRatioOne
				+ ", risklevelRatioTwo=" + risklevelRatioTwo + ", risklevelRatioThree=" + risklevelRatioThree
				+ ", firstFeedbackTime=" + firstFeedbackTime + ", lastFeedbackTime=" + lastFeedbackTime + "]";
	}

}
