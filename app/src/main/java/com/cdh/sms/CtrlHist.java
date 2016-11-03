package com.cdh.sms;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.cdh.sms.dataBase.DatabaseOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class CtrlHist extends AppCompatActivity implements AdapterView.OnItemClickListener{

    DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_hist);

        databaseOpenHelper = new DatabaseOpenHelper(this);

        ArrayList<String> itens = new ArrayList<>();
        itens.add("Sanduiche1");

        Cursor cursor = databaseOpenHelper.getPedidos();

        if (cursor.moveToFirst()){
            do{
                String id = cursor.getString(cursor.getColumnIndex("_id"));
                String nomeUsu = cursor.getString(cursor.getColumnIndex("nomeUsu"));
                String cpfUsu = cursor.getString(cursor.getColumnIndex("cpfUsu"));
                String telUsu = cursor.getString(cursor.getColumnIndex("telUsu"));
                String sanduiche = cursor.getString(cursor.getColumnIndex("sanduiche"));


                itens.add(sanduiche);


            }while(cursor.moveToNext());
        }
        cursor.close();

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itens);
        listView.setAdapter(adapter);

    }

    public void nextDe(View view) {
        startActivity(new Intent(this, CtrlMontar.class));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this, CtrlDest.class));
    }
}
