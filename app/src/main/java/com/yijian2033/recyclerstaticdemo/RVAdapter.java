package com.yijian2033.recyclerstaticdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by yijian2033 on 2018/3/27.
 * Email : yijian2033@163.com
 * Description :
 */

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Bean> mList;

    public RVAdapter(Context context, ArrayList<Bean> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 10) {
            return new ContentHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
        }

        return new TitleHolder(LayoutInflater.from(context).inflate(R.layout.title, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Bean bean = mList.get(position);
        if (holder instanceof TitleHolder) {
            ((TitleHolder) holder).setData(bean);
        }
        if (holder instanceof ContentHolder) {
            ((ContentHolder) holder).setData(bean);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }

    public static class TitleHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public TitleHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            itemView.setTag(true);
        }

        public void setData(Bean bean) {
            textView.setText(bean.getName());
        }
    }

    public static class ContentHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public ContentHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.text);
            itemView.setTag(false);
        }

        public void setData(Bean bean) {
            tv.setText(bean.getName());
        }
    }

}
