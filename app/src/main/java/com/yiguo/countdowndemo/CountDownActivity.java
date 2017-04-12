package com.yiguo.countdowndemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CountDownActivity extends AppCompatActivity {

    private Button mAdd;
    private RecyclerView mCountDownRV;

    private List<CountDownInfo> mCountDownInfoList = new ArrayList<>();
    private CountDownAdapter mCountDownAdapter;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);

        mAdd = (Button) findViewById(R.id.btn_add);
        mCountDownRV = (RecyclerView) findViewById(R.id.list_count_down);
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownInfoList.add(new CountDownInfo(String.valueOf(i),30,(int) (System.currentTimeMillis() / 1000)));
                mCountDownAdapter.notifyDataSetChanged();
                i++;
            }
        });

        mCountDownAdapter = new CountDownAdapter(this,mCountDownInfoList);
        mCountDownRV.setLayoutManager(new LinearLayoutManager(this));
        mCountDownRV.setAdapter(mCountDownAdapter);

        CountdownTime.onTimeCountdownOverListener = new CountdownTime.OnTimeCountdownOverListener() {
            @Override
            public void onTimeCountdownOver(final String id) {
                Log.d("Blin QueueMangerOver", "回调了：" + id);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Iterator<CountDownInfo> iter = mCountDownInfoList.iterator();
                        while (iter.hasNext()) {
                            CountDownInfo countDownInfo = iter.next();
                            if (countDownInfo.getId().equals(id)) {
                                iter.remove();
                                mCountDownAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });

            }
        };
    }
}
