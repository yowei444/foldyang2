package com.foldyang.yowei.code.controller;

import com.sun.jna.platform.win32.Crypt32;
import com.sun.jna.platform.win32.WinCrypt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.Formatter;

/**
 * @Author foldYang
 * @Description 代码进修控制层
 * @Date 2019/12/22
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class CodeController {

    @RequestMapping("/show")
    public String show() {
        return cryptRdpPassword("one");
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
