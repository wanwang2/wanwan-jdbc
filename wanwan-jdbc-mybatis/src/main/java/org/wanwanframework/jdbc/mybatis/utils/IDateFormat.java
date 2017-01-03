package org.wanwanframework.jdbc.mybatis.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 作者：蒋祖兵
 * 描述：
 * 时间： 2016/10/29.
 */
public class IDateFormat {
    public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    private IDateFormat(){}

    public static String format(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.isEmpty(format) ? FORMAT_TIME : format);
        return sdf.format(new Date(time));
    }

    public static String format(Date date, String format) {
        return format(date.getTime(), format);
    }

    /**
     * 获取本月前/后weeks周的最后一天
     *
     * @param weeks 小于0表示前N周，大于0表示后N周
     * @return
     */
    public static long getWeekEndDate(int weeks) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, weeks);
        //设置该周第一天为星期一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //设置最后一天是星期日
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // Sunday
        return calendar.getTimeInMillis();
    }

    /**
     * 获取本月前/后weeks周的第一天
     * @param weeks 小于0表示前N周，大于0表示后N周
     * @return
     */
    public static long getWeekStartDate(int weeks){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH,weeks);
        //设置该周第一天为星期一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //设置最后一天是星期日
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTimeInMillis();
    }

    /**
     * 获取本年的第几周
     *
     * @param weeks
     * @return
     */
    public static String getWeekOfYear(int weeks) {
        Calendar calendar = Calendar.getInstance();
        //设置该周第一天为星期一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //设置最后一天是星期日
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // Sunday
        calendar.add(Calendar.WEEK_OF_MONTH, weeks);
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int n = formatWeek(calendar.getTime());
        if (week == 1) {
            week += n;
            if (week > 50)
                year -= 1;
        } else
            week += (n > 0 ? -1 : 0);
        return year + "年 " + week + "周";
    }

    /**
     * 通过年月日获取所属的周
     * @param date  yyyyMMdd
     * @return
     */
    public static String getWeekByDate(String date){
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(4,6)) - 1;
        int day = Integer.parseInt(date.substring(6));

        Calendar calendar = Calendar.getInstance();
        //设置该周第一天为星期一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //设置最后一天是星期日
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // Sunday

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int n = formatWeek(calendar.getTime());
        if (week == 1) {
            week += n;
            if (week > 50)
                year -= 1;
        } else
            week += (n > 0 ? -1 : 0);
        return year + "年 " + week + "周";
    }
    private static int formatWeek(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //判断当年的第一天是星期几
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        //如果是周1-周4，返回0；周日，周六返回51，其他返回52
        boolean isInCurrentYear = dayOfWeek <= 4 && dayOfWeek > 0;
        boolean isSundayOrSaturday = dayOfWeek == 0 || dayOfWeek == 6;
        return  isInCurrentYear ? 0 : isSundayOrSaturday ? 51 : 52;
    }

    /**
     * 将指定格式串的年月日转换成日期
     * @param date yyyyMMdd
     * @return
     */
    public static Date formatToDate(String date){
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(4,6)) - 1;
        int day = Integer.parseInt(date.substring(6));
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        return calendar.getTime();
    }

    public static String getLastMonthOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return format(calendar.getTime(), "yyyyMM");
    }

    /**
     * 通过年月获取当月最后一天；
     * @param yearAndMonth  yyyyMM
     * @return
     */
    public static Date getEndDayOfMonthBy(String yearAndMonth){
        int year = Integer.parseInt(yearAndMonth.substring(0,4));
        int month = Integer.parseInt(yearAndMonth.substring(4)) - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();


    }

    public static Date getEndDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取上月第一天
     *
     * @return yyyy-MM-dd
     */
    public static String getLastMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH, -1);
        return format(calendar.getTime().getTime(),YYYY_MM_DD);
    }

    /**
     * 获取本月第一天
     */
    public static String getThisMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return format(calendar.getTime().getTime(),YYYY_MM_DD);
    }

    /**
     * 获取本周第一天
     * @return
     */
    public static String getThisWeekLastDay(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return format(cal.getTime(), YYYY_MM_DD);
    }

    /**
     * 获取当前的时间
     * @return
     */
    public static String getNowTime(){
        return format(new Date() , "HH:mm");
    }

    /**
     * 获取当天多少号
     * @return
     */
    public static int getNowDay(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DATE);
    }
}
