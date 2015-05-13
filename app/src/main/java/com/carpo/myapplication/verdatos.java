package com.carpo.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Carlos Gacia on 01/05/2015.
 */


public class verdatos extends ActionBarActivity implements View.OnClickListener{

    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verdatos);

        View bted = findViewById(R.id.btedit);
        bted.setOnClickListener(this);

        View btB = findViewById(R.id.btBorrar);
        btB.setOnClickListener(this);

        View btS = findViewById(R.id.btSalir);
        btS.setOnClickListener(this);

        dbManager d = new dbManager(this);

        Integer id = getIntent().getExtras().getInt("ID");


        String naviso = d.getNombreAByID(id);

        Toast.makeText(this, "Esta viendo el aviso " + naviso, Toast.LENGTH_SHORT).show();

        cursor = d.getDatos(id);
        if (cursor.moveToFirst()) {

            do {
                String aviso, medi, tipos, dosis, freq, alarma, desbloqueo;
                aviso = cursor.getString(1);
                medi = cursor.getString(2);
                tipos = cursor.getString(3);
                dosis = cursor.getString(4);
                freq = cursor.getString(5);
                alarma = cursor.getString(6);
                desbloqueo = cursor.getString(7);

                TextView av = (TextView) findViewById(R.id.av);
                av.setText(aviso);

                TextView me = (TextView) findViewById(R.id.nmed);
                me.setText(medi);

                TextView tip = (TextView) findViewById(R.id.tipos);
                tip.setText(tipos);

                TextView dsis = (TextView) findViewById(R.id.dosis);
                dsis.setText(dosis);

                TextView frec = (TextView) findViewById(R.id.frecuencia);
                frec.setText(freq);

                TextView al = (TextView) findViewById(R.id.alarma);
                al.setText(alarma);

                TextView desb = (TextView) findViewById(R.id.desbloqueo);
                desb.setText(desbloqueo);

            }while (cursor.moveToNext());
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId()== findViewById(R.id.btedit).getId()){
            Integer id = getIntent().getExtras().getInt("ID");
            Intent a = new Intent(this, editar.class);
            Bundle b = new Bundle();
            b.putInt("ID", id);
            a.putExtras(b);
            startActivity(a);
            finish();
        }
        if (v.getId()== findViewById(R.id.btBorrar).getId()){
            dbManager d = new dbManager(this);
            Integer id = getIntent().getExtras().getInt("ID");
            String naviso = d.getNombreAByID(id);
            d.eliminar(id);
            Toast.makeText(this,"Se ha eliminado el aviso" + naviso , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        if (v.getId()== findViewById(R.id.btSalir).getId()){
            Intent s = new Intent(this,MainActivity.class);
            startActivity(s);
            finish();
        }

    }

}

