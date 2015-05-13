package com.carpo.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Carlos Gacia on 03/05/2015.
 */
public class AlerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

    createNotification(context, "Times UP", "Hora de tomar la pastilla", "Alert");

    }

    public void createNotification(Context context, String msg, String msgText, String msgAlert){

        PendingIntent notificInent = PendingIntent.getActivity(context, 0,
                new Intent(context, nuevactividad.class), 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setContentTitle(msg)
                .setTicker(msgAlert)
                .setContentText(msgText)
                .setSmallIcon(R.drawable.warning);

        mBuilder.setContentIntent(notificInent);

        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);

        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1,mBuilder.build());
    }
}

