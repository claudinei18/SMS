package com.cdh.sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CtrlCentral extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);
    }

    public void goTelaToken(View view) {
        startActivity(new Intent(this, CtrlTok.class));
    }

    public void goTelaHist(View view) {
        startActivity(new Intent(this, CtrlHist.class));
    }
}
