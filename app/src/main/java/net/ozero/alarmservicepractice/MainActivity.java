package net.ozero.alarmservicepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.ozero.alarmservicepractice.services.AlarmIntentService;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_TIME = "time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void set10secButtonClicked(View view) {

        setAlarm(10*1000);
    }

    public void set1minButtonClicked(View view) {

        setAlarm(60*1000);
    }

    public void set5minButtonClicked(View view) {

        setAlarm(5*60*1000);
    }

    private void setAlarm(long timeMillis) {

        Intent intent = new Intent(this, AlarmIntentService.class);
        intent.putExtra(EXTRA_KEY_TIME, timeMillis);
        startService(intent);
    }
}
