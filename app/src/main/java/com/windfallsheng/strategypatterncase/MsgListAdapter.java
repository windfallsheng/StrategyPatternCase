package com.windfallsheng.strategypatterncase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.windfallsheng.strategypatterncase.entity.MsgEntity;
import com.windfallsheng.strategypatterncase.entity.MsgImgBody;
import com.windfallsheng.strategypatterncase.entity.MsgShareBody;
import com.windfallsheng.strategypatterncase.entity.MsgTextBody;

import java.util.List;

/**
 * @author lzsheng
 */
public class MsgListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<MsgEntity> mMsgList;

    public MsgListAdapter(Context context) {
        this.mContext = context;
    }

    public void setMsgList(List<MsgEntity> msgList) {
        mMsgList = msgList;
    }

    @Override
    public int getItemViewType(int position) {
        if (mMsgList == null || mMsgList.size() <= 0) {
            return 0;
        }
        MsgEntity msgEntity = mMsgList.get(position);
        int msgType = msgEntity.getMsgType();
        int msgDirection = msgEntity.getMsgDirection();
        switch (msgType) {
            case 1:
                if (msgDirection == 1) {
                    return 1;
                } else {
                    return 2;
                }
            case 2:
                if (msgDirection == 1) {
                    return 3;
                } else {
                    return 4;
                }
            case 3:
                if (msgDirection == 1) {
                    return 5;
                } else {
                    return 6;
                }
            default:
                return 0;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1: {
                HolderMsgTextSend holder = new HolderMsgTextSend(
                        LayoutInflater.from(mContext).inflate(R.layout.item_msg_text_send, parent, false));
                return holder;
            }
            case 2: {
                HolderMsgTextReceive holder = new HolderMsgTextReceive(
                        LayoutInflater.from(mContext).inflate(R.layout.item_msg_text_receive, parent, false));
                return holder;
            }
            case 3: {
                HolderMsgShareSend holder = new HolderMsgShareSend(
                        LayoutInflater.from(mContext).inflate(R.layout.item_msg_share_send, parent, false));
                return holder;
            }
            case 4: {
                HolderMsgShareReceive holder = new HolderMsgShareReceive(
                        LayoutInflater.from(mContext).inflate(R.layout.item_msg_share_receive, parent, false));
                return holder;
            }
            case 5: {
                HolderMsgImgSend holder = new HolderMsgImgSend(
                        LayoutInflater.from(mContext).inflate(R.layout.item_msg_img_send, parent, false));
                return holder;
            }
            case 6: {
                HolderMsgImgReceive holder = new HolderMsgImgReceive(
                        LayoutInflater.from(mContext).inflate(R.layout.item_msg_img_receive, parent, false));
                return holder;
            }
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (mMsgList == null || mMsgList.size() <= 0) {
            return;
        }
        int itemViewType = getItemViewType(position);
        MsgEntity msgEntity = mMsgList.get(position);
        switch (itemViewType) {
            case 1: {
                HolderMsgTextSend holder = (HolderMsgTextSend) viewHolder;
                MsgTextBody msgBody = (MsgTextBody) msgEntity.getMsgBody();
                String content = msgBody.getContent();
                holder.tvMsgContent.setText(content);
            }
            break;
            case 2: {
                HolderMsgTextReceive holder = (HolderMsgTextReceive) viewHolder;
                MsgTextBody msgBody = (MsgTextBody) msgEntity.getMsgBody();
                String content = msgBody.getContent();
                holder.tvNickName.setText(msgEntity.getMsgFrom());
                holder.tvMsgContent.setText(content);
            }
            break;
            case 3: {
                HolderMsgShareSend holder = (HolderMsgShareSend) viewHolder;
                MsgShareBody msgBody = (MsgShareBody) msgEntity.getMsgBody();
                String title = msgBody.getTitle();
                String desc = msgBody.getDesc();
                holder.tvTitle.setText(title);
                holder.tvDesc.setText(desc);
            }
            break;
            case 4: {
                HolderMsgShareReceive holder = (HolderMsgShareReceive) viewHolder;
                MsgShareBody msgBody = (MsgShareBody) msgEntity.getMsgBody();
                String title = msgBody.getTitle();
                String desc = msgBody.getDesc();
                holder.tvNickName.setText(msgEntity.getMsgFrom());
                holder.tvTitle.setText(title);
                holder.tvDesc.setText(desc);
            }
            break;
            case 5: {
                HolderMsgImgSend holder = (HolderMsgImgSend) viewHolder;
                MsgImgBody msgBody = (MsgImgBody) msgEntity.getMsgBody();
                String desc = msgBody.getDesc();
                holder.tvDesc.setText(desc);
            }
            break;
            case 6: {
                HolderMsgImgReceive holder = (HolderMsgImgReceive) viewHolder;
                MsgImgBody msgBody = (MsgImgBody) msgEntity.getMsgBody();
                String desc = msgBody.getDesc();
                holder.tvNickName.setText(msgEntity.getMsgFrom());
                holder.tvDesc.setText(desc);
            }
            break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (mMsgList != null && mMsgList.size() > 0) {
            return mMsgList.size();
        }
        return 0;
    }

    class HolderMsgTextSend extends RecyclerView.ViewHolder {

        TextView tvMsgContent;

        public HolderMsgTextSend(View itemView) {
            super(itemView);
            tvMsgContent = (TextView) itemView.findViewById(R.id.textview_message);
        }
    }

    class HolderMsgTextReceive extends RecyclerView.ViewHolder {

        TextView tvNickName;
        TextView tvMsgContent;

        public HolderMsgTextReceive(View itemView) {
            super(itemView);
            tvNickName = (TextView) itemView.findViewById(R.id.textview_nick_name);
            tvMsgContent = (TextView) itemView.findViewById(R.id.textview_message);
        }
    }

    class HolderMsgShareSend extends RecyclerView.ViewHolder {

        TextView tvMsgContent;
        TextView tvTitle;
        TextView tvDesc;

        public HolderMsgShareSend(View itemView) {
            super(itemView);
            tvMsgContent = (TextView) itemView.findViewById(R.id.textview_message);
            tvTitle = (TextView) itemView.findViewById(R.id.title);
            tvDesc = (TextView) itemView.findViewById(R.id.desc);
        }
    }

    class HolderMsgShareReceive extends RecyclerView.ViewHolder {

        TextView tvNickName;
        TextView tvTitle;
        TextView tvDesc;

        public HolderMsgShareReceive(View itemView) {
            super(itemView);
            tvNickName = (TextView) itemView.findViewById(R.id.textview_nick_name);
            tvTitle = (TextView) itemView.findViewById(R.id.title);
            tvDesc = (TextView) itemView.findViewById(R.id.desc);
        }
    }

    class HolderMsgImgSend extends RecyclerView.ViewHolder {

        TextView tvDesc;

        public HolderMsgImgSend(View itemView) {
            super(itemView);
            tvDesc = (TextView) itemView.findViewById(R.id.textview_message);
        }
    }

    class HolderMsgImgReceive extends RecyclerView.ViewHolder {

        TextView tvDesc;
        TextView tvNickName;

        public HolderMsgImgReceive(View itemView) {
            super(itemView);
            tvNickName = (TextView) itemView.findViewById(R.id.textview_nick_name);
            tvDesc = (TextView) itemView.findViewById(R.id.textview_message);
        }
    }


}
