package com.cdh.sms;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
            valor = getIntent().getFloatExtra("valor", 0f);

            pedido = getIntent().getStringExtra("pedido");
            nomUsu = getIntent().getStringExtra("nomUsu");
            cpfUsu = getIntent().getStringExtra("cpfUsu");
            telUsu = getIntent().getStringExtra("telUsu");
        }catch (Exception e){

        }

        Log.i("tok","valor: " + valor);
        databaseOpenHelper.insertPedido(cpfUsu, nomUsu, telUsu, pedido, valor, token);

        startActivity(intent);
        finish();
    }
}
