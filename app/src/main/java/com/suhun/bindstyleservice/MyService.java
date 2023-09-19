package com.suhun.bindstyleservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private String tag = MyService.class.getSimpleName();
    private Binder mbinder = new LocalService();
    public boolean isBinder = false;

    public class LocalService extends Binder{ //新增內部類別
        MyService getService(){//新增名稱為getService的方法，功能為回傳外部類別實體
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        Log.d(tag, "-----@@@@@MyService onCreate@@@@@-----");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(tag, "-----@@@@@onStartCommand @@@@@-----");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(tag, "-----@@@@@MyService onDestroy@@@@@-----");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(tag, "-----@@@@@MyService onBind@@@@@-----");
        isBinder = true;
        return mbinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(tag, "-----@@@@@MyService onUnbind@@@@@-----");
        isBinder = false;
        return super.onUnbind(intent);
    }

}