package com.lxf.elasticsearch.controller;

import com.alibaba.fastjson.JSON;
import com.lxf.elasticsearch.model.Student;
import lombok.extern.slf4j.Slf4j;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: elasticsearch-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-12 11:27
 **/
@Slf4j
@RestController
public class EsTestController {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    public static String INDEX_TEST = null;
    public static String TYPE_TEST = null;
    public static Student student = null;
    public static List<Student> studentList = null;


    @GetMapping("insert")
    public void insert() throws Exception {
        createIndex("test");
        IndexRequest indexRequest = new IndexRequest("test");
        for (int i = 0; i<100 ;i++ ){
            Student student = new Student();
            student.setId(i);
            student.setName("tset"+i);
            student.setUpdateTime(LocalDateTime.now());
            indexRequest.source(JSON.toJSONString(student), XContentType.JSON);
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        }
    }

    @GetMapping("exists")
    public boolean exists() throws Exception {


        GetRequest getRequest = new GetRequest("test");



        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("name").id("1");
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        return exists;
    }


    public void createIndex(String string)throws Exception{
        if (isIndexExists(string)){
            return;
        }
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("test");
        restHighLevelClient.indices().create(createIndexRequest,RequestOptions.DEFAULT);
    }

    /**
     * 判断索引是否存在
     *
     * @param indexName
     * @return
     */
    public boolean isIndexExists(String indexName) {
        boolean exists = false;
        try {
            GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
            getIndexRequest.humanReadable(true);
            exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exists;
    }

    /**
     * 删除索引
     *
     * @param indexName
     * @return
     */
    public boolean deleteIndex(String indexName) {
        boolean acknowledged = false;
        try {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);
            deleteIndexRequest.indicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN);
            AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            acknowledged = delete.isAcknowledged();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acknowledged;
    }


}
