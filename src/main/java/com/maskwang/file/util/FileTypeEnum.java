package com.maskwang.file.util;

import com.maskwang.file.type.CodeCount;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maskwang on 2019/12/4.
 */

public enum FileTypeEnum {

    JAVA_FILE("java", "com.maskwang.file.type.JavaFile"),
    XML_FILE("xml", "com.maskwang.file.type.XmlFile"),
    PROPERTIES_FILE("properties", "com.maskwang.file.type.PropertiesFile");

    private String fileType;
    private String className;
    private HashMap<String, CodeCount> map = new HashMap<String, CodeCount>();

    FileTypeEnum(String fileType, String className) {
        this.fileType = fileType;
        this.className = className;
        try {
            map.putIfAbsent(fileType, (CodeCount)Class.forName(className).newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据文件找到适配的代码统计类
     * @param file
     * @return
     */
    public CodeCount getConcreteCodeCount(File file) {
        for (Map.Entry<String, CodeCount> entry : map.entrySet()) {
            if (entry.getValue().isSupport(file)) {
                return entry.getValue();
            }
        }
        return null;
    }

}
