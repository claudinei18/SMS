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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tok);

        databaseOpenHelper = new DatabaseOpenHelper(this);

        TknGenerator tknGenerator = new TknGenerator();
        String token = TknGenerator.makeToken();
        System.out.println(token);

        databaseOpenHelper.insertToken(token);

        Cursor cursor = databaseOpenHelper.getToken();
        System.out.println("Entrou no recuperar");

        if (cursor.moveToFirst()){
            do {
                String x = cursor.getString(cursor.getColumnIndex("token"));
                System.out.println("Token: " + x);
            }while(cursor.moveToNext());
            cursor.close();
        }

        TextView tv = (TextView)findViewById(R.id.tvToken);
        tv.setText(token);
    }

    public void goTelaCentral(View view) {
        Intent intent = new Intent(this, CtrlCentral.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
