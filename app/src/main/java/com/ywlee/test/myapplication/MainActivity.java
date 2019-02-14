package com.ywlee.test.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


/**
 * 노티피케이션 테스트 액티비티
 *
 * @author YWLee
 * 2019.02.13
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtnNoti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnNoti = findViewById(R.id.btn_noti);
        mBtnNoti.setOnClickListener((v) -> {
            createNoti_V3();
        });
    }

    /**
     * 노티피케이션 생성 1
     * (최신버전 기기에서 안돌아감)
     * 
     */
    private void createNoti() {
        Resources res = getResources();

        //  Set Intent
        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.putExtra("id", 9999);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0,
                notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentTitle("제목임다")
                .setContentText("내용임다")
                .setTicker("한줄 메세지 임다")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.mipmap.ic_launcher_round))
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setCategory(Notification.CATEGORY_MESSAGE)
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setVisibility(Notification.VISIBILITY_PUBLIC);
        }

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1234, builder.build());
    }

    /**
     * 노티 연습 2
     * 노티는 뜨나 포어그라운드 상태에서 토스트처럼 화면에 노출이 안되고 상태바에 노티만 등록됨.
     */
    private void createNoti_V2() {
        NotificationManager notificationManager;
        PendingIntent intent;

        intent = PendingIntent.getActivity(this,
                    0,
                    new Intent(getApplicationContext(), MainActivity.class),
                    PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle("제목입니당")
                .setContentText("내용입니다.")
                .setTicker("한줄 내용 입니다.")
                .setAutoCancel(false)
                .setContentIntent(intent);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(9999, builder.build());
    }



    /**
     * 노티피케이션 생성 3
     *
     */
    private void createNoti_V3() {
        Resources res = getResources();

        //  Set Intent
        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.putExtra("id", 9999);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0,
                notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "jestina");

        builder.setContentTitle("제목임다")
                .setContentText("내용임다")
                .setTicker("한줄 메세지 임다")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.mipmap.ic_launcher_round))
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setCategory(Notification.CATEGORY_MESSAGE)
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setVisibility(Notification.VISIBILITY_PUBLIC);
        }

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1234, builder.build());
    }
}
