package com.windfallsheng.strategypatterncase.entity;

/**
 * @author lzsheng
 */
public class MsgEntity {

    private int msgId;
    private int msgType;
    private String msgJson;
    private Object msgBody;
    private String msgFrom;
    private String msgto;
    private int msgDirection;
    private int transferStatus;
    private String msgTime;

    public MsgEntity(int msgId, int msgType, String msgJson, Object msgBody, String msgFrom, String msgto, int msgDirection, int transferStatus, String msgTime) {
        this.msgId = msgId;
        this.msgType = msgType;
        this.msgJson = msgJson;
        this.msgBody = msgBody;
        this.msgFrom = msgFrom;
        this.msgto = msgto;
        this.msgDirection = msgDirection;
        this.transferStatus = transferStatus;
        this.msgTime = msgTime;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getMsgJson() {
        return msgJson;
    }

    public void setMsgJson(String msgJson) {
        this.msgJson = msgJson;
    }

    public String getMsgFrom() {
        return msgFrom;
    }

    public void setMsgFrom(String msgFrom) {
        this.msgFrom = msgFrom;
    }

    public Object getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(Object msgBody) {
        this.msgBody = msgBody;
    }

    public String getMsgto() {
        return msgto;
    }

    public void setMsgto(String msgto) {
        this.msgto = msgto;
    }

    public int getMsgDirection() {
        return msgDirection;
    }

    public void setMsgDirection(int msgDirection) {
        this.msgDirection = msgDirection;
    }

    public int getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(int transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    @Override
    public String toString() {
        return "MsgEntity{" +
                "msgId='" + msgId + '\'' +
                ", msgType=" + msgType +
                ", msgJson='" + msgJson + '\'' +
                ", msgFrom='" + msgFrom + '\'' +
                ", msgBody=" + msgBody +
                ", msgto='" + msgto + '\'' +
                ", msgDirection=" + msgDirection +
                ", transferStatus=" + transferStatus +
                ", msgTime=" + msgTime +
                '}';
    }
}
