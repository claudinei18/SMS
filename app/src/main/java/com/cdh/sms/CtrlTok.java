package com.cdh.sms;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cdh.sms.dataBase.DatabaseOpenHelper;
import com.cdh.sms.token.TknGenerator;

public class CtrlTok extends AppCompatActivity {

    DatabaseOpenHelper databaseOpenHelper;
    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tok);

        databaseOpenHelper = new DatabaseOpenHelper(this);

        TknGenerator tknGenerator = new TknGenerator();
        token = tknGenerator.makeToken();

        databaseOpenHelper.insertToken(token);

        Cursor cursor = databaseOpenHelper.getToken();

        if (cursor.moveToFirst()){
            do {
                String x = cursor.getString(cursor.getColumnIndex("token"));
            }while(cursor.moveToNext());
            cursor.close();
        }

        TextView tv = (TextView)findViewById(R.id.tvToken);
        tv.setText(token);
    }

    public void goTelaCentral(View view) {
        Intent intent = new Intent(this, CtrlCentral.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        String pedido = "";
        String nomUsu = "";
        String cpfUsu = "";
        String telUsu = "";
        float valor = 0;

        try {
            pedido = getIntent().getExtras().get("pedido").toString();
            nomUsu = getIntent().getExtras().get("nomUsu").toString();
            cpfUsu = getIntent().getExtras().get("cpfUsu").toString();
            telUsu = getIntent().getExtras().get("telUsu").toString();
            valor = Float.parseFloat(getIntent().getExtras().get("valor").toString());
        }catch (Exception e){

        }

        databaseOpenHelper.insertPedido(cpfUsu, nomUsu, telUsu, pedido, valor, token);

        startActivity(intent);
        finish();
    }
}
