package com.stomhong.aidldemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button mStartBtn;
    private boolean mBound;
    private Messenger mMessenger;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMessenger = new Messenger(service);
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mMessenger = null;
            mBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindService(new Intent(MainActivity.this, VideoService.class),mServiceConnection, BIND_AUTO_CREATE);

        mStartBtn = findViewById(R.id.btn_start);
        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,VideoActivity.class));
                sayHello(v);

            }
        });
    }



    public void sayHello(View v){
        if(!mBound){
            return;
        }
        Message msg = Message.obtain(null, 0 , 0, 0);
        try {
            mMessenger.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
