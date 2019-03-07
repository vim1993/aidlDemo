package com.app.orange.servicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Log.d(ServiceTest.TAG, "recv BOOT_COMPLETED broadcast");
            Intent intent1 = new Intent(context, ServiceTest.class);
            context.startService(intent1);
        }
    }
}
