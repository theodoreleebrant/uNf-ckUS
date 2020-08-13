package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextClock;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public int counter = 120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.tick);

        TextClock textClock = findViewById(R.id.date);
        textClock.setFormat12Hour(null);

        final TextView counttime = findViewById(R.id.countdown);
        new CountDownTimer(Integer.MAX_VALUE, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counttime.setText(String.valueOf(counter));
                if (counter == 0) {
                    counter = 120;
                } else {
                    counter--;
                }
            }

            @Override
            public void onFinish() {
                counttime.setText("Finished");
            }
        }.start();


//        getWindow().setStatusBarColor(Color.parseColor("#20111111"));
//        getWindow().setNavigationBarColor(Color.parseColor("#20111111"));
//        TextClock textClock = findViewById(R.id.date);
//        textClock.setFormat12Hour(null);
//        textClock.setFormat24Hour("HH:mm:ss");

//        TextView y = findViewById(R.id.date);
//        while (true) {
//            setDate(y);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public void setDate(TextView view) {
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("H:m:s");
        String date = formatter.format(today) + "\n" + formatter2.format(today);
        view.setText(date);
    }
}