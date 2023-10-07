package com.vrtrain.springboot.utils;
import java.io.*;
import java.nio.file.*;
import java.security.*;
/*
将某一目录下所有文件重命名为16位MD5值，后缀名保持不变。

 */
public class MD5Utils {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
//        String directoryPath = "E:\\0919神农百草中医药素材\\药材视频"; // 替换为你的目录路径
        String directoryPath = "C:\\Users\\Huibing\\Desktop\\0920拍摄\\0920拍摄\\文化馆——中医文化";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String md5 = calculateMD5(file);
                    String newFileName = md5 + "." + getFileExtension(file);
                    File newFile = new File(directoryPath + File.separator + newFileName);
                    Files.move(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    private static String calculateMD5(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try (InputStream is = Files.newInputStream(file.toPath());
             DigestInputStream dis = new DigestInputStream(is, md)) {
            byte[] buffer = new byte[4096];
            while (dis.read(buffer) != -1) {
                // 读取文件，更新md5 hash
            }
        }
        byte[] md5Bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : md5Bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString().substring(8, 24); // 获取MD5的16位值
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}