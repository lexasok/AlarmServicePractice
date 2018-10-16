package net.ozero.alarmservicepractice.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class AlarmIntentService extends IntentService {


    public AlarmIntentService() {
        super("AlarmIntentServiceAlarmPracticeApp");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
