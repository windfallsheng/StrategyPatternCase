package com.windfallsheng.strategypatterncase.builder;

/**
 * @author lzsheng
 * <p>
 * 增加一个简单的基类，用来处理共同的业务；
 */
public abstract class BaseMsgBuider implements IMsgBuilder {

    /**
     * 当前实例的属性是否可重置，且实例可被重用，fase为不可用，true为可用；
     */
    public boolean flag;

    public BaseMsgBuider recycle() {
        this.flag = false;
        return this;
    }

}
