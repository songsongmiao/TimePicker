package com.zu.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.icu.util.TimeZone;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zu.demo.timepicker.OnPickerListener;
import com.zu.demo.timepicker.TimePickerView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {

    private PopupWindow mPopWindow;
    private Dialog mDialog;

    private TextView tvTimeView;
    private TextView tvTimeStand;
    private final java.util.TimeZone GMT = new SimpleTimeZone(0, "GMT");
    private final java.util.TimeZone UTC = new SimpleTimeZone(0, "UTC");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTimeView = findViewById(R.id.main_time);
        tvTimeStand = findViewById(R.id.main_time_stand);


    }

    public void onLocalTime(View view)
    {
//        String currentTime =  TimeConverterUtil.utc2Local("2018-09-26 09:00:00.000 +08:00", "yyyy-MM-dd HH:mm:ss.SSS z", "yyyy-MM-dd HH:mm:ss.SSS");
        String currentTime =  TimeConverterUtil.utc2Local("2018-09-26 09:00:00 +08:00", "yyyy-MM-dd HH:mm:ss z", "yyyy-MM-dd HH:mm:ss");
        tvTimeView.setText(currentTime);

    }

    public void onRefresh(View view)
    {

        TimePickerView mView = new TimePickerView(MainActivity.this);
        mView.setDayAndHour();
        mView.setPickerListener(new OnPickerListener(){
            @Override
            public void onDimiss() {
                if(mPopWindow!= null)
                    mPopWindow.dismiss();

            }

            @Override
            public void onDate(String date) {
                if(mPopWindow!= null)
                    mPopWindow.dismiss();

                Log.i("MainActivity","date: "+ date);
            }
        });

        mPopWindow =  mView.onShowWindow(MainActivity.this,mView,view);

    }

    public void onLoad(View view)
    {
        TimePickerView mView = new TimePickerView(MainActivity.this);
        mView.setDayAndHour();
        mView.setPickerListener(new OnPickerListener(){
            @Override
            public void onDimiss() {
//                if(mPopWindow!= null)
//                    mPopWindow.dismiss();
                if(mDialog!= null)
                {
                    mDialog.dismiss();
                }
            }

            @Override
            public void onDate(String date) {
//                if(mPopWindow!= null)
//                    mPopWindow.dismiss();
                if(mDialog!= null)
                {
                    mDialog.dismiss();
                }
                Log.i("MainActivity","date: "+ date);
            }
        });

//        mPopWindow =  mView.onShowWindow(MainActivity.this,mView,view);
        mDialog = mView.onShowDialog(mView);
    }



}
