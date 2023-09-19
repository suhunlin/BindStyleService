package com.suhun.bindstyleservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private MyService myService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        private MyService myService;
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(tag, "-----#####MainActivity onServiceConnected#####-----");
            MyService.LocalBinder binder = (MyService.LocalBinder)service;
            myService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(tag, "-----#####MainActivity onServiceDisconnected#####-----");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "-----#####MainActivity onCreate#####-----");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "-----#####MainActivity onStart#####-----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "-----#####MainActivity onRestart#####-----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "-----#####MainActivity onResume#####-----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "-----#####MainActivity onPause#####-----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "-----#####MainActivity onStop#####-----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "-----#####MainActivity onDestroy#####-----");
    }

    public void startBinderService(View view){
        Log.d(tag, "-----#####MainActivity startBinderService#####-----");
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void stopBinderService(View view){
        Log.d(tag, "-----#####MainActivity stopBinderService#####-----");
        unbindService(serviceConnection);
    }
}