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


    /*=============================================================================*/
    /*CARNE*/
    final static String TABLE_NAME_Carne= "carne";
    final static String NOME_CARNE = "nome";
    final static String CALORIAS_CARNE = "calorias";
    final static String[] columnsCarne= { _ID, NOME_CARNE, CALORIAS_CARNE };
    final private static String CREATE_TABLE_CARNE =

            "CREATE TABLE carne (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_CARNE + " TEXT NOT NULL,"
                    + CALORIAS_CARNE + " TEXT NOT NULL)";
    final private static String INSERT_CARNE1 = "INSERT INTO carne ("
            + NOME_CARNE + ", "
            + CALORIAS_CARNE + ") " +
            "VALUES ('Hambúrguer de Frango', '179');";
    final private static String INSERT_CARNE2 = "INSERT INTO carne ("
            + NOME_CARNE + ", "
            + CALORIAS_CARNE + ") " +
            "VALUES ('Hanbúrguer Bovino', '116');";
    final private static String INSERT_CARNE3 = "INSERT INTO carne ("
            + NOME_CARNE + ", "
            + CALORIAS_CARNE + ") " +
            "VALUES ('Hambúrguer de Porco', '196');";
    final private static String INSERT_CARNE4 = "INSERT INTO carne ("
            + NOME_CARNE + ", "
            + CALORIAS_CARNE + ") " +
            "VALUES ('Hambúrguer de Soja', '100');";
    final private static String INSERT_CARNE5 = "INSERT INTO carne ("
            + NOME_CARNE + ", "
            + CALORIAS_CARNE + ") " +
            "VALUES ('Presunto', '67.2');";
    /*=============================================================================*/


    /*=============================================================================*/
    /*QUEIJO*/
    final static String TABLE_NAME_Queijo = "queijo";
    final static String NOME_QUEIJO = "nome";
    final static String CALORIAS_QUEIJO = "calorias";
    final static String[] columnsQueijo= { _ID, NOME_QUEIJO, CALORIAS_QUEIJO };
    final private static String CREATE_TABLE_Queijo =

            "CREATE TABLE queijo (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_QUEIJO + " TEXT NOT NULL,"
                    + CALORIAS_QUEIJO + " TEXT NOT NULL)";

    final private static String INSERT_QUEIJO1 = "INSERT INTO queijo ("
            + NOME_QUEIJO + ", "
            + CALORIAS_QUEIJO + ") " +
            "VALUES ('cheddar', '107');";
    final private static String INSERT_QUEIJO2 = "INSERT INTO queijo ("
            + NOME_QUEIJO + ", "
            + CALORIAS_QUEIJO + ") " +
            "VALUES ('muçarela', '47');";
    final private static String INSERT_QUEIJO3 = "INSERT INTO queijo ("
            + NOME_QUEIJO + ", "
            + CALORIAS_QUEIJO + ") " +
            "VALUES ('ricota', '54');";
    /*=============================================================================*/

    /*=============================================================================*/
    /*PAO*/
    final static String TABLE_NAME_PAO= "pao";
    final static String NOME_PAO = "nome";
    final static String CALORIAS_PAO = "calorias";
    final static String[] columnsPAO= { _ID, NOME_PAO, CALORIAS_PAO };
    final private static String CREATE_TABLE_PAO =

            "CREATE TABLE PAO (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_PAO + " TEXT NOT NULL,"
                    + CALORIAS_PAO + " TEXT NOT NULL)";
    final private static String INSERT_PAO1 = "INSERT INTO PAO ("
            + NOME_PAO + ", "
            + CALORIAS_PAO + ") " +
            "VALUES ('Francês', '135');";
    final private static String INSERT_PAO2 = "INSERT INTO PAO ("
            + NOME_PAO + ", "
            + CALORIAS_PAO + ") " +
            "VALUES ('Integral', '261');";
    final private static String INSERT_PAO3 = "INSERT INTO PAO ("
            + NOME_PAO + ", "
            + CALORIAS_PAO + ") " +
            "VALUES ('Sírio', '147');";
    final private static String INSERT_PAO4 = "INSERT INTO PAO ("
            + NOME_PAO + ", "
            + CALORIAS_PAO + ") " +
            "VALUES ('Pão de Queijo', '68');";
    final private static String INSERT_PAO5 = "INSERT INTO PAO ("
            + NOME_PAO + ", "
            + CALORIAS_PAO + ") " +
            "VALUES ('Australiano', '140');";
    /*=============================================================================*/

    /*=============================================================================*/
    /*SALADA*/
    final static String TABLE_NAME_SALADA= "salada";
    final static String NOME_SALADA = "nome";
    final static String CALORIAS_SALADA = "calorias";
    final static String[] columnsSALADA= { _ID, NOME_SALADA, CALORIAS_SALADA };
    final private static String CREATE_TABLE_SALADA =

            "CREATE TABLE SALADA (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_SALADA + " TEXT NOT NULL,"
                    + CALORIAS_SALADA + " TEXT NOT NULL)";
    final private static String INSERT_SALADA1 = "INSERT INTO SALADA ("
            + NOME_SALADA + ", "
            + CALORIAS_SALADA + ") " +
            "VALUES ('Alface', '6');";
    final private static String INSERT_SALADA2 = "INSERT INTO SALADA ("
            + NOME_SALADA + ", "
            + CALORIAS_SALADA + ") " +
            "VALUES ('Tomate', '20');";
    final private static String INSERT_SALADA3 = "INSERT INTO SALADA ("
            + NOME_SALADA + ", "
            + CALORIAS_SALADA + ") " +
            "VALUES ('Pimentão', '14');";
    final private static String INSERT_SALADA4 = "INSERT INTO SALADA ("
            + NOME_SALADA + ", "
            + CALORIAS_SALADA + ") " +
            "VALUES ('Cebola', '31');";
    final private static String INSERT_SALADA5 = "INSERT INTO SALADA ("
            + NOME_SALADA + ", "
            + CALORIAS_SALADA + ") " +
            "VALUES ('Azeitona', '6');";
    /*=============================================================================*/

    /*=============================================================================*/
    /*MOLHO*/
    final static String TABLE_NAME_MOLHO= "molho";
    final static String NOME_MOLHO = "nome";
    final static String CALORIAS_MOLHO = "calorias";
    final static String[] columnsMOLHO= { _ID, NOME_MOLHO, CALORIAS_MOLHO };
    final private static String CREATE_TABLE_MOLHO =

            "CREATE TABLE MOLHO (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_MOLHO + " TEXT NOT NULL,"
                    + CALORIAS_MOLHO + " TEXT NOT NULL)";
    final private static String INSERT_MOLHO1 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ") " +
            "VALUES ('Picante', '5');";
    final private static String INSERT_MOLHO2 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ") " +
            "VALUES ('Barbercue', '100');";
    final private static String INSERT_MOLHO3 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ") " +
            "VALUES ('Parmesão', '150');";
    final private static String INSERT_MOLHO4 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ") " +
            "VALUES ('Maionese', '199');";
    final private static String INSERT_MOLHO5 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ") " +
            "VALUES ('Mostarda', '9');";
    final private static String INSERT_MOLHO6 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ") " +
            "VALUES ('Ketchup', '5');";
    final private static String INSERT_MOLHO7 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ") " +
            "VALUES ('Azeite', '4');";
    /*=============================================================================*/

    /*=============================================================================*/
    /*CONDIMENTOS*/
    final static String TABLE_NAME_CONDIMENTOS= "CONDIMENTOS";
    final static String NOME_CONDIMENTOS = "nome";
    final static String CALORIAS_CONDIMENTOS = "calorias";
    final static String[] columnsCONDIMENTOS= { _ID, NOME_CONDIMENTOS, CALORIAS_CONDIMENTOS };
    final private static String CREATE_TABLE_CONDIMENTOS =

            "CREATE TABLE CONDIMENTOS (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_CONDIMENTOS + " TEXT NOT NULL,"
                    + CALORIAS_CONDIMENTOS + " TEXT NOT NULL)";
    final private static String INSERT_CONDIMENTOS1 = "INSERT INTO CONDIMENTOS ("
            + NOME_CONDIMENTOS + ", "
            + CALORIAS_CONDIMENTOS + ") " +
            "VALUES ('Orégano', '2');";
    final private static String INSERT_CONDIMENTOS2 = "INSERT INTO CONDIMENTOS ("
            + NOME_CONDIMENTOS + ", "
            + CALORIAS_CONDIMENTOS + ") " +
            "VALUES ('Pimenta Calabresa', '2');";
    final private static String INSERT_CONDIMENTOS3 = "INSERT INTO CONDIMENTOS ("
            + NOME_CONDIMENTOS + ", "
            + CALORIAS_CONDIMENTOS + ") " +
            "VALUES ('Pimenta do Reino', '3');";
    final private static String INSERT_CONDIMENTOS4 = "INSERT INTO CONDIMENTOS ("
            + NOME_CONDIMENTOS + ", "
            + CALORIAS_CONDIMENTOS + ") " +
            "VALUES ('Sal', '4');";
    /*=============================================================================*/


    /*=============================================================================*/
    /*Create table LOCATIONS*/
    final private static String CREATE_LOCATIONS =

            "CREATE TABLE locations (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME + " TEXT NOT NULL,"
                    + LATITUDE + " TEXT NOT NULL,"
                    + LONGITUDE + " TEXT NOT NULL)";

    final private static String INSERT_LOCATION1 = "INSERT INTO locations ("
            + NOME + ", "
            + LATITUDE + ", "
            + LONGITUDE + ") " +
            "VALUES ('casa_tia_lena', -19.895171, -44.026986);";

    final private static String INSERT_LOCATION2 = "INSERT INTO locations ("
            + NOME + ", "
            + LATITUDE + ", "
            + LONGITUDE + ") " +
            "VALUES ('PUC Minas', -19.923639, -43.992525);";

    final private static String INSERT_LOCATION3 = "INSERT INTO locations ("
            + NOME + ", "
            + LATITUDE + ", "
            + LONGITUDE + ") " +
            "VALUES ('Mineirão', -19.866020, -43.971040);";

    final private static String INSERT_LOCATION4 = "INSERT INTO locations ("
            + NOME + ", "
            + LATITUDE + ", "
            + LONGITUDE + ") " +
            "VALUES ('Casa tia Lena', -19.797104, -43.970881);";
    /*=============================================================================*/

    /*=============================================================================*/
    final static String[] columnToken = { _ID, TOKEN };
    /*Create table TOKEN*/
    final private static String CREATE_TABLE_TOKEN =

            "CREATE TABLE token (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + TOKEN + " TEXT NOT NULL)";

    final private static String INSERT_TOKEN1 = "INSERT INTO token ("
            + TOKEN + ") " +
            "VALUES ('TesteASAS2015');";

    /*=============================================================================*/




    /*Create table PEDIDO*/
    final private static String CREATE_CMD2 =

            "CREATE TABLE pedido (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME + " TEXT NOT NULL,"
                    + CPF + " TEXT NOT NULL,"
                    + NUMERO + " TEXT NOT NULL,"
                    + TOKEN + " TEXT NOT NULL)";



    final private static String NAME = "locations_db";
    final private static Integer VERSION = 1;
    final private Context mContext;

    public DatabaseOpenHelper(Context context) {
        super(context, NAME, null, VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*CARNE*/
        db.execSQL(CREATE_TABLE_CARNE);
        db.execSQL(INSERT_CARNE1);
        db.execSQL(INSERT_CARNE2);
        db.execSQL(INSERT_CARNE3);
        db.execSQL(INSERT_CARNE4);
        db.execSQL(INSERT_CARNE5);

        /*QUEIJO*/
        db.execSQL(CREATE_TABLE_Queijo);
        db.execSQL(INSERT_QUEIJO1);
        db.execSQL(INSERT_QUEIJO2);
        db.execSQL(INSERT_QUEIJO3);

        /*PAO*/
        db.execSQL(CREATE_TABLE_PAO);
        db.execSQL(INSERT_PAO1);
        db.execSQL(INSERT_PAO2);
        db.execSQL(INSERT_PAO3);
        db.execSQL(INSERT_PAO4);
        db.execSQL(INSERT_PAO5);

        /*SALADA*/
        db.execSQL(CREATE_TABLE_SALADA);
        db.execSQL(INSERT_SALADA1);
        db.execSQL(INSERT_SALADA2);
        db.execSQL(INSERT_SALADA3);
        db.execSQL(INSERT_SALADA4);
        db.execSQL(INSERT_SALADA5);

        /*MOLHO*/
        db.execSQL(CREATE_TABLE_MOLHO);
        db.execSQL(INSERT_MOLHO1);
        db.execSQL(INSERT_MOLHO2);
        db.execSQL(INSERT_MOLHO3);
        db.execSQL(INSERT_MOLHO4);
        db.execSQL(INSERT_MOLHO5);
        db.execSQL(INSERT_MOLHO6);
        db.execSQL(INSERT_MOLHO7);

        /*CONDIMENTO*/
        db.execSQL(CREATE_TABLE_CONDIMENTOS);
        db.execSQL(INSERT_CONDIMENTOS1);
        db.execSQL(INSERT_CONDIMENTOS2);
        db.execSQL(INSERT_CONDIMENTOS3);
        db.execSQL(INSERT_CONDIMENTOS4);

        /*LOCATIONS*/
        db.execSQL(CREATE_LOCATIONS);
        db.execSQL(INSERT_LOCATION1);
        db.execSQL(INSERT_LOCATION2);
        db.execSQL(INSERT_LOCATION3);
        db.execSQL(INSERT_LOCATION4);

        /*TOKEN*/
        db.execSQL(CREATE_TABLE_TOKEN);
        db.execSQL(INSERT_TOKEN1);

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

    public Cursor getCarnes() {
        return this.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME_Carne,
                DatabaseOpenHelper.columnsCarne, null, new String[] {}, null, null,
                null);
    }

    public Cursor getSaladas() {
        return this.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME_SALADA,
                DatabaseOpenHelper.columnsCarne, null, new String[] {}, null, null,
                null);
    }

    public Cursor getMolhos() {
        return this.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME_MOLHO,
                DatabaseOpenHelper.columnsCarne, null, new String[] {}, null, null,
                null);
    }

    public Cursor getCondimentos() {
        return this.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME_CONDIMENTOS,
                DatabaseOpenHelper.columnsCarne, null, new String[] {}, null, null,
                null);
    }

    public Cursor getToken() {
        return this.getWritableDatabase().query(DatabaseOpenHelper.TOKEN,
                DatabaseOpenHelper.columnToken, null, new String[] {}, null, null,
                null);
    }

    public void insertToken(String token){
        String INSERT_TOKEN = "INSERT INTO token ("
                + TOKEN + ") " +
                "VALUES ('" + token + "');";
        this.getWritableDatabase().execSQL(INSERT_TOKEN);
    }
}
