package com.android.server.orange;

import android.os.IGpioManager;
import android.content.Context;
import android.util.Log;

public class GpioManagerService extends IGpioManager.Stub {
	private static final String TAG = "GpioManagerService";
	private Context mContext = null;

	public GpioManagerService(Context context) {
		mContext = context;
	}

	public boolean setGPIODir(int gpioid, boolean dir) {
		Log.d(TAG, "setGPIODir...");

		return true;
	}

    public boolean getGPIODir(int gpioid) {
		Log.d(TAG, "getGPIODir...");

		return true;
    }

    public boolean setGPIOLevel(int gpioid, boolean level) {
		Log.d(TAG, "setGPIOLevel...");

		return true;
	}
}