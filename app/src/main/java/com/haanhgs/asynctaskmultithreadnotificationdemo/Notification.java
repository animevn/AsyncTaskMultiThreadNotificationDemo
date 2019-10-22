package com.haanhgs.asynctaskmultithreadnotificationdemo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class Notification {

    private static final String CHANNEL_ID = "channel_id";
    private NotificationManager manager;

    private static void createChannel(){
        NotificationManager manager = (NotificationManager)
                        MyApplication.context().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "alert",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.enableVibration(true);
            channel.setLightColor(Color.RED);
            channel.setDescription("ALErt");
            if (manager != null) manager.createNotificationChannel(channel);
        }
    }

    private static PendingIntent createIntent(){
        Intent intent = new Intent(MyApplication.context(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        return PendingIntent.getActivity(MyApplication.context(), 1,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private static NotificationCompat.Builder createBuilder(String string){
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(MyApplication.context(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setContentTitle("AlERT");
        builder.setContentIntent(createIntent());
        builder.setContentText(string);
        builder.setAutoCancel(true);
        return  builder;
    }

    public static void createNotification(String string){
        NotificationManager manager = (NotificationManager)
                MyApplication.context().getSystemService(Context.NOTIFICATION_SERVICE);
        createChannel();
        if (!MyApplication.isAppVisible() && manager != null){
            manager.notify(1, createBuilder(string).build());
        }
    }
}
