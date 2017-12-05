package com.stomhong.aidldemo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by StomHong on 2017/12/5.
 */

public class MyApplication extends Application {
    public static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        int pid = android.os.Process.myPid();
        Log.d(TAG, "MyApplication onCreate");
        Log.d(TAG, "MyApplication pid is " + pid);

        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps != null && !runningApps.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
                if (procInfo.pid == pid) {
                    if (procInfo.processName.equals("com.stomhong.aidldemo")) {
                        Log.d(TAG, "process name is " + procInfo.processName);
                    } else if (procInfo.processName.equals("com.stomhong.aidldemo:remote")) {
                        Log.d(TAG, "process name is " + procInfo.processName);
                    }
                }
            }
        }
    }
}