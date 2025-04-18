package com.example.notification;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.edit);
        createNotificationChannel();
    }

    String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Channel description");
            NotificationManager notificationManager = (NotificationManager)
                    getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void sendNotification() {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Egg Timer")
                .setContentText("계란 삶기가 완료되었습니다.")
                .setContentIntent(pendingIntent)
                .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bell));  // 알림음 설정


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build());
    }

    public void startTimer(View v) {
        String s = mEditText.getText().toString();
        int min, sec;

        try {
            min = Integer.parseInt(s.substring(0, 2));
            sec = Integer.parseInt(s.substring(3, 5));
        } catch (Exception e) {
            mEditText.setText("형식 오류: MM:SS");
            return;
        }

        int totalMillis = min * 60 * 1000 + sec * 1000;

        countDownTimer = new CountDownTimer(totalMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                int secondsLeft = (int) (millisUntilFinished / 1000);
                mEditText.setText(secondsLeft + "초");

                if (secondsLeft == 10) {
                    sendNotification(); // 10초 남았을 때 알림
                }
            }

            public void onFinish() {
                mEditText.setText("done!");
                sendNotification();
                showExtendDialog(); // 연장 여부 대화상자
            }
        };

        countDownTimer.start(); // 꼭 필요!

        new CountDownTimer(10000, 10000) {  // 10초 타이머
            @Override
            public void onTick(long millisUntilFinished) {
                int secondsLeft = (int) (millisUntilFinished / 1000);
                mEditText.setText(secondsLeft + "초");

                if (secondsLeft == 10) {
                    sendNotification(); // 10초 남았을 때 알림
                }
            }

            @Override
            public void onFinish() {
                // 알림음이 울리고 끝남
            }
        }.start();

        countDownTimer.start();
    }

    // 10초 연장 여부를 묻는 대화상자
    private void showExtendDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("타이머 종료")
                .setMessage("10초 더 연장할까요?")
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        extendTimer();
                    }
                })
                .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // 타이머 연장을 하지 않음
                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    private void extendTimer() {
        // 기존 타이머 중지
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        // 타이머 연장
        int currentTimeInSeconds = Integer.parseInt(mEditText.getText().toString().split("초")[0].trim());
        int newTimeInMillis = (currentTimeInSeconds + 10) * 1000;

        countDownTimer = new CountDownTimer(newTimeInMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                mEditText.setText("" + (int) (millisUntilFinished) / (1000) + "초");
            }

            public void onFinish() {
                mEditText.setText("done!");
                sendNotification();
            }
        };

        countDownTimer.start();
    }

}