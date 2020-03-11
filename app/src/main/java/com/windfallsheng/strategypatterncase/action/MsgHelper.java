package com.windfallsheng.strategypatterncase.action;

import android.util.Log;

import com.windfallsheng.strategypatterncase.builder.BaseMsgBuider;
import com.windfallsheng.strategypatterncase.builder.IMsgBuilder;
import com.windfallsheng.strategypatterncase.builder.MsgShareBuilder;
import com.windfallsheng.strategypatterncase.builder.MsgTextBuilder;
import com.windfallsheng.strategypatterncase.builder.MsgImgBuilder;
import com.windfallsheng.strategypatterncase.entity.MsgEntity;

/**
 * @author lzsheng
 */
public class MsgHelper {

    private final String TAG = "MsgHelper";

    /**
     * 当前实例的属性是否可重置，且实例可被重用，fase为不可用，true为可用；
     */
    public boolean flag;

    public MsgHelper() {
    }

    /**
     * 获取一个{@link MsgHelper}实例
     * <p>
     * 如果内存中的实例可被重用，则会返回内存中的实例对象，否则创建新实例；
     *
     * @return 返回一个可用的实例对象；
     */
    public static MsgHelper obtain() {
        MsgHelper msgHelper = (MsgHelper) CacheService.getInstance().getMsgCacheObj(MsgHelper.class);
//        MsgHelper msgHelper = new MsgHelper();
        return msgHelper;
    }

    public MsgHelper recycle() {
        this.flag = false;
        return this;
    }

    /**
     * 根据不同的消息类型，创建不同的消息构建者实例，
     * <p>
     * 如果这里的业务增多，也可以结合工厂方法模式处理不同对象的生成业务；
     *
     * @param msgType
     * @return
     */
    private IMsgBuilder initMsgBuilder(int msgType) {
        IMsgBuilder msgBuilder = null;
        switch (msgType) {
            case 1:
                msgBuilder = (IMsgBuilder) CacheService.getInstance().getMsgCacheObj(MsgTextBuilder.class);
//                msgBuilder = new MsgTextBuilder();
                break;
            case 2:
                msgBuilder = (IMsgBuilder) CacheService.getInstance().getMsgCacheObj(MsgShareBuilder.class);
//                msgBuilder = new MsgShareBuilder();
                break;
            case 3:
                msgBuilder = (IMsgBuilder) CacheService.getInstance().getMsgCacheObj(MsgImgBuilder.class);
//                msgBuilder = new MsgVoiceBuilder();
                break;
            default:
                break;
        }
        Log.d(TAG, "method:initMsgBuilder#return msgBuilder=" + msgBuilder);
        return msgBuilder;
    }

    /**
     * 创建消息构建者实例，并构建消息对象返回；
     *
     * @param msgEntity
     * @return
     */
    public MsgEntity buildMsgObj(MsgEntity msgEntity) {
        final IMsgBuilder msgBuilder = initMsgBuilder(msgEntity.getMsgType());
        if (msgBuilder == null) {
            return null;
        }
        final MsgEntity msgInfo = msgBuilder.buildMsgObj(msgEntity);
        synchronized (this) {
            // 当前实例对象任务已完成，将当前相关实例的的flag属性置为true，取可重用状态；
            ((BaseMsgBuider) msgBuilder).flag = true;
            flag = true;
            Log.d(TAG, "method:buildMsgObj#msgBuilder=" + msgBuilder);
            Log.d(TAG, "method:buildMsgObj#this=" + this);
            return msgInfo;
        }
    }

//    @Override
//    public String toString() {
//        return "MsgHelper{" +
//                "flag=" + flag +
//                '}';
//    }

}
