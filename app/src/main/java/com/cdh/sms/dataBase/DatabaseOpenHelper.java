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

    final static String CPF = "CPF";
    final static String NUMERO = "numero";
    final static String TOKEN = "token";


    /*=============================================================================*/
    /*CARNE*/
    final static String TABLE_NAME_Carne= "carne";
    final static String NOME_CARNE = "nome";
    final static String CALORIAS_CARNE = "calorias";
    final static String PRECO = "preco";
    final static String[] columnsCarne= { _ID, NOME_CARNE, CALORIAS_CARNE, PRECO };
    final private static String CREATE_TABLE_CARNE =

            "CREATE TABLE carne ("
                    + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_CARNE + " TEXT NOT NULL,"
                    + CALORIAS_CARNE + " TEXT NOT NULL,"
                    + PRECO + " TEXT NOT NULL);";
    final private static String INSERT_CARNE1 = "INSERT INTO carne ("
            + NOME_CARNE + ", "
            + CALORIAS_CARNE + ", "
            + PRECO + ") " +
            "VALUES ('Hambúrguer de Frango', '179', '5');";
    final private static String INSERT_CARNE2 = "INSERT INTO carne ("
            + NOME_CARNE + ", "
            + CALORIAS_CARNE + ", "
            + PRECO + ") " +
            "VALUES ('Hambúrguer Bovino', '116', '5');";
    final private static String INSERT_CARNE3 = "INSERT INTO carne ("
            + NOME_CARNE + ", "
            + CALORIAS_CARNE + ", "
            + PRECO + ") " +
            "VALUES ('Hambúrguer de Porco', '196', '3');";
    final private static String INSERT_CARNE4 = "INSERT INTO carne ("
            + NOME_CARNE + ", "
            + CALORIAS_CARNE + ", "
            + PRECO + ") " +
            "VALUES ('Hambúrguer de Soja', '100', '10');";
    final private static String INSERT_CARNE5 = "INSERT INTO carne ("
            + NOME_CARNE + ", "
            + CALORIAS_CARNE + ", "
            + PRECO + ") " +
            "VALUES ('Presunto', '67.2', '12');";
    /*=============================================================================*/


    /*=============================================================================*/
    /*QUEIJO*/
    final static String TABLE_NAME_Queijo = "queijo";
    final static String NOME_QUEIJO = "nome";
    final static String CALORIAS_QUEIJO = "calorias";
    final static String[] columnsQueijo= { _ID, NOME_QUEIJO, CALORIAS_QUEIJO, PRECO };
    final private static String CREATE_TABLE_Queijo =

            "CREATE TABLE queijo (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_QUEIJO + " TEXT NOT NULL,"
                    + CALORIAS_QUEIJO + " TEXT NOT NULL,"
                    + PRECO + " TEXT NOT NULL);";

    final private static String INSERT_QUEIJO1 = "INSERT INTO queijo ("
            + NOME_QUEIJO + ", "
            + CALORIAS_QUEIJO + ", "
            + PRECO + ") " +
            "VALUES ('cheddar', '107', '2');";
    final private static String INSERT_QUEIJO2 = "INSERT INTO queijo ("
            + NOME_QUEIJO + ", "
            + CALORIAS_QUEIJO + ", "
            + PRECO + ") " +
            "VALUES ('muçarela', '47', '3');";
    final private static String INSERT_QUEIJO3 = "INSERT INTO queijo ("
            + NOME_QUEIJO + ", "
            + CALORIAS_QUEIJO + ", "
            + PRECO + ") " +
            "VALUES ('ricota', '54', '4');";
    /*=============================================================================*/

    /*=============================================================================*/
    /*PAO*/
    final static String TABLE_NAME_PAO= "pao";
    final static String NOME_PAO = "nome";
    final static String CALORIAS_PAO = "calorias";
    final static String[] columnsPAO= { _ID, NOME_PAO, CALORIAS_PAO, PRECO };
    final private static String CREATE_TABLE_PAO =

            "CREATE TABLE PAO (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_PAO + " TEXT NOT NULL, "
                    + CALORIAS_PAO + " TEXT NOT NULL, "
                    + PRECO + " TEXT NOT NULL);";
    final private static String INSERT_PAO1 = "INSERT INTO PAO ("
            + NOME_PAO + ", "
            + CALORIAS_PAO + ", "
            + PRECO + ") " +
            "VALUES ('Francês', '135', '3');";
    final private static String INSERT_PAO2 = "INSERT INTO PAO ("
            + NOME_PAO + ", "
            + CALORIAS_PAO + ", "
            + PRECO + ") " +
            "VALUES ('Integral', '261', '4');";
    final private static String INSERT_PAO3 = "INSERT INTO PAO ("
            + NOME_PAO + ", "
            + CALORIAS_PAO + ", "
            + PRECO + ") " +
            "VALUES ('Sírio', '147', '5');";
    final private static String INSERT_PAO4 = "INSERT INTO PAO ("
            + NOME_PAO + ", "
            + CALORIAS_PAO + ", "
            + PRECO + ") " +
            "VALUES ('Pão de Queijo', '68', '6');";
    final private static String INSERT_PAO5 = "INSERT INTO PAO ("
            + NOME_PAO + ", "
            + CALORIAS_PAO + ", "
            + PRECO + ") " +
            "VALUES ('Australiano', '140', '7');";
    /*=============================================================================*/

    /*=============================================================================*/
    /*SALADA*/
    final static String TABLE_NAME_SALADA= "salada";
    final static String NOME_SALADA = "nome";
    final static String CALORIAS_SALADA = "calorias";
    final static String[] columnsSALADA= { _ID, NOME_SALADA, CALORIAS_SALADA, PRECO };
    final private static String CREATE_TABLE_SALADA =

            "CREATE TABLE SALADA (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_SALADA + " TEXT NOT NULL,"
                    + CALORIAS_SALADA + " TEXT NOT NULL, "
                    + PRECO + " TEXT NOT NULL);";
    final private static String INSERT_SALADA1 = "INSERT INTO SALADA ("
            + NOME_SALADA + ", "
            + CALORIAS_SALADA + ", "
            + PRECO + ") " +
            "VALUES ('Alface', '6', '1');";
    final private static String INSERT_SALADA2 = "INSERT INTO SALADA ("
            + NOME_SALADA + ", "
            + CALORIAS_SALADA + ", "
            + PRECO + ") " +
            "VALUES ('Tomate', '20', '2');";
    final private static String INSERT_SALADA3 = "INSERT INTO SALADA ("
            + NOME_SALADA + ", "
            + CALORIAS_SALADA + ", "
            + PRECO + ") " +
            "VALUES ('Pimentão', '14', '3');";
    final private static String INSERT_SALADA4 = "INSERT INTO SALADA ("
            + NOME_SALADA + ", "
            + CALORIAS_SALADA + ", "
            + PRECO + ") " +
            "VALUES ('Cebola', '31', '4');";
    final private static String INSERT_SALADA5 = "INSERT INTO SALADA ("
            + NOME_SALADA + ", "
            + CALORIAS_SALADA + ", "
            + PRECO + ") " +
            "VALUES ('Azeitona', '6', '5');";
    /*=============================================================================*/

    /*=============================================================================*/
    /*MOLHO*/
    final static String TABLE_NAME_MOLHO= "molho";
    final static String NOME_MOLHO = "nome";
    final static String CALORIAS_MOLHO = "calorias";
    final static String[] columnsMOLHO= { _ID, NOME_MOLHO, CALORIAS_MOLHO, PRECO };
    final private static String CREATE_TABLE_MOLHO =

            "CREATE TABLE MOLHO (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_MOLHO + " TEXT NOT NULL, "
                    + CALORIAS_MOLHO + " TEXT NOT NULL, "
                    + PRECO + " TEXT NOT NULL);";
    final private static String INSERT_MOLHO1 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ", "
            + PRECO + ") " +
            "VALUES ('Picante', '5', '1');";
    final private static String INSERT_MOLHO2 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ", "
            + PRECO + ") " +
            "VALUES ('Barbercue', '100', '2');";
    final private static String INSERT_MOLHO3 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ", "
            + PRECO + ") " +
            "VALUES ('Parmesão', '150', '3');";
    final private static String INSERT_MOLHO4 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ", "
            + PRECO + ") " +
            "VALUES ('Maionese', '199', '4');";
    final private static String INSERT_MOLHO5 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ", "
            + PRECO + ") " +
            "VALUES ('Mostarda', '9', '5');";
    final private static String INSERT_MOLHO6 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ", "
            + PRECO + ") " +
            "VALUES ('Ketchup', '5', '6');";
    final private static String INSERT_MOLHO7 = "INSERT INTO MOLHO ("
            + NOME_MOLHO + ", "
            + CALORIAS_MOLHO + ", "
            + PRECO + ") " +
            "VALUES ('Azeite', '4', '7');";
    /*=============================================================================*/

    /*=============================================================================*/
    /*CONDIMENTOS*/
    final static String TABLE_NAME_CONDIMENTOS= "CONDIMENTOS";
    final static String NOME_CONDIMENTOS = "nome";
    final static String CALORIAS_CONDIMENTOS = "calorias";
    final static String[] columnsCONDIMENTOS= { _ID, NOME_CONDIMENTOS, CALORIAS_CONDIMENTOS, PRECO };
    final private static String CREATE_TABLE_CONDIMENTOS =

            "CREATE TABLE CONDIMENTOS (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_CONDIMENTOS + " TEXT NOT NULL,"
                    + CALORIAS_CONDIMENTOS + " TEXT NOT NULL,"
                    + PRECO + " TEXT NOT NULL);";
    final private static String INSERT_CONDIMENTOS1 = "INSERT INTO CONDIMENTOS ("
            + NOME_CONDIMENTOS + ", "
            + CALORIAS_CONDIMENTOS + ", "
            + PRECO + ") " +
            "VALUES ('Orégano', '2', '1');";
    final private static String INSERT_CONDIMENTOS2 = "INSERT INTO CONDIMENTOS ("
            + NOME_CONDIMENTOS + ", "
            + CALORIAS_CONDIMENTOS + ", "
            + PRECO + ") " +
            "VALUES ('Pimenta Calabresa', '2', '2');";
    final private static String INSERT_CONDIMENTOS3 = "INSERT INTO CONDIMENTOS ("
            + NOME_CONDIMENTOS + ", "
            + CALORIAS_CONDIMENTOS + ", "
            + PRECO + ") " +
            "VALUES ('Pimenta do Reino', '3', '3');";
    final private static String INSERT_CONDIMENTOS4 = "INSERT INTO CONDIMENTOS ("
            + NOME_CONDIMENTOS + ", "
            + CALORIAS_CONDIMENTOS + ", "
            + PRECO + ") " +
            "VALUES ('Sal', '4', '4');";
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

    /*=============================================================================*/
    final static String TABLE_NAME_Pedido = "pedido";
    final static String NOME_USU = "nomeUsu";
    final static String CPF_USU = "cpfUsu";
    final static String TEL_USU = "telUsu";
    final static String SANDUICHE = "sanduiche";
    final static String VALOR = "valor";

    final static String[] columnsPedido = { _ID, NOME_USU, CPF_USU, TEL_USU, SANDUICHE };

    /*Create table PEDIDO*/
    final private static String CREATE_PEDIDO =

            "CREATE TABLE pedido ("
                    + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOME_USU + " TEXT NOT NULL, "
                    + CPF_USU + " TEXT NOT NULL, "
                    + TEL_USU + " TEXT NOT NULL, "
                    + SANDUICHE + " TEXT NOT NULL, "
                    + VALOR + " REAL NOT NULL, "
                    + TOKEN + " TEXT NOT NULL);";

    final private static String INSERT_PEDIDO1 = "INSERT INTO pedido ("
            + NOME_USU + ", "
            + CPF_USU + ", "
            + TEL_USU + ", "
            + SANDUICHE + ") " +
            "VALUES ('Claudinei', '123.456.789-10', '(31)99999-9999', 'Sanduiche_1 Pao_1 Carne_1 Salada_1 Molho_1 Condimento_1');";
    /*=============================================================================*/



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

        /*PEDIDO*/
        db.execSQL(CREATE_PEDIDO);
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

    public Cursor getPaes() {
        return this.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME_PAO,
                DatabaseOpenHelper.columnsPAO, null, new String[] {}, null, null,
                null);
    }

    public Cursor getPedidos() {
        return this.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME_Pedido,
                DatabaseOpenHelper.columnsPedido, null, new String[] {}, null, null,
                null);
    }

    public void insertToken(String token){
        String INSERT_TOKEN = "INSERT INTO token ("
                + TOKEN + ") " +
                "VALUES ('" + token + "');";
        this.getWritableDatabase().execSQL(INSERT_TOKEN);
    }

    public void insertPedido(String cpfUsu, String nomUSu, String telUsu, String pedido, float valor, String token){

        Cursor pedidoExiste = this.pedidoExiste(pedido);
        if(!(pedidoExiste.moveToFirst())){
            String INSERT_PEDIDO = "INSERT INTO pedido ("
                    + NOME_USU + ", "
                    + CPF_USU + ", "
                    + TEL_USU + ", "
                    + SANDUICHE + ", "
                    + VALOR + ", "
                    + TOKEN + ") " +
                    "VALUES ('" + nomUSu + "', '" + cpfUsu + "', '" + telUsu + "', '" + pedido + "', '" + valor +"', '" + token +"');";

            this.getWritableDatabase().execSQL(INSERT_PEDIDO);
        }else{
            alterTokenPorPedido(pedido, token);
        }
    }

    public Cursor getPedidoPorToken(String token){
        String query = "SELECT * FROM pedido WHERE token = '" + token + "';";
        return getWritableDatabase().rawQuery(query, null);
    }

    public Cursor getValorPorToken(String token){
        String query = "SELECT valor FROM pedido WHERE token = '" + token + "';";
        return getWritableDatabase().rawQuery(query, null);
    }

    private Cursor pedidoExiste(String pedido){
        String query = "SELECT sanduiche FROM pedido WHERE sanduiche = '" + pedido + "';";
        return getWritableDatabase().rawQuery(query, null);
    }

    private void alterTokenPorPedido(String pedido, String token){
        String query = "UPDATE pedido SET token = '" + token + "' WHERE sanduiche = '" +pedido + "';";
        this.getWritableDatabase().execSQL(query);
    }
}
