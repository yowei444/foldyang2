package com.foldyang.dao;

import com.foldyang.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/3/14
 * @Version 1.0
 */
@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();

}
