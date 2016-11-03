package com.cdh.sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.cdh.sms.dataBase.DatabaseOpenHelper;

public class CtrlPag extends AppCompatActivity {
    private DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pag);

        databaseOpenHelper = new DatabaseOpenHelper(this);
    }

    public void nextT(View view) {

        EditText et = (EditText)findViewById(R.id.et_Nome);
        String nomeUsu = et.getText().toString();
        et = (EditText)findViewById(R.id.et_CPF);
        String cpfUsu = et.getText().toString();
        et = (EditText)findViewById(R.id.editText_Telefone);
        String telsu = et.getText().toString();

        String pedido = "";

        try {
            pedido = getIntent().getExtras().get("pedido").toString();
        }catch (Exception e){

        }

        Intent intent = new Intent(this, CtrlTok.class);
        intent.putExtra("pedido", pedido);
        intent.putExtra("nomeUsu", nomeUsu);
        intent.putExtra("cpfUsu", cpfUsu);
        intent.putExtra("telUsu", telsu);

        startActivity(intent);
    }
}
