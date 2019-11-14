package com.example.file.test;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * @program: file-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-09 19:43
 **/
public class BootFileRead {

    public static void main(String[] args) throws Exception{
        //getFile1();

        //getFile2();

        getFile3();

        //getFile4();

        //getFile5();

        //getFile6();
    }

    /**
     * 以下写法从当前类所在package下查找文件
     */
    public static void getFile1(){
        try {
            InputStream inputStream= BootFileRead.class.getResourceAsStream("application.txt");
            BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(new String(bufferedInputStream.readLine()));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 以下写法,从class根目录查找文件
     * @throws Exception
     */
    public static void getFile2()throws Exception{
        InputStream inputStream = BootFileRead.class.getClassLoader().getResourceAsStream("application.properties");
        BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(new String(bufferedInputStream.readLine()));
    }

    public static void getFile3()throws Exception{
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:application.txt");
        InputStream inputStreamJar = resource.getInputStream();
        System.out.println("文件名称: " + resource.getFilename());
        resource.getFile();
         inputStreamJar = resource.getInputStream();
        BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(inputStreamJar));
        System.out.println(new String(bufferedInputStream.readLine()));
    }



    public static void getFile4()throws Exception{
        InputStream inputStream = BootFileRead.class.getClassLoader().getResourceAsStream("application-dev.yml");
        Yaml yaml = new Yaml();
        Map<String, Map<String, String>> result = yaml.load(inputStream);
        for (Map.Entry<String, Map<String, String>> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    public static void getFile5() throws Exception{

        InputStream inputStream = BootFileRead.class.getClassLoader().getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties.getProperty("server.port"));


    }

    public static void getFile6 () throws Exception{


        BufferedReader br = new BufferedReader(new FileReader(new File("application.txt")));

        System.out.println(br.readLine());

    }

}
