package com.elaseticsearch.bboss.elaseticseachbboss;


import com.elaseticsearch.bboss.elaseticseachbboss.crud.DocumentCRUD;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class ElaseticseachBbossApplicationTests {


    @Autowired
    private BBossESStarter bbossESStarter;
    @Autowired
    DocumentCRUD documentCRUD;


    @Test
    public void bbossTest(){

        //验证环境,获取es状态
        //String response = bbossESStarter.getRestClient().executeHttp("_cluster/state?pretty",ClientInterface.HTTP_GET);
        //log.info(response);

        //判读索引是否存在，false表示不存在，正常返回true表示存在
        // boolean exist = bbossESStarter.getRestClient().existIndiceType("twitter","tweet");
         //log.info(""+exist);

    }


    @Test
    public void testCRUD() throws Exception {

        //删除/创建文档索引表
        //documentCRUD.testCreateIndice();
        //添加/修改单个文档

       // documentCRUD.testAddAndUpdateDocument();
        //批量添加文档
        //documentCRUD.testBulkAddDocument();
        //检索文档
        //documentCRUD.testSearch();
        //批量修改文档
        //documentCRUD.testBulkUpdateDocument();

        //检索批量修改后的文档
        //documentCRUD.testSearch();
        //带list复杂参数的文档检索操作
        //documentCRUD.testSearchArray();
        //带from/size分页操作的文档检索操作
       // documentCRUD.testPagineSearch();
        //带sourcefilter的文档检索操作
        //documentCRUD.testSearchSourceFilter();

        documentCRUD.updateDemoIndice();
        //documentCRUD.testBulkAddDocuments();
    }



    class Student{
        private String name;

        private String pass;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }
    }

    @Test
    void contextLoads() {


        List<Student> list = new ArrayList<Student>();
        Student student = new Student();
        student.setName("a");
        student.setPass("a1");

        Student student1 = new Student();
        student1.setName("b");
        student1.setPass("b1");

        list.add(student);
        list.add(student1);

        Set<Student> staffsSet = new HashSet<Student>(list);

        List<Student> list1 = new ArrayList<Student>();

        Student student2 = new Student();
        student2.setName("a");
        student2.setPass("a1");

        Student student4 = new Student();
        student4.setName("c");
        student4.setPass("c1");

        list.add(student);
        list.add(student1);
        for (Student s:list1
             ) {
            if (!staffsSet.add(s)) {
                System.out.println(s);
            }

        }



    }

}
