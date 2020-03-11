package com.windfallsheng.strategypatterncase.entity;

/**
 * @author lzsheng
 */
public class MsgShareBody {

    private String imgUrl;
    private String title;
    private String desc;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "MsgShareBody{" +
                "title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
