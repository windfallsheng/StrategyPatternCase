package com.windfallsheng.strategypatterncase.entity;

/**
 * @author lzsheng
 */
public class MsgImgBody {

    private String desc;
    private String resUrl;
    private int type;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MsgImgBody{" +
                "desc='" + desc + '\'' +
                ", resUrl='" + resUrl + '\'' +
                ", type=" + type +
                '}';
    }
}
