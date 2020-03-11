package com.windfallsheng.strategypatterncase.entity;

/**
 * @author lzsheng
 */
public class MsgTextBody {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MsgTextBody{" +
                "content='" + content + '\'' +
                '}';
    }
}
