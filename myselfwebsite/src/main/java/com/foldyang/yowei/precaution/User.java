package com.foldyang.yowei.precaution;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author foldYang
 * @Description 服务器连接用户实体类
 * @Date 2020/1/9
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class User {

    /**
     * 连接用户构造类
     *
     * @param userName
     * @param host
     * @param port
     */
    public User(String userName, String host, Integer port) {
        this.userName = userName;
        this.host = host;
        this.port = port;
    }

    /**
     * 连接用户名
     */
    private String userName;

    /**
     * 连接密码
     */
    private String passWord;

    /**
     * 连接ip
     */
    private String host;

    /**
     * 连接端口
     */
    private Integer port;

}
