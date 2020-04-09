package com.foldyang.service;

import com.foldyang.entities.Dept;

import java.util.List;

/**
 * @Author foldYang
 * @Description service层
 * @Date 2020/3/14
 * @Version 1.0
 */
public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();

}
