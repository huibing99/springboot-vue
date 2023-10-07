package com.vrtrain.springboot.utils;

import java.io.File;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.SQLException;
/*
将某一目录下所有文件信息插入数据库中。
 */
public class ItemUtils {
    public static void main(String[] args) {
        ItemUtils processor = new ItemUtils();
//        processor.processFiles("E:\\0919神农百草中医药素材\\cache\\data\\1");
        processor.processFiles("C:\\Users\\Huibing\\Desktop\\0920拍摄\\0920拍摄\\文化馆——中医文化");
    }
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vrtrain?serverTimezone=GMT%2b8";
    private static final String USER = "root";
    private static final String PASS = "1535786693";

    public void processFiles(String directoryPath) {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        if (files != null) {
            int roomIndex = 1;
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String hash = fileName.substring(0, fileName.lastIndexOf('.'));
                    int size = (int) (file.length() / 1024);
                    insertIntoDatabase(2, roomIndex, 1, hash, size, "1", 0);
                    roomIndex++;
                }
            }
        }
    }

    private void insertIntoDatabase(int roomId, int roomIndex, int type, String hash, int size, String name, int status) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO Item (room_id, room_index, type, hash, size, name, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomId);
            pstmt.setInt(2, roomIndex);
            pstmt.setInt(3, type);
            pstmt.setString(4, hash);
            pstmt.setInt(5, size);
            pstmt.setString(6, name);
            pstmt.setInt(7, status);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

