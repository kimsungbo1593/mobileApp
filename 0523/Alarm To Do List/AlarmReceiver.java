package com.example.mission2todo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String task = intent.getStringExtra("task");

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "todo_channel";
        String channelName = "Todo 알림";

        // 1. 커스텀 소리 URI 준비
        Uri soundUri = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.alarm);

        // 2. NotificationChannel에 커스텀 소리 등록 (Oreo 이상)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
            channel.setSound(soundUri, null); // 커스텀 소리!
            notificationManager.createNotificationChannel(channel);
        }

        // 3. Notification에 소리 설정
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("할 일 알림")
                .setContentText(task)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSound(soundUri); // 명시적 소리

        int notificationId = task.hashCode(); // 또는 item.getId();
        notificationManager.notify(notificationId, builder.build());
    }
}