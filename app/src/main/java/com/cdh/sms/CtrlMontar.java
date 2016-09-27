package com.cdh.sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CtrlMontar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_montar);

        // @// TODO: 16/9/27 detalhar a tela montar, fragment, etc...
    }

    public void nextD(View view) {
        startActivity(new Intent(this, CtrlDest.class));
    }
}
