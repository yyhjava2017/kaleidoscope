package com.yyh.seckill.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    private static final String salt = "1a2b3c4d";

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    /**
     * 输入转from
     * 第一次加默认盐，只随机抽取0、1、5、6位字符
     * @param inPass
     * @return
     */
    public static String inPass2FromPass(String inPass){
        String str = ""+salt.charAt(0)+salt.charAt(2)+inPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    /**
     * 该处的盐由前端传进来与默认盐非同一个
     * 第2加默认盐，只随机抽取0、1、3、4位字符
     * @param fromPass
     * @param dbsalt
     * @return
     */
    public static String fromPass2DbPass(String fromPass,String dbsalt){
        String str  = ""+dbsalt.charAt(0)+dbsalt.charAt(2)+fromPass+dbsalt.charAt(5)+dbsalt.charAt(4);
        return md5(str);
    }


    /**
     * 提供给客户调用的接口
     * @param inPass
     * @param dbsalt
     * @return
     */
    public static String inPass2DbPass(String inPass,String dbsalt){
        String fstr = inPass2FromPass(inPass);
        String s = fromPass2DbPass(fstr, dbsalt);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(inPass2FromPass("123456"));
        System.out.println(fromPass2DbPass("d3b1294a61a07da9b49b6e22b2cbd7f9", "1a2b3c4d"));
        System.out.println(inPass2DbPass("123456", "1a2b3c4d"));
    }
}
