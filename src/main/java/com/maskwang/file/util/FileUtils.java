package com.maskwang.file.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 文件操作工具类
 * Created by Maskwang on 2019/12/4.
 */
public class FileUtils {

    /**
     * 获取文件后缀
     *
     * @param file 文件
     * @return 返回文件后缀
     */
    public static String getSuffix(File file) {
        String fileName = file.getName();
        if (fileName != null && !fileName.trim().equals("")) {
            String[] strings = fileName.split("\\.");
            if (strings.length > 1) {
                return fileName.split("\\.")[1];
            }
        }
        return null;
    }

    /**
     * 获取 BufferedReader
     *
     * @param file 文件
     * @return 返回{@code BufferedReader}
     */
    public static BufferedReader getBufferedReader(File file) {
        BufferedReader bufferedReader = null;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    public static boolean isBlankLine(String line) {
        return line.equals("");
    }

    public static boolean isSingleCommentLine(String s, String commentStart) {
        return s.startsWith(commentStart);
    }

    public static boolean isMultipleCommentLine(String s, String commentStart) {
        return s.startsWith(commentStart);
    }

    public static boolean isMultipleCommentEnd(String s, String commentEnd) {
        return s.endsWith(commentEnd);
    }
}
