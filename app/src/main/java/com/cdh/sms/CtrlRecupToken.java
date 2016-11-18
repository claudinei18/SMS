package com.cdh.sms;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cdh.sms.dataBase.DatabaseOpenHelper;

public class CtrlRecupToken extends AppCompatActivity {

    DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recup_token);

        databaseOpenHelper = new DatabaseOpenHelper(this);

        Cursor cursor = databaseOpenHelper.getToken();

        String token = "";
        if (cursor.moveToFirst()){
            do {
                token = cursor.getString(cursor.getColumnIndex("token"));
                TextView tv = (TextView) findViewById(R.id.tvRecToken);
                tv.setText(token);
            }while(cursor.moveToNext());
            cursor.close();
        }

        cursor = databaseOpenHelper.getPedidoPorToken(token);

        if (cursor.moveToFirst()){
            do {
                String pedido = cursor.getString(cursor.getColumnIndex("sanduiche"));

                float valor = cursor.getFloat(cursor.getColumnIndex("valor"));
                pedido += "\nValor: R$" + valor + "0";
                ((TextView) findViewById(R.id.tvPedidoDetalhe)).setText(pedido);

            }while(cursor.moveToNext());

            cursor.close();
        }

    }

    public void goTelaCentral(View view) {
        Intent intent = new Intent(this, CtrlCentral.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
