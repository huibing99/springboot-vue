package com.vrtrain.springboot.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompressUtils {
    public void compressVideos(String sourceDirectory, String targetDirectory) {
        File folder = new File(sourceDirectory);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".MP4")) {
                    String targetFile = targetDirectory + "/" + file.getName();
                    compressVideo(file.getAbsolutePath(), targetFile);
                }
            }
        }
    }

    private void compressVideo(String sourceFile, String targetFile) {
        String command = "ffmpeg -i \"" + sourceFile + "\" -vcodec libx264 -crf 23 \"" + targetFile + "\"";
        System.out.println(command);
//        ProcessBuilder processBuilder = new ProcessBuilder("ffmpeg", "-i", sourceFile, "-vcodec", "libx264", "-crf", "23", targetFile);
//        try {
//            Process process = processBuilder.start();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public static void main(String[] args) {
        CompressUtils compressor = new CompressUtils();
        compressor.compressVideos("E:\\0919神农百草中医药素材\\cache\\data\\1", "E:\\0919神农百草中医药素材\\cache\\data\\1\\compressed");
    }
}