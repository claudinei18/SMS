package com.cdh.sms;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cdh.sms.fragment_montar.CarneFragment;

public class CtrlMontar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_montar);
        Fragment fragment = new CarneFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_fragment, fragment);
        transaction.commit();
    }

    public void nextD(View view) {
        startActivity(new Intent(this, CtrlDest.class));
    }
}
