package com.foldyang.yowei.experience;

import com.foldyang.yowei.code.controller.CodeController;

/**
 * @Author foldYang
 * @Description 个人经验值详情实体类
 * @Date 2019/12/27
 * @Version 1.0
 */
public class Experience {

    public Integer experienceSum = 1;

    /** 1.经验值+1
     * springboot打包 这里 mvn clean 和 mvn package 结合使用  经验值+1:每次打包时可以执行项目启动的操作，即mvn clean package，因为这样在打包时可以查看项目启动是否报错这个过程(检测运行时异常)，(一个保险措施，保证项目是可以启动的)
     * mvn clean package 1)清理包 2)打包包括所有包(test包)并且要执行启动项目的过程
     * mvn clean package -Dmaven.test.skip == mvn clean package -Dmaven.test.skip=true 1)清理包 2)打包不会把test包下的class文件打到target下，并且不执行项目启动的过程
     * mvn clean package -DskipTests 1)清理包 2)打包会把test包下的class文件打到target下，并且不执行项目启动的操作
     * 打包命令是在项目的路径下面输入,例如项目为E:/myselfwebsite 即在E:/myselfwebsite下输入命令
     */

    /**
     * 在terminal中运行jar包时，当terminal关闭时，这个java程序就会停止
     */

    /**
     * super总结
     * 在两个类之间存在子父级关系时 son father
     * 1.son在默认无参构造函数中第一行是默认加了super()的
     * 2.super()在子类构造函数中必须写在第一行，当调用父类有参构造函数时，必须显示调用super(value1,value2)
     * 3.当一个类没有继承关系于另一个类时，这个类可不可以调用super关键字，可以，所有类都继承自Object类，可以调用super.toString()方法
     * 4.当父类有有参构造函数时，子类必须重写父类有参构造(简而言之:父类有的东西，子类要全部有)
     */

    /**
     * Ctrl + alt + v 为生成方法返回值
     */

}
