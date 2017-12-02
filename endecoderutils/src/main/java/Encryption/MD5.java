package Encryption;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 * MD5(Message Digest algorithm 5，信息摘要算法)
 * MD5的作用就是把一个任意长度的 byte[] 变换成一定长的十六进制数字串 bigInteger）
 * 通常我们不直接使用上述MD5加密。通常将MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串
 * * md5的长度，默认为128bit，也就是128个 0和1的 二进制串 。
 * 128/4 = 32 换成 16进制 表示后，为32位了。
 * 其实16位的长度，是从32位md5值来的。是将32位md5去掉前八位，去掉后八位得到的。
 */

public class MD5 {

    /**
     * 把字节数组转成16进制数
     *
     * @param bytearr
     * @return
     */
    public static String bytearrToHex(byte[] bytearr) {
        StringBuffer md5str = new StringBuffer();
        //把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytearr.length; i++) {
            digital = bytearr[i];
            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

    /**
     * 把byte[]转换成md5
     *
     * @param bytearr
     * @return
     */
    public static String bytearrToMD5(byte[] bytearr) {
        String md5str = null;
        try {
            //创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            //计算后获得字节数组
            byte[] buff = md.digest(bytearr);
            //把数组每一字节换成16进制连成md5字符串
            md5str = bytearrToHex(buff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }


    /**
     * 把字符串转换成md5
     *
     * @param str
     * @return
     */
    public static String strToMD5(String str) {
        byte[] input = str.getBytes();
        return bytearrToMD5(input);
    }

    /**
     * 把文件转成md5字符串
     *
     * @param file
     * @return
     */
    public static String fileToMD5(File file) {
        if (file == null) {
            return null;
        }
        if (file.exists() == false) {
            return null;
        }
        if (file.isFile() == false) {
            return null;
        }
        FileInputStream fis = null;
        try {
            //创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buff = new byte[1024];
            int len = 0;
            while (true) {
                //循环读入文件流
                len = fis.read(buff, 0, buff.length);
                if (len == -1) {
                    break;
                }
                //每次循环读取一定的字节都更新
                md.update(buff, 0, len);
            }
            //关闭流
            fis.close();
            //返回md5字符串
            return bytearrToHex(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

