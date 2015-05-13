package com.carpo.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by $Carlos $Garcia on 19/04/2015.
 */
public class dbManager {
    public static final String TABLE_NAME = "dbmed";
    public static final String CN_ID = "_id";
    public static final String CN_NAV = "naviso";
    public static final String CN_NMED = "nmed";
    public static final String CN_TIPOS = "tipos";
    public static final String CN_DOSIS = "dosis";
    public static final String CN_FREC = "frecs";
    public static final String CN_ALARM = "alarms";
    public static final String CN_DESB = "desbloqs";
    public static final String CN_HORA = "horas";
    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_NAV + " text not null,"
            + CN_NMED + " text not null,"
            + CN_TIPOS + " text not null,"
            + CN_DOSIS + " text not null,"
            + CN_FREC + " text not null,"
            + CN_ALARM + " text not null,"
            + CN_DESB + " text not null,"
            + CN_HORA + " text not null) ";

    private int id;
    private String aviso;
    private String med;
    private String tipos;
    private String dosis;
    private String frec;
    private String alar;
    private String desbl;
    private String avv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFrec() {
        return frec;
    }

    public void setFrec(String frec) {
        this.frec = frec;
    }

    public String getAlar() {
        return alar;
    }

    public void setAlar(String alar) {
        this.alar = alar;
    }

    public String getDesbl() {
        return desbl;
    }

    public void setDesbl(String desbl) {
        this.desbl = desbl;
    }

        public dbManager() {
        this.id = id;
        this.aviso = aviso;
        this.med = med;
        this.tipos = tipos;
        this.dosis = dosis;
        this.frec = frec;
        this.alar = alar;
        this.desbl = desbl;
        }

    private dbHelper helper;
    private SQLiteDatabase db;

        public dbManager(Context context) {
        helper = new dbHelper(context);
        db = helper.getWritableDatabase();

        }

        public ContentValues genVal(String nav, String nmed, String tipos, String dosis, String frecs, String alarms, String debloqs, String horas) {
        ContentValues valores = new ContentValues();
        valores.put(CN_NAV, nav);
        valores.put(CN_NMED, nmed);
        valores.put(CN_TIPOS, tipos);
        valores.put(CN_DOSIS, dosis);
        valores.put(CN_FREC, frecs);
        valores.put(CN_ALARM, alarms);
        valores.put(CN_DESB, debloqs);
        valores.put(CN_HORA,horas);
        return valores;
        }

        public void guardar(String nav, String nmed, String tipos, String dosis, String frecs, String alarms, String debloqs, String horas) {

        db.insert(TABLE_NAME, null, genVal(nav, nmed, tipos, dosis, frecs, alarms, debloqs, horas));

        }

    //contar cuantos datos hay en la DB
        public int getMedCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;

        }

    // Buscar avisos por ID

        public String getNombreAByID(int Id) {
        helper.getReadableDatabase();
        String selectQuery = "SELECT " +
                CN_ID + "," +
                CN_NAV +
                " FROM " + TABLE_NAME
                + " WHERE " +
                CN_ID + "=?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});

        if (cursor.moveToFirst()) {
            do {
                aviso = cursor.getString(1);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return aviso;

        }
        public Cursor getDatos(int Id) {
        helper.getReadableDatabase();
        String selectQuery = "SELECT " +
                CN_ID + "," +
                CN_NAV + "," +
                CN_NMED + "," +
                CN_TIPOS + "," +
                CN_DOSIS + "," +
                CN_FREC + "," +
                CN_ALARM + "," +
                CN_DESB + "," +
                CN_HORA +
                " FROM " + TABLE_NAME
                + " WHERE " +
                CN_ID + "=?";
        return db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});



        }
        public void update(String nav, String nmed, String tipos, String dosis, String frecs, String alarms, String debloqs, String horas) {
        db.update(TABLE_NAME, genVal(nav, nmed, tipos, dosis, frecs, alarms, debloqs, horas), CN_ID + "=?", new String[]{String.valueOf(id)});

        }

        public void eliminar(int id) {
        db.delete(TABLE_NAME, CN_ID + "=?", new String[]{String.valueOf(id)});

        }

        public Cursor cargarIDs(){
            String [] columna = new String []{CN_ID, CN_NAV, CN_NMED, CN_TIPOS, CN_DOSIS, CN_FREC, CN_ALARM, CN_DESB, CN_HORA};
           return db.query(TABLE_NAME, columna, null, null, null, null, null);


        }
    }





