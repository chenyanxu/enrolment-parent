package com.kalix.enrolment.question.biz.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator_ on 2018/12/6.
 */
public class CurrentDate {

    public  String getNowDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return  df.format(new Date());// new Date()为获取当前系统时间
    }

//    public static void main(String[] args) {
//       System.out.println(getNowDate());
//    }
}
