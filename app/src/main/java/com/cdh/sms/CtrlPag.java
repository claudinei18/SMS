package com.cdh.sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CtrlPag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pag);
    }

    public void nextT(View view) {
        startActivity(new Intent(this, CtrlTok.class));
    }
}
