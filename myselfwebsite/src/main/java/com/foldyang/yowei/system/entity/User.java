package com.foldyang.yowei.system.entity;

/**
 * @Author foldYang
 * @Description 登录用户实体类
 * @Date 2019/12/22
 * @Version 1.0
 */
public class User {

    /**
     * 用户主键(自增)
     */
    private Integer id;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 登录密码
     */
    private String passWord;

    /**
     * 头像
     */
    private String headPortrait;

    /**
     * 座右铭
     */
    private String motto;

    /**
     * 角色(1.软件 2.折纸 3.大学) 用于登录时跳转到哪个系统
     */
    private Integer roleType;

    /**
     * 系统界面头部色调(这里点击用弹出插件，然后选择颜色，然后保存颜色到数据库)
     */
    private String toneOfColor;

}
