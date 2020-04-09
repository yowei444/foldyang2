package com.foldyang.service;

import com.foldyang.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/3/16
 * @Version 1.0
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDb_source("no this database in MySQL").setDeptno(id).setDname("没有对应的信息，Consumer客户端提供降级信息，此刻服务不可用");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
