package com.stomhong.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.widget.Toast;

public class VideoService extends Service {

    private IBinder mBinder;


    public VideoService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
       return mMessenger.getBinder();
    }

    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Toast.makeText(getApplicationContext(), "hello, trampcr", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    Messenger mMessenger = new Messenger(new IncomingHandler());

}
