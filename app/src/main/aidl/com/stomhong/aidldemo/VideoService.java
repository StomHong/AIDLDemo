package com.stomhong.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

public class VideoService extends Service {

    private IBinder mBinder;


    public VideoService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
       return new VideoBinder();
    }

    class VideoBinder extends IVideoAidlInterface.Stub{


        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }
    }

}
