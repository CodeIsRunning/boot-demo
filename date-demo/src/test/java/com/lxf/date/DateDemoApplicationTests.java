package com.lxf.date;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Slf4j
@SpringBootTest
class DateDemoApplicationTests {

    @Test
    void contextLoads() {

        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDate localDate = LocalDate.now();

        LocalTime localTime = LocalTime.now();

        log.info("日期时间"+localDateTime);
        log.info("日期"+localDate);
        log.info("时间"+localTime);



        //新旧时间 转换

        Date date = new Date();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime1 =  LocalDateTime.ofInstant(date.toInstant(),zoneId);


         Date date1 =  Date.from(localDateTime1.atZone(zoneId).toInstant());

        log.info("date转LocalDateTime"+localDateTime1);
        log.info("LocalDateTime转Date"+date1);

        //格式化
        String pattern="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        log.info(sdf.format(date1));
        log.info(localDateTime1.format(DateTimeFormatter.ofPattern(pattern)));


        //常用函数

        log.info("是否在之后"+date1.after(date));
        log.info("是否在之前"+date1.before(date));
        log.info(""+date1.getTime());

        log.info("是否在之前"+localDateTime1.isBefore(localDateTime));
        log.info("是否在之后"+localDateTime1.isAfter(localDateTime));
        log.info("当月第几天"+localDateTime1.getDayOfMonth());
        log.info("周几"+localDateTime1.getDayOfWeek());
        log.info("一年的第多少天"+localDateTime1.getDayOfYear());
        log.info("当天的几点"+localDateTime1.getHour());
        log.info("多少分"+localDateTime1.getMinute());
        log.info("多少秒"+localDateTime1.getSecond());
        log.info("去毫秒值"+localDateTime1.toInstant(ZoneOffset.of("+8")).toEpochMilli());

        //计算

        log.info("加一天"+localDateTime1.plusDays(1L));
        log.info("加一个小时"+localDateTime1.plusHours(1));
        log.info("加一年"+localDateTime1.plusYears(1));
        log.info("加一个月"+localDateTime1.plusMonths(1));

        log.info("减一分钟"+localDateTime1.minusDays(1L));
        log.info("减一小时"+localDateTime1.minusHours(1));
        log.info("减一年"+localDateTime1.minusYears(1));
        log.info("减一分钟"+localDateTime1.minusMonths(1));


        long days = localDateTime1.until(localDateTime.plusDays(1), ChronoUnit.DAYS);
        log.info("时间差"+days);

        //others
        log.info("本月第一天"+localDateTime1.with(TemporalAdjusters.firstDayOfMonth()));
        log.info("本月最后一天"+localDateTime1.with(TemporalAdjusters.lastDayOfMonth()));

        log.info("是否是闰年"+Year.isLeap(localDateTime1.getYear()));

    }

    @Test
    public void c3p0()throws Exception{

        ComboPooledDataSource combo = new ComboPooledDataSource();
        combo.setDriverClass("com.mysql.cj.jdbc.Driver"); // 加载驱动
        combo.setPassword("1234567");
        combo.setUser("root");
        combo.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true"); // 地址可以换成云端
        combo.setMaxPoolSize(10); //池中最大的数量
        combo.setMinPoolSize(3);
        combo.setCheckoutTimeout(20000); // 超时连接，断
        //测试下
        Connection  connection= combo.getConnection();

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM user ");

        while(rs.next()) {
            System.out.println(
                    rs.getString("id") +"\t"+
                            rs.getString("email") +"\t"+
                            rs.getString("user_name") +"\t"
            );

        }


    }

}
