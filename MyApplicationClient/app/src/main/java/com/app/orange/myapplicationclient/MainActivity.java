package com.app.orange.myapplicationclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.app.orange.servicetest.IServiceTestInferface;
import com.app.orange.servicetest.TestInfo;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "helloworld";
    private IServiceTestInferface iServiceTestInferface = null;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iServiceTestInferface = IServiceTestInferface.Stub.asInterface(service);
            TestInfo info = new TestInfo("oranger", "1205");
            try {
                iServiceTestInferface.setTestInfo(info);

                Log.d(TAG, iServiceTestInferface.getValue("name"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setAction("com.app.orange.servicetest.ServiceTest");
        intent.setPackage("com.app.orange.servicetest");
        bindService(intent, connection, BIND_AUTO_CREATE);
    }
}
