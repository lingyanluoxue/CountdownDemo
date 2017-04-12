package com.yiguo.countdowndemo;

/**
 * Created by zhanghongmei on 2017/4/12.
 */

public class CountDownInfo {
    private String id;
    private int countDownTime;
    private int currentAddTime;

    public CountDownInfo(String id, int countDownTime, int currentAddTime) {
        this.id = id;
        this.countDownTime = countDownTime;
        this.currentAddTime = currentAddTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCountDownTime() {
        return countDownTime;
    }

    public void setCountDownTime(int countDownTime) {
        this.countDownTime = countDownTime;
    }

    public int getCurrentAddTime() {
        return currentAddTime;
    }

    public void setCurrentAddTime(int currentAddTime) {
        this.currentAddTime = currentAddTime;
    }
}
