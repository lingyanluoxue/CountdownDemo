package com.yiguo.countdowndemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhanghongmei on 2017/4/12.
 */

public class CountDownAdapter extends RecyclerView.Adapter<CountDownAdapter.ViewHolder> {
    private Context context;
    private List<CountDownInfo> countDownInfoList;
    private LayoutInflater inflater;

    public CountDownAdapter(Context context, List<CountDownInfo> countDownInfoList) {
        this.context = context;
        this.countDownInfoList = countDownInfoList;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(inflater.inflate(R.layout.item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CountDownInfo countDownInfo = countDownInfoList.get(position);
        Log.d("tag","countDownTime:"+(countDownInfo.getCountDownTime() - ((int) (System.currentTimeMillis() / 1000) - countDownInfo.getCurrentAddTime())));
        holder.mCountdownTime.setCountdownTime(countDownInfo.getCountDownTime() - ((int) (System.currentTimeMillis() / 1000) - countDownInfo.getCurrentAddTime()), countDownInfo.getId());
        holder.mTotalTime.setText("第" + countDownInfo.getId() + "条:");
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return countDownInfoList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public CountdownView mCountdownTime;
        public TextView mTotalTime;

        public ViewHolder(View itemView) {
            super(itemView);
            mCountdownTime = (CountdownView) itemView.findViewById(R.id.countdownView);
            mTotalTime = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
