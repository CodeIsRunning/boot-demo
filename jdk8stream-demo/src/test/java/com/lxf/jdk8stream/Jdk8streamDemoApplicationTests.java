package com.lxf.jdk8stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class Jdk8streamDemoApplicationTests {

    @Test
    void contextLoads() {

        test1();


    }

    /**
     * Collection
     */
    private void test1(){

        List<String> list = Arrays.asList("1","2","3","4","5","5","a","b","c");

        //去重
        //list.stream().distinct().forEach(s -> System.out.print(s+" "));
        System.out.println();
       // list.forEach(s -> System.out.print(s+" "));

        //list.parallelStream().forEach(s -> System.out.print(s+" "));

       // list.stream().filter(s -> s.contains("5")).distinct().forEach(s -> System.out.print(s+" "));

/*        list.stream().map(s -> {
                if (s.contains("5")) {
                    return "50";
                }return s;
                }
            ).forEach(s -> System.out.print(s+" "));*/

/*        List<String> list1 = list.stream().map(s -> {
                    if (s.contains("5")) {
                        return "50";
                    }return s;
                }
        ).collect(Collectors.toList());
        list1.add("d");

        System.out.println(list1);*/

        //所有内容满足条件返回true
        //System.out.println(list.stream().allMatch(s -> s.contains("5")));
        //有内容满足条件返回true
        //System.out.println(list.stream().anyMatch(s -> s.contains("5")));



    }


}
