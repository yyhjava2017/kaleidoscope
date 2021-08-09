package com.base.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 根据密文，生成公钥和私钥，并写入指定文件
 * @param: publicKeyFilename 公钥文件路径
 * @param: privateKeyFilename 私钥文件路径
 * @param: secret 生成密钥的密文
 */
public class RsaUtils {
    private static final int DEFAULT_KEY_SIZE = 2048;
    /**
     * 从文件中读取公钥
     *
     * @param filename
     * @return
     */
    public static PublicKey getPublicKey(String filename) throws Exception {
        byte[] bytes = readFile(filename);
        return getPublicKey(bytes);
    }
    /**
     * 从文件中读取私钥
     *
     * @param filename
     * @return
     */
    public static PrivateKey getPrivateKey(String filename) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        byte[] bytes = readFile(filename);
        return getPrivateKey(bytes);
    }
    /**
     * 根据字节生成公钥
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKey(byte[] bytes) throws Exception {
        bytes = Base64.getDecoder().decode(bytes);//解密
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);
    }
    /**
     * 根据字节生成私钥
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKey(byte[] bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);
    }


    /**
     * 生成密钥对
     *
     * @param publicKeyFilename
     * @param privateKeyFilename
     * @param secret
     * @param keySize
     * @throws Exception
     */
    public static void generateKey(String publicKeyFilename, String privateKeyFilename,
                                   String secret, int keySize) throws Exception {
        //KeyPairGenerator 类用于生成公钥和私钥对,密钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        //安全生成随机数
        SecureRandom secureRandom = new SecureRandom(secret.getBytes());
        keyPairGenerator.initialize(Math.max(keySize, DEFAULT_KEY_SIZE), secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //获取公钥并写出
        byte[] publicEncoded = keyPair.getPublic().getEncoded();
        publicEncoded = Base64.getEncoder().encode(publicEncoded);
        //写入文件中
        writeFile(publicKeyFilename, publicEncoded);
        //获取私钥并写出
        byte[] privateEncoded = keyPair.getPrivate().getEncoded();
        privateEncoded = Base64.getEncoder().encode(privateEncoded);
        //写入文件中
        writeFile(privateKeyFilename, privateEncoded);
    }

    /**
     * 写文件
     *
     * @param destPath
     * @param bytes
     * @throws IOException
     */
    private static void writeFile(String destPath, byte[] bytes) throws IOException {
        File dest = new File(destPath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(destPath);
        fos.write(bytes);
        fos.close();
    }

    /**
     * 读文件
     *
     * @param destPath
     * @return
     * @throws IOException
     */
    private static byte[] readFile(String destPath) throws IOException {
        return Files.readAllBytes(new File(destPath).toPath());
    }


    public static void main(String[] args) throws Exception {
        RsaUtils.generateKey("D:\\mykey\\pubkey","D:\\mykey\\prikey","it222heima2",2048);
        PrivateKey privateKey = RsaUtils.getPrivateKey("D:\\mykey\\prikey");
        System.out.println(privateKey.toString());
    }
}
