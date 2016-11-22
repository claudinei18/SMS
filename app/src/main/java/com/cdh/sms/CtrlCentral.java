package com.cdh.sms;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.cdh.sms.dataBase.DatabaseOpenHelper;
import com.cdh.sms.intro.IntroActivity;
import com.cdh.sms.tools.SharedPreferencesHelper;

public class CtrlCentral extends AppCompatActivity {

    private DatabaseOpenHelper databaseOpenHelper;
    private static final int MY_PERMISSION_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        checkPermission();
        if (new SharedPreferencesHelper(this).isFirstAccess()) {
            startActivity(new Intent(this, IntroActivity.class));
        }
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "permission not granted", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }

    public void goTelaToken(View view) {
        startActivity(new Intent(this, CtrlRecupToken.class));
    }

    public void goTelaHist(View view) {
        startActivity(new Intent(this, CtrlHist.class));
    }

    public void reset(View view) {
        new SharedPreferencesHelper(this).setFirstAccess(true);
    }
}
