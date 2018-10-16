package net.ozero.alarmservicepractice.services;

import android.app.IntentService;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import net.ozero.alarmservicepractice.MainActivity;

public class AlarmIntentService extends IntentService {


    public AlarmIntentService() {
        super("AlarmIntentServiceAlarmPracticeApp");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        long timeMillis = intent.getLongExtra(MainActivity.EXTRA_KEY_TIME, 1000);
        scheduleJob(timeMillis);
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

    private void scheduleJob(long timeMillis) {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        JobInfo job =
                new JobInfo.Builder(1, new ComponentName(this, AlarmJobService.class))
                        .setMinimumLatency(timeMillis)
                        .setOverrideDeadline(timeMillis)
                        .setBackoffCriteria(5*1000, JobInfo.BACKOFF_POLICY_LINEAR)
                        .setPersisted(true)
                        .build();

        if (jobScheduler != null) {
            jobScheduler.schedule(job);
            Log.i(getClass().getName(), "job set");
        } else {
            Log.i(getClass().getName(), "scheduler = null!");
        }
    }
}
