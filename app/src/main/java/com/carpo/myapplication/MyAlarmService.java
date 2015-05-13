package com.carpo.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;


public class MyAlarmService extends Service {


    @Override

    public void onCreate() {

// TODO Auto-generated method stub
        //llamar al metodo para crear la notificación
        createNotification(this, "Times UP", "Hora de tomar la pastilla", "Alert");




    }
//Aquí se intenta hacer la notificacion
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

        mNotificationManager.notify(1, mBuilder.build());

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] patron = {0,500,110,500,110,450,110,200,110,170,40,450,110,200,110,170,40,500};
        v.vibrate(patron, -1);


        this.stopSelf();

    }



    @Override

    public IBinder onBind(Intent intent) {

// TODO Auto-generated method stub

        Toast.makeText(this, "MyAlarmService.onBind()", Toast.LENGTH_LONG).show();

        return null;

    }



    @Override

    public void onDestroy() {

// TODO Auto-generated method stub

        super.onDestroy();

        Toast.makeText(this, "MyAlarmService.onDestroy()", Toast.LENGTH_LONG).show();

    }



    @Override

    public void onStart(Intent intent, int startId) {

// TODO Auto-generated method stub

        super.onStart(intent, startId);

        //Toast.makeText(this, "MyAlarmService.onStart()", Toast.LENGTH_LONG).show();

    }



    @Override

    public boolean onUnbind(Intent intent) {

// TODO Auto-generated method stub

        //Toast.makeText(this, "MyAlarmService.onUnbind()", Toast.LENGTH_LONG).show();

        return super.onUnbind(intent);

    }



}
