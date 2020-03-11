package com.windfallsheng.strategypatterncase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.windfallsheng.strategypatterncase.action.MsgHelper;
import com.windfallsheng.strategypatterncase.entity.MsgEntity;
import com.windfallsheng.strategypatterncase.util.TimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lzsheng
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";

    private int msgId;
    private int msgTextIndex;
    private int msgImgIndex;
    private int msgShareIndex;
    private Random r;
    private RecyclerView mRecyclerView;
    private MsgListAdapter mMsgListAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private List<MsgEntity> mMsgList;
    private TextView text, share, img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);
        text = findViewById(R.id.text);
        share = findViewById(R.id.share);
        img = findViewById(R.id.img);
        text.setOnClickListener(this);
        share.setOnClickListener(this);
        img.setOnClickListener(this);

        mLinearLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mMsgListAdapter = new MsgListAdapter(MainActivity.this);
        mMsgList = new ArrayList<>();
        mMsgListAdapter.setMsgList(mMsgList);
        mRecyclerView.setAdapter(mMsgListAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text: {
                String textJson = "{" +
                        "\"content\": \"这是第" + ++msgTextIndex + "条文本内容的消息\"" +
                        "}";
                MsgEntity msgEntity = buildMsgEntity(1, textJson);

                MsgEntity msg = MsgHelper.obtain().buildMsgObj(msgEntity);

                Log.d(TAG, "text:msg=" + msg.toString());
                addMsgAndRefresh(msg);
            }
            break;
            case R.id.share: {
                String shareJson = "{" +
                        "\"title\": \"这是第" + ++msgShareIndex + "条分享内容的消息\"," +
                        "\"desc\": \"这是我分享的内容，Just a little code farmer." +
                        "Just a little code farmer.Just a little code farmer.\"," +
                        "\"imgUrl\": \"我是\"" +
                        "}";
                MsgEntity msgEntity = buildMsgEntity(2, shareJson);

                MsgEntity msg = MsgHelper.obtain().buildMsgObj(msgEntity);

                Log.d(TAG, "share:msg=" + msg.toString());
                addMsgAndRefresh(msg);
            }
            break;
            case R.id.img: {
                String imgJson = "{" +
                        "\"desc\": \"这是第" + ++msgImgIndex + "条图片内容消息\"," +
                        "\"resUrl\": \"https://../../*.jpg\"," +
                        "\"type\": 1" +
                        "}";
                MsgEntity msgEntity = buildMsgEntity(3, imgJson);

                MsgEntity msg = MsgHelper.obtain().buildMsgObj(msgEntity);

                Log.d(TAG, "img:msg=" + msg.toString());
                addMsgAndRefresh(msg);
            }
            break;
            default:
                break;
        }
    }

    private void addMsgAndRefresh(MsgEntity msg) {
        mMsgList.add(msg);
        if (mMsgListAdapter != null) {
            mMsgListAdapter.notifyDataSetChanged();
        }
        if (mRecyclerView != null && mLinearLayoutManager != null) {
            int itemCount = mLinearLayoutManager.getItemCount();
            Log.d(TAG, "addMsgAndRefresh:itemCount=" + itemCount);
            mRecyclerView.scrollToPosition(itemCount - 1);
        }
    }

    /**
     * 模拟网络传输过来的不同类型的消息实例；
     *
     * @param json
     * @return
     */
    private MsgEntity buildMsgEntity(int msgType, String json) {
        if (r == null) {
            r = new Random();
        }
        int msgDirection = r.nextInt(2);
        Log.d(TAG, "msgDirection=" + msgDirection);
        String msgFrom;
        String msgto;
        if (msgDirection == 1) {
            // 发送的消息；
            msgFrom = "me";
            msgto = "friend";
        } else {
            // 接收的消息；
            msgFrom = "friend";
            msgto = "me";
        }
        return new MsgEntity(++msgId, msgType, json, null,
                msgFrom, msgto, msgDirection, 0, TimeUtils.getStrDate());
    }


}
