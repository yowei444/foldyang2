package com.foldyang.yowei.practice;

import com.sun.jna.platform.win32.Crypt32;
import com.sun.jna.platform.win32.WinCrypt;
import org.junit.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.security.provider.MD5;

import java.nio.charset.Charset;
import java.util.Formatter;

/**
 * @Author foldYang
 * @Description 测试CommandLineRunner的作用：CommandLineRunner接口的作用是在springboot中实现了这个接口的类在项目启动后执行run方法里面的功能
 * @Date 2020/02/24
 * @Version 1.0
 */
@Component
@Order(value=1)
public class CommandLineRunnerTestOne implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }

    @Test
    public void show(){
        String one=cryptRdpPassword("one");
        System.out.println(one);
    }

    private String cryptRdpPassword(String password) {
        WinCrypt.DATA_BLOB pDataIn = new WinCrypt.DATA_BLOB(password.getBytes(Charset.forName("UTF-16LE")));
        WinCrypt.DATA_BLOB pDataEncrypted = new WinCrypt.DATA_BLOB();
        Crypt32.INSTANCE.CryptProtectData(pDataIn, "psw", null, null, null, 1, pDataEncrypted);
        StringBuffer epwsb = new StringBuffer();
        byte[] pwdBytes;
        pwdBytes = pDataEncrypted.getData();
        Formatter formatter = new Formatter(epwsb);
        for (final byte b : pwdBytes) {
            formatter.format("%02X", b);
        }
        return epwsb.toString();
    }

}
