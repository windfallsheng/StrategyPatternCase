package com.windfallsheng.strategypatterncase.builder;

import com.google.gson.Gson;
import com.windfallsheng.strategypatterncase.entity.MsgEntity;
import com.windfallsheng.strategypatterncase.entity.MsgShareBody;

/**
 * @author lzsheng
 * <p>
 * 在这里对不同的消息类型的处理业务只是简单的演示，实际情况要复杂；
 */
public class MsgShareBuilder extends BaseMsgBuider {
    
    @Override
    public MsgEntity buildMsgObj(MsgEntity msgEntity) {
        MsgShareBody msgShareBody = new Gson().fromJson(msgEntity.getMsgJson(), MsgShareBody.class);
        msgEntity.setMsgBody(msgShareBody);
        msgEntity.setMsgJson(null);
        return msgEntity;
    }
}
