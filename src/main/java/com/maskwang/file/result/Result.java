package com.maskwang.file.result;

import lombok.Data;

/**
 * 统计代码结果
 * Created by Maskwang on 2019/12/4.
 */
@Data
public class Result {

    /** 正常代码数量 **/
    private long codeCount;

    /** 注释数量**/
    private long commentCount;

    /** 空格行量 **/
    private long blankCount;

    public void increaseCodeCount() {
        codeCount++;
    }

    public void increaseCommentCount() {
        commentCount ++;
    }

    public void increaseBlankCount() {
        blankCount++;
    }
}
