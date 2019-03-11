package com.app.orange.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class ServiceTest extends Service {

    static public final String TAG = "ServiceTest";
    private TestInfo m_info = null;
    private final IServiceTestInferface.Stub m_binder = new IServiceTestInferface.Stub() {
        @Override
        public TestInfo getTestInfo() throws RemoteException {
            m_info.set_name("orange");
            m_info.set_score("100");

            return m_info;
        }

        @Override
        public void setTestInfo(TestInfo info) throws RemoteException {
            Log.d(TAG, "name:" + info.get_name() + " score:" + info.get_score());
            m_info.set_score(info.get_score());
            m_info.set_name(info.get_name());

            return;
        }

        @Override
        public boolean setValue(String key, String value) throws RemoteException {
            if(key.equals("name")) {
                m_info.set_name(value);
            } else if(key.equals("score")) {
                m_info.set_score(value);
            }

            return false;
        }

        @Override
        public String getValue(String key) throws RemoteException {
            if(key.equals("name")) {
                return m_info.get_name();
            } else if(key.equals("score")) {
                return m_info.get_score();
            }

            return null;
        }
    };

    public void onCreate() {
        super.onCreate();
        m_info = new TestInfo();
    }

    public IBinder onBind(Intent intent) {
        return m_binder;
    }
}