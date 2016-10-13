package com.cdh.sms.dataBase;

/**
 * Created by claudinei on 13/10/16.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    final static String TABLE_NAME_Locations = "locations";
    final static String _ID = "_id";
    final static String NOME = "nome";
    final static String LATITUDE = "latitude";
    final static String LONGITUDE = "longitude";
    final static String[] columnsLocation = { _ID, NOME, LATITUDE, LONGITUDE };

    final static String TABLE_NAME_Pedido = "pedido";
    final static String CPF = "CPF";
    final static String NUMERO = "numero";
    final static String TOKEN = "token";
    final static String[] columnsPedido = { _ID, NOME, NUMERO , TOKEN };


    /*Create table LOCATIONS*/
    final private static String CREATE_CMD =

            "CREATE TABLE locations (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME + " TEXT NOT NULL,"
                    + LATITUDE + " TEXT NOT NULL,"
                    + LONGITUDE + " TEXT NOT NULL)";

    /*Create table PEDIDO*/
    final private static String CREATE_CMD2 =

            "CREATE TABLE pedido (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME + " TEXT NOT NULL,"
                    + CPF + " TEXT NOT NULL,"
                    + NUMERO + " TEXT NOT NULL,"
                    + TOKEN + " TEXT NOT NULL)";

    final private static String INSERT = "INSERT INTO locations ("
            + NOME + ", "
            + LATITUDE + ", "
            + LONGITUDE + ") " +
            "VALUES ('minha_casa', -19.895171, -44.026986);";

    final private static String INSERT2 = "INSERT INTO locations ("
            + NOME + ", "
            + LATITUDE + ", "
            + LONGITUDE + ") " +
            "VALUES ('PUC Minas', -19.923639, -43.992525);";

    final private static String INSERT3 = "INSERT INTO locations ("
            + NOME + ", "
            + LATITUDE + ", "
            + LONGITUDE + ") " +
            "VALUES ('Mineirão', -19.866020, -43.971040);";

    final private static String NAME = "locations_db";
    final private static Integer VERSION = 1;
    final private Context mContext;

    public DatabaseOpenHelper(Context context) {
        super(context, NAME, null, VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CMD);
        db.execSQL(CREATE_CMD2);
        db.execSQL(INSERT);
        db.execSQL(INSERT2);
        db.execSQL(INSERT3);
        System.out.println("Criou");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // N/A
    }

    void deleteDatabase() {
        mContext.deleteDatabase(NAME);
    }


    public Cursor getLocations() {
        return this.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME_Locations,
                DatabaseOpenHelper.columnsLocation, null, new String[] {}, null, null,
                null);
    }
}
