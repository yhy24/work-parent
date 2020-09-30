package com.yang.es.controller;

import com.alibaba.fastjson.JSON;
import com.yang.es.config.ElasticSearchConfig;
import com.yang.es.utils.User;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@RestController
public class EsController {
    @Resource
    private RestHighLevelClient client;

    @RequestMapping("/put/{id}")
    public String tests(@PathVariable("id") String id){
        //新建一个索引
        IndexRequest indexRequest = new IndexRequest("users");
        //指定id
        indexRequest.id(id);
        User user = new User();
        user.setUserName("小明");
        user.setGender("M");
        user.setAge(18);
        // 转为json字符
        String userInfo = JSON.toJSONString(user);
        // 保存json
        indexRequest.source(userInfo, XContentType.JSON);
        // 执行操作
        IndexResponse index = null;
        try {
            index = client.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(index);
        return JSON.toJSONString(index);
    }
    @RequestMapping("/get/{id}")
    public String get(@PathVariable("id") String id) {
        GetRequest getRequest = new GetRequest(
                "users",
                id);
        GetResponse fields = null;
        try {
            fields = client.get(getRequest, ElasticSearchConfig.COMMON_OPTIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fields);
        return JSON.toJSONString(fields);
    }
    @RequestMapping("/add/{id}")
    public String tests01(@PathVariable("id") String id){
        //新建一个索引
        IndexRequest indexRequest = new IndexRequest("users");
        //指定id
        indexRequest.id(id);
        User user = new User();
        user.setUserName("小北");
        user.setGender("G");
        user.setAge(18);
        // 转为json字符
        String userInfo = JSON.toJSONString(user);
        // 保存json
        indexRequest.source(userInfo, XContentType.JSON);
        // 执行操作
        IndexResponse index = null;
        try {
            index = client.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(index);
        return JSON.toJSONString(index);
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }

}
