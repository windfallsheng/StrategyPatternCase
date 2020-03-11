package com.windfallsheng.strategypatterncase.action;

import android.util.Log;

import com.windfallsheng.strategypatterncase.builder.BaseMsgBuider;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lzsheng
 * <p>
 * 这里的缓存策略可能根据业务需求处理；
 */
public class CacheService {

    private final String TAG = "CacheService";

    private ConcurrentHashMap CACHE = new ConcurrentHashMap();

    private static class SingletonHolder {
        static CacheService INSTANCE = new CacheService();
    }

    public static CacheService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void cacheObj(Object o) {
        String clazzName = o.getClass().getName();
        Log.d(TAG, "method:cacheObj#clazzName=" + clazzName);
        CACHE.put(clazzName, o);
    }

    public Object getObj(Class<?> clazz) {
        String name = clazz.getName();
        Object obj = CACHE.get(name);
        Log.d(TAG, "method:getObj#obj=" + obj);
        return obj;
    }

    public Object getMsgCacheObj(Class<?> clazz) {
        String clazzName = clazz.getName();
        Log.d(TAG, "method:getMsgCacheObj#clazzName=" + clazzName);
        Object obj = CACHE.get(clazzName);
        Log.d(TAG, "method:getMsgCacheObj#CACHE#obj=" + obj);
        if (obj != null) {
            // 获取到实例后，就是要使用当前实例，所以将重置对象所有属性；
            // 同时flag=false时，当前实例也就不能同时被其它调用，只能等当前实例的工作完成，才能重用当前对象；
            if (obj instanceof BaseMsgBuider) {
                ((BaseMsgBuider) obj).recycle();
            } else if (obj instanceof MsgHelper) {
                ((MsgHelper) obj).recycle();
            }
        } else {
            try {
                obj = clazz.newInstance();
                cacheObj(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "method:getMsgCacheObj#newInstance#obj=" + obj);
        }
        return obj;
    }

}
