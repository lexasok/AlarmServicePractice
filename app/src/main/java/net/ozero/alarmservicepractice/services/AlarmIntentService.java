package net.ozero.alarmservicepractice.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class AlarmIntentService extends IntentService {


    public AlarmIntentService() {
        super("AlarmIntentServiceAlarmPracticeApp");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {



    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {

        Log.i(getClass().getName(), "onTaskRemoved");

        super.onTaskRemoved(rootIntent);
    }

    @Override
    public void onDestroy() {

        Log.i(getClass().getName(), "onDestroy");

        super.onDestroy();
    }
}
