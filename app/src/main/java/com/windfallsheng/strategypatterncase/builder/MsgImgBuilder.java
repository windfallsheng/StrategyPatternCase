package com.windfallsheng.strategypatterncase.builder;

import com.google.gson.Gson;
import com.windfallsheng.strategypatterncase.entity.MsgEntity;
import com.windfallsheng.strategypatterncase.entity.MsgImgBody;

/**
 * @author lzsheng
 * <p>
 * 在这里对不同的消息类型的处理业务只是简单的演示，实际情况要复杂；
 */
public class MsgImgBuilder extends BaseMsgBuider {

    @Override
    public MsgEntity buildMsgObj(MsgEntity msgEntity) {
        MsgImgBody msgImgBody = new Gson().fromJson(msgEntity.getMsgJson(), MsgImgBody.class);
        msgEntity.setMsgBody(msgImgBody);
        msgEntity.setMsgJson(null);
        return msgEntity;
    }

}
