package org.wanwanframework.jdbc.mybatis;

/**
 * 东软
 * Created by Jiang zubing on 2016/12/22.
 * 描述：
 * ***************更新历史*******************
 */
public class UpdateEcCustIdVo {
    //开始日期
    private String startTime;
    //结束日期
    private String endTime;
    //存储过程更新成功条数
    private String successCnt;
    //是否是周报表
    private int weekReportFlag = 0;
    public UpdateEcCustIdVo(String startTime,String endTime,String successCnt,int weekReportFlag){
        this.startTime = startTime;
        this.endTime = endTime;
        this.successCnt = successCnt;
        this.weekReportFlag = weekReportFlag;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSuccessCnt() {
        return successCnt;
    }

    public void setSuccessCnt(String successCnt) {
        this.successCnt = successCnt;
    }

    public int getWeekReportFlag() {
        return weekReportFlag;
    }

    public void setWeekReportFlag(int weekReportFlag) {
        this.weekReportFlag = weekReportFlag;
    }
}
