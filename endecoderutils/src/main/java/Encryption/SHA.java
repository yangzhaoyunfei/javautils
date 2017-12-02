package Encryption;

import java.math.BigInteger;
import java.security.MessageDigest;

/*
SHA(Secure Hash Algorithm，安全散列算法），数字签名等密码学应用中重要的工具，
被广泛地应用于电子商务等信息安全领域。虽然，SHA与MD5通过碰撞法都被破解了，
但是SHA仍然是公认的安全加密算法，较之MD5更为安全
该算 法的思想是接收一段明文，然后以一种不可逆的方式将它转换成一段（通常更小）密文，也可以简单的理解为取一串输入码（称为预映射或信息），并把它们转化为 长度较短、位数固定的输出序列即散列值（也称为信息摘要或信息认证代码）的过程。*/
public class SHA {
    public static final String KEY_SHA = "SHA";

    public static String strToSHA(String inputStr) {
        BigInteger sha = null;
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sha.toString(32);
    }

    public static void main(String args[]) {
        try {
            String inputstr = "yangzhaoyunfei";
            System.out.println("加密前：" + inputstr);
            System.out.println("加密后：" + strToSHA(inputstr));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}