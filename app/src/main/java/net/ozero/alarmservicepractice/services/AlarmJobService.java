package net.ozero.alarmservicepractice.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.support.v4.app.NotificationCompat;

import net.ozero.alarmservicepractice.R;

public class AlarmJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {

        sendNotification(params);

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }

    private void sendNotification(JobParameters params) {

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Title")
                        .setContentText("Notification text");

        Notification notification = builder.build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(1, notification);
            jobFinished(params, false);
        } else {

            jobFinished(params, true);
        }
    }
}
