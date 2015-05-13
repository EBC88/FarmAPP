package com.carpo.myapplication;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.ArrayList;

import static com.carpo.myapplication.R.layout.activity_main;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

// Prueba..
    private Cursor c;



    public MainActivity() {

    }

    NotificationManager notificationManager;
    boolean isNotificAvtive = false;
    int notifID = 22;
    Button show, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        View boton = findViewById(R.id.btagregar);
        boton.setOnClickListener(this);

        View btExit = findViewById(R.id.button6);
        btExit.setOnClickListener(this);

        show = (Button) findViewById(R.id.button);
        stop = (Button) findViewById(R.id.button2);



        // agregar botones por aviso en la db
        dbManager manag = new dbManager(this);
        ArrayList<String> IDS = new ArrayList<>();
        c = manag.cargarIDs();
        if (c.moveToFirst()){
            do {
                IDS.add(c.getString(0));
            }while (c.moveToNext());

        }
        c.close();

        for (int i=0; i < IDS.size(); ++i){
            ViewGroup linearlayout = (ViewGroup) findViewById(R.id.Ll);
            Button bt = new Button(this);

            String nombreBt = manag.getNombreAByID(Integer.valueOf(IDS.get(i)));
                bt.setText(nombreBt);
                bt.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.FILL_PARENT,
                        RadioGroup.LayoutParams.WRAP_CONTENT));

            bt.setId(Integer.valueOf(IDS.get(i)));
                linearlayout.addView(bt);
                bt.setOnClickListener(this);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==findViewById(R.id.btagregar).getId()){

            Intent i=new Intent(this, nuevactividad.class);
            startActivity(i);
            finish();


            }
        switch (v.getId()){
            case 1 :
                       Intent a = new Intent(this, verdatos.class);
                        Bundle b = new Bundle();
                        b.putInt("ID", v.getId());
                        a.putExtras(b);
                startActivity(a);
                finish();
                break;
            case 2 :
                Intent aa = new Intent(this, verdatos.class);
                Bundle bb = new Bundle();
                bb.putInt("ID", v.getId());
                aa.putExtras(bb);
                startActivity(aa);
                finish();
                break;
            case 3 :
                Intent ab = new Intent(this, verdatos.class);
                Bundle bc = new Bundle();
                bc.putInt("ID", v.getId());
                ab.putExtras(bc);
                startActivity(ab);
                finish();
                break;
            case 4 :
                Intent abc = new Intent(this, verdatos.class);
                Bundle bcd = new Bundle();
                bcd.putInt("ID", v.getId());
                abc.putExtras(bcd);
                startActivity(abc);
                finish();
                break;
            case 5 :
                Intent a1 = new Intent(this, verdatos.class);
                Bundle b1 = new Bundle();
                b1.putInt("ID", v.getId());
                a1.putExtras(b1);
                startActivity(a1);
                finish();
                break;
            case 6 :
                Intent a2 = new Intent(this, verdatos.class);
                Bundle b2 = new Bundle();
                b2.putInt("ID", v.getId());
                a2.putExtras(b2);
                startActivity(a2);
                finish();
                break;
            case 7 :
                Intent a3 = new Intent(this, verdatos.class);
                Bundle b3 = new Bundle();
                b3.putInt("ID", v.getId());
                a3.putExtras(b3);
                startActivity(a3);
                finish();
                break;
            case 8 :
                Intent a4 = new Intent(this, verdatos.class);
                Bundle b4 = new Bundle();
                b4.putInt("ID", v.getId());
                a4.putExtras(b4);
                startActivity(a4);
                finish();
                break;
            case 9 :
                Intent a5 = new Intent(this, verdatos.class);
                Bundle b5 = new Bundle();
                b5.putInt("ID", v.getId());
                a5.putExtras(b5);
                startActivity(a5);
                finish();
                break;
            case 10 :
                Intent a6 = new Intent(this, verdatos.class);
                Bundle b6 = new Bundle();
                b6.putInt("ID", v.getId());
                a6.putExtras(b6);
                startActivity(a6);
                finish();
                break;
            case 11 :
                Intent a7 = new Intent(this, verdatos.class);
                Bundle b7 = new Bundle();
                b7.putInt("ID", v.getId());
                a7.putExtras(b7);
                startActivity(a7);
                finish();
                break;
            case 12 :
                Intent a8 = new Intent(this, verdatos.class);
                Bundle b8 = new Bundle();
                b8.putInt("ID", v.getId());
                a8.putExtras(b8);
                startActivity(a8);
                finish();
                break;
            case 13 :
                Intent a9 = new Intent(this, verdatos.class);
                Bundle b9 = new Bundle();
                b9.putInt("ID", v.getId());
                a9.putExtras(b9);
                startActivity(a9);
                finish();
                break;
            case 14 :
                Intent a10 = new Intent(this, verdatos.class);
                Bundle b10 = new Bundle();
                b10.putInt("ID", v.getId());
                a10.putExtras(b10);
                startActivity(a10);
                finish();
                break;
            case 15 :
                Intent a11 = new Intent(this, verdatos.class);
                Bundle b11 = new Bundle();
                b11.putInt("ID", v.getId());
                a11.putExtras(b11);
                startActivity(a11);
                finish();
                break;

        }
        if (v.getId()==findViewById(R.id.button6).getId()){
            System.exit(0);
        }
        if (v.getId()==findViewById(R.id.button).getId()){
            this.showNotification();
        }
        if (v.getId()==findViewById(R.id.button2).getId()){
            this.stopNotification();
        }
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void showNotification() {
        NotificationCompat.Builder notificBuilder = new
                NotificationCompat.Builder(this)
                .setContentTitle("Recordatorio xx")
                .setContentText("Tomar pastilla xx")
                .setTicker("Alert New Message");
        Intent masInfo = new Intent(this, MoreInfo.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);

        taskStackBuilder.addParentStack(MoreInfo.class);

        taskStackBuilder.addNextIntent(masInfo);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);

        notificBuilder.setContentIntent(pendingIntent);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notifID, notificBuilder.build());

        isNotificAvtive = true;
    }

    public void stopNotification() {
        if (isNotificAvtive) {
            notificationManager.cancel(notifID);
        }
    }

    public  void setAlarm(View view){




    }

    }













