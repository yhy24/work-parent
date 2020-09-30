package com.yang.work.util;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.springframework.scheduling.concurrent.ExecutorConfigurationSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class UtilConfigiration {
    public static Template getTemplate(String name){
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);//book.ftl
        cfg.setClassForTemplateLoading(UtilConfigiration.class, "/");
        Template template = null;
        try {
            template = cfg.getTemplate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return template;
    }

    public static String process(String templatefile, Map<String, Object> param) throws IOException, TemplateException,
            Exception{
        Template template = UtilConfigiration.getTemplate(templatefile);
        StringWriter sw = new StringWriter();
//        template.process(param, sw);
        File file = new File("D:\\ftl\\book.xml");
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter out = new OutputStreamWriter(outputStream);
        Environment process = template.createProcessingEnvironment(param, out);
        process.process();
        out.flush();
        out.close();
        return sw.toString();
    }
    public static void main(String[] args) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("id", "3");
        responseMap.put("name", "红楼梦");
        responseMap.put("author", "曹雪芹");
        responseMap.put("year", "1862");
        responseMap.put("price", "98");
        String resp = null;
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();
            resp = UtilConfigiration.process("book.ftl", responseMap);
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            reentrantLock.unlock();
        }
        System.out.println(resp);

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.submit(() -> {

        });

    }

}
