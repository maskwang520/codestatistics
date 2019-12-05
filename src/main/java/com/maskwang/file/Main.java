package com.maskwang.file;

import com.maskwang.file.type.CodeCount;
import com.maskwang.file.util.FileTypeEnum;

import java.io.File;

/**
 * Created by Maskwang on 2019/12/4.
 */
public class Main {

    public static long blankNum;
    public static long codeNum;
    public static long commentNum;

    public static void main(String[] args) {
        //这里修改Maven项目的地址
        File file = new File("E:\\gitrepository\\codestatistics");
        traverseFolder(file);
        System.out.println("---------------------------------");
        System.out.println("blankCount: " + blankNum);
        System.out.println("codeCount: " + codeNum);
        System.out.println("commentCount: " + commentNum);
        System.out.println("---------------------------------");
    }

    /**
     * 遍历目录
     * @param file
     */
    public static void traverseFolder(File file) {
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        traverseFolder(file2);
                    } else {
                        startCodeCount(file2);
                    }
                }
            }
        } else {
            throw new RuntimeException("this path does not exist");
        }
    }

    /**
     * 开始统计代码
     * @param file
     */
    public static void startCodeCount(File file) {
        for (FileTypeEnum fileTypeEnum : FileTypeEnum.values()) {
            CodeCount codeCount = fileTypeEnum.getConcreteCodeCount(file);
            if (codeCount != null) {
                codeCount.statisticalCode(file);
                blankNum += codeCount.getResult().getBlankCount();
                codeNum += codeCount.getResult().getCodeCount();
                commentNum += codeCount.getResult().getCommentCount();
            }
        }
    }


}
