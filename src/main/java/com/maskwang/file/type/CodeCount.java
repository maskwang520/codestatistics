package com.maskwang.file.type;

import com.maskwang.file.result.Result;

import java.io.File;

/**
 * 统计3种类型的代码
 * Created by Maskwang on 2019/12/4.
 */

public interface CodeCount {

    boolean isSupport(File file);

    void statisticalCode(File file);

    Result getResult();
}
