package com.windfallsheng.strategypatterncase.builder;


import com.windfallsheng.strategypatterncase.entity.MsgEntity;

/**
 * @author lzsheng
 * <p>
 * 构建不同类型消息实例的接口；
 */
public interface IMsgBuilder {

    public MsgEntity buildMsgObj(MsgEntity msgEntity);
}
