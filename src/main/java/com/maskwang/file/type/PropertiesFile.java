package com.maskwang.file.type;

import com.maskwang.file.constant.FileConstant;
import com.maskwang.file.constant.SignConstant;
import com.maskwang.file.result.Result;
import com.maskwang.file.util.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Properties文件代码统计
 * Created by Maskwang on 2019/12/4.
 */
@Slf4j
public class PropertiesFile implements CodeCount {

    private static Result result = new Result();

    @Override
    public boolean isSupport(File file) {
        return FileConstant.PROPERTIES_FILE_SUFFIX.equals(FileUtils.getSuffix(file)) || FileConstant.YAML_FILE_SUFFIX.equals(FileUtils.getSuffix(file)) ? true : false;
    }

    @Override
    public void statisticalCode(File file) {
        try {
            BufferedReader bufferedReader = FileUtils.getBufferedReader(file);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String line = str.trim();
                // #注释统计
                if (FileUtils.isSingleCommentLine(line, SignConstant.JAVA_SINGLE_COMMENT_START)) {
                    result.increaseCommentCount();
                    continue;
                }

                //空行统计
                if (FileUtils.isBlankLine(line)) {
                    result.increaseBlankCount();
                    continue;
                }

                //代码行统计
                result.increaseCodeCount();
            }
        } catch (IOException e) {
            log.error("cannot open file {}", e);
        }
    }

    @Override
    public Result getResult() {
        return result;
    }
}
