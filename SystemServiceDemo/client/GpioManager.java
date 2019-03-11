package android.os;

import android.content.Context;
import android.util.Log;

public final class GpioManager {
	private final String TAG = "GpioManager";
	private Context mContext;
	private IGpioManager mService;

	public GpioManager(Context context, Handler handler) {
		mContext = context;
		mService = IGpioManager.Stub.asInterface(ServiceManager.getService("gpioOrange"));
	}

    public boolean setGPIODir(int gpioid, boolean dir) {
		if(mService != null) {
			try {
				return mService.setGPIODir(gpioid, dir);
			} catch(RemoteException e) {
				Log.d(TAG, "setGPIODir + gpioid:" + gpioid + " dir:" + dir + "failed");
			}
		}

		return false;
	}

    public boolean getGPIODir(int gpioid) {
		if(mService != null) {
			try {
				return mService.getGPIODir(gpioid);
			} catch(RemoteException e) {
				Log.d(TAG, "getGPIODir + gpioid:" + gpioid);
			}
		}

		return false;

	}

    public boolean setGPIOLevel(int gpioid, boolean level) {
		if(mService != null) {
			try {
				return mService.setGPIOLevel(gpioid, level);
			} catch(RemoteException e) {
				Log.d(TAG, "setGPIOLevel + gpioid:" + gpioid + " level:" + level + "failed");
			}
		}

		return false;

	}
}
