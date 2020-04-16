package com.foldyang.yowei.precaution;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.dc.path.PathError;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.function.Function;

/**
 * @Author foldYang
 * @Description 服务器连接工具类
 * @Date 2020/1/9
 * @Version 1.0
 */
public class ECSUtils {

    // 日志
    private static final Logger Log = LoggerFactory.getLogger(ECSUtils.class);

    private static ChannelSftp sftp = null;
    private static Channel channel = null;
    private static Session sshSession = null;
    private static String src = "/home/centos";
    private static String localDownPath = "E:\\filePath\\download";
    private static String localUpPath = "E:\\filepath\\upfile";

    public static void main(String[] args) {
        // host port userName passWord
        channel = getChannel("120.24.93.167", 22, "root", "folderYang444");
        List<String> str = listFileNames(channel, src);
        System.out.println("目录下包含的文件名称为:" + str);
        for (String a : str) {
            System.out.println("文件名为:" + a);
        }

        // download file from server
        getFileFromSftpServer(channel, src, localDownPath);

        // upload file to server from local
        // putFileToSftpServer(channel, src, localUpPath);

        closeResource(channel, sftp, sshSession);
    }

    public static List<String> listFileNames(Channel channel, String dir) {
        List<String> list = new ArrayList<>();
        ChannelSftp sftp = null;
        try {
            sftp = (ChannelSftp) channel;
            // 获取文件列表
            Vector vector = sftp.ls(dir);
            for (Object item : vector) {
                if (item instanceof com.jcraft.jsch.ChannelSftp.LsEntry) {
                    String fileName = ((com.jcraft.jsch.ChannelSftp.LsEntry) item).getFilename();
                    if (fileName.equals(".") || fileName.equals("..")) {
                        continue;
                    }
                    System.out.println(fileName);
                    list.add(fileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Channel getChannel(String host, int port, String userName, final String passWord) {
        try {
            JSch jsch = new JSch();
            jsch.getSession(userName, host, port);
            sshSession = jsch.getSession(userName, host, port);
            sshSession.setPassword(passWord);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            Log.debug("Session connected!");
            channel = sshSession.openChannel("sftp");
            channel.connect();
            Log.debug("Channel connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channel;
    }

    /**
     * @Author: foldYang
     * @Description: 下载文件到本地
     * @Date: 11:22 2020/1/10
     */
    public static void getFileFromSftpServer(Channel channel, String src, String localPath) {
        ChannelSftp sftp = null;
        try {
            sftp = (ChannelSftp) channel;
            // 获取文件目录下所有的文件
            Vector vector = sftp.ls(src);
            for (Object item : vector) {
                if (item instanceof com.jcraft.jsch.ChannelSftp.LsEntry) {
                    String fileName = ((com.jcraft.jsch.ChannelSftp.LsEntry) item).getFilename();
                    if (fileName.equals(".") || fileName.equals("..")) {
                        continue;
                    }
                    System.out.println(fileName);
                    File localpath = new File(localPath);
                    File[] fileList = localpath.listFiles();
                    if (!localpath.exists()) {
                        localpath.mkdirs();
                        localPath = localpath.getPath();
                    }
                    for (File file : fileList) {
                        if (fileName.equals(file.getName())) {
                            file.delete();
                        }
                    }
                    System.out.println(localPath);
                    String localFileName = localPath + File.separator + fileName;
                    sftp.get(src + "/" + fileName, localPath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: foldYang
     * @Description: 上传文件到服务器
     * @Date: 11:22 2020/1/10
     */
    public static void putFileToSftpServer(Channel channel, String src, String localPath) {
        List<String> list = new ArrayList<>();
        try {
            sftp = (ChannelSftp) channel;
            File file = new File(localPath);
            if (!file.exists()) {
                throw new PathError("本地路径有误!");
            }
            File[] files = file.listFiles();
            for (File item : files) {
                list.add(item.getName());
                System.out.println("getPath:" + item.getPath());
                sftp.put(localPath + File.separator + item.getName(), src);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: foldYang
     * @Description: 关闭资源
     * @Date: 11:24 2020/1/10
     */
    public static void closeResource(Channel channel, ChannelSftp sftp, Session session) {
        if (channel != null) {
            if (channel.isConnected()) {
                channel.disconnect();
            }
        }
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

}
