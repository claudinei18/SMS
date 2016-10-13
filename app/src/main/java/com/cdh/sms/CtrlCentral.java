package com.cdh.sms;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.cdh.sms.dataBase.DatabaseOpenHelper;

public class CtrlCentral extends AppCompatActivity {

    private DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        getPermissions();

    }

    public boolean getPermissions(){
        boolean resp = false;
        // Here, thisActivity is the current activity


        return resp;
    }


    public void goTelaToken(View view) {
        startActivity(new Intent(this, CtrlTok.class));
    }

    public void goTelaHist(View view) {
        startActivity(new Intent(this, CtrlHist.class));
    }
}
