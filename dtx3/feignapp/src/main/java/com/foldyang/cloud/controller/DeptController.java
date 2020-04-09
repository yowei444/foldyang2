package com.foldyang.cloud.controller;

import com.foldyang.entities.Dept;
import com.foldyang.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author foldYang
 * @Description 消费者
 * @Date 2020/3/14
 * @Version 1.0
 */
@RestController
public class DeptController {

//    private static final String REST_URL_PREFIX = "http://BACK1";

    //    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
//        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
        return deptClientService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
        return deptClientService.list();
    }

}
