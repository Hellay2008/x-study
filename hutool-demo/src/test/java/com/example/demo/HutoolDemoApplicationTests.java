package com.example.demo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import java.io.File;
import java.util.*;

@SpringBootTest
class HutoolDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void getPath(){

    }

    @Test
    public void test(){
        String dictData=null;
        assert dictData != null;
        System.out.println("good");

    }

    @Test
    public void testWeekOfYear(){
        int week = DateUtil.weekOfYear(DateUtil.parseDate("2020-01-01"));
        System.out.println(week);
        week = DateUtil.weekOfYear(DateUtil.parseDate("2020-12-03"));
        System.out.println(week);
        week = DateUtil.weekOfYear(DateUtil.parseDate("2023-01-01"));
        System.out.println(week);
        week = DateUtil.weekOfYear(DateUtil.parseDate("2023-01-02"));
        System.out.println(week);
    }

    @Test
    public void testDayOfYear(){
        int day = DateUtil.dayOfYear(DateUtil.parse("2020-10-16"));
        System.out.println(day);
        day = DateUtil.dayOfYear(DateUtil.parse("2019-12-31"));
        System.out.println(day);
        day = DateUtil.dayOfYear(DateUtil.parse("2020-01-01"));
        System.out.println(day);
        day = DateUtil.dayOfYear(DateUtil.parse("2020-12-31"));
        System.out.println(day);
        day = DateUtil.dayOfYear(DateUtil.parse("2020-08-19"));
        System.out.println(day);
        day = DateUtil.dayOfYear(DateUtil.parse("2020-06-15"));
        System.out.println(day);
        day = DateUtil.dayOfYear(DateUtil.parse("2020-06-24"));
        System.out.println(day);
        day = DateUtil.dayOfYear(DateUtil.parse("2020-10-15"));
        System.out.println(day);
        day = DateUtil.dayOfYear(DateUtil.parse("2020-12-03"));
        System.out.println(day);
        day = DateUtil.dayOfYear(DateUtil.parse("2020-08-19"));
        System.out.println(day);
    }

    //selected should be date of file name;
    private int getHSBCWorkingDayOfYear(Date selectedDate){
        //第一周假期数
        int weekOfYear = DateUtil.weekOfYear(selectedDate);
        if(weekOfYear == 1){
            return DateUtil.dayOfMonth(selectedDate)-1;
        }
        int weekendDaysOfFirstWeek = getWeekendDaysOfFirstWeek(selectedDate);
        int holidayCountOnWorkingDayTilSelectedDate = getHolidayCountOnWorkingDayTilSelectedDate(selectedDate);
        int weekendDayCountOfSelectedDate = getWeekendDaysOfSelectedDate(selectedDate);
        int dayOfYear = DateUtil.dayOfYear(selectedDate);
        int daySequence = dayOfYear - weekendDaysOfFirstWeek - (weekOfYear-2) * 2 - weekendDayCountOfSelectedDate - holidayCountOnWorkingDayTilSelectedDate;
        return daySequence;
    }

    private int getWeekendDaysOfFirstWeek(Date date){
        return 1;
    }

    private int getWeekendDaysOfSelectedDate(Date date){
        return 1;
    }

    private int getHolidayCountOnWorkingDayTilSelectedDate(Date date){
        return 1;
    }

    @Test
    public void testWorkingDayOfYear(){
        int workingDayOfYear = getHSBCWorkingDayOfYear(DateUtil.parseDate("2020-11-27"));
        System.out.println("2020-11-27="+workingDayOfYear);
        workingDayOfYear = getHSBCWorkingDayOfYear(DateUtil.parseDate("2020-11-28"));
        System.out.println("2020-11-28="+workingDayOfYear);
        workingDayOfYear = getHSBCWorkingDayOfYear(DateUtil.parseDate("2020-12-01"));
        System.out.println("2020-12-01="+workingDayOfYear);
        workingDayOfYear = getHSBCWorkingDayOfYear(DateUtil.parseDate("2020-12-02"));
        System.out.println("2020-12-02="+workingDayOfYear);
        workingDayOfYear = getHSBCWorkingDayOfYear(DateUtil.parseDate("2020-01-02"));
        System.out.println("2020-01-02="+workingDayOfYear);
        workingDayOfYear = getHSBCWorkingDayOfYear(DateUtil.parseDate("2020-01-03"));
        System.out.println("2020-01-03="+workingDayOfYear);
        workingDayOfYear = getHSBCWorkingDayOfYear(DateUtil.parseDate("2020-01-04"));
        System.out.println("2020-01-04="+workingDayOfYear);
        workingDayOfYear = getHSBCWorkingDayOfYear(DateUtil.parseDate("2020-01-07"));
        System.out.println("2020-01-07="+workingDayOfYear);
        workingDayOfYear = getHSBCWorkingDayOfYear(DateUtil.parseDate("2020-01-08"));
        System.out.println("2020-01-08="+workingDayOfYear);
        workingDayOfYear = getHSBCWorkingDayOfYear(DateUtil.parseDate("2020-01-14"));
        System.out.println("2020-01-14="+workingDayOfYear);

    }

    @Test
    public void testDayOfWeek(){
        System.out.println(DateUtil.dayOfWeek(DateUtil.parseDate("2020-12-07")));
        System.out.println(DateUtil.dayOfWeek(DateUtil.parseDate("2020-12-13")));
    }

    @Test
    public void test11(){
        String seqLine = ":28C:00189/0001";
        String dayOfYear = seqLine.substring(5, 10);
        String subSeq = seqLine.substring(11);
        System.out.println(dayOfYear);
        System.out.println(subSeq);

    }


    @Test
    public void refineFileContent() {
        List<String> lines = new ArrayList<>(1);
        lines.add("CONTINUEjava.lang.Exception: 获取AccessToken异常：java.lang.RuntimeException: username=HAWPWYP7FCWKUD8B:AFcWxV21C7fd0v3bYYYRCpSSRl31AWT-G7TkJOkjrFq-e2sGf3le4USw 获取token失败,httpCode=401,账号：paypal_api1.dji.com,body信息：{\"error\":\"invalid_client\",\"error_description\":\"Client Authentication failed\"}");
        String line = lines.get(0);
        String linePrefix = line.substring(0, line.indexOf("{"));
        int accountStartIndex = linePrefix.indexOf("账号：") + 3;
        int accountEndIndex = linePrefix.indexOf(",body信息");
        String account = linePrefix.substring(accountStartIndex, accountEndIndex);
        line = line.substring(line.indexOf("{"));
        lines.set(0, line);
        System.out.println(account);
        System.out.println(line);
    }



}
