package com.foldyang.yowei.code.entity;

/**
 * @Author foldYang
 * @Description 代码文档实体类(用于保存文档内容等详情实体类)
 * @Date 2019/12/22
 * @Version 1.0
 */
public class CodeDocument {

    /**
     * 主键自增id
     */
    private Integer id;

    /**
     * 文档标题
     */
    private String title;

    /**
     * 文档链接(用阿里云保存文件)这里保存地址
     */
    private String fileUrl;

    /**
     * 文档创建日期
     */
    private String createTime;

    /**
     * 文档最后修改日期
     */
    private String lastModifyTime;

    /**
     * 文档卡片色调
     */
    private String toneOfColor;

    /**
     * 文档状态(1.可用 2.不可用)另外要删除文档时弹出一个框选择是硬删还是软删
     */
    private String documentStatus;

}