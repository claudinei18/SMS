package com.cdh.sms;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cdh.sms.dataBase.DatabaseOpenHelper;

import java.util.ArrayList;

public class CtrlHist extends AppCompatActivity implements AdapterView.OnItemClickListener{

    DatabaseOpenHelper databaseOpenHelper;
    String sanduiche = "";
    ArrayList<String> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_hist);

        databaseOpenHelper = new DatabaseOpenHelper(this);

        itens = new ArrayList<>();

        Cursor cursor = databaseOpenHelper.getPedidos();

        if (cursor.moveToFirst()){
            do{
                sanduiche = cursor.getString(cursor.getColumnIndex("sanduiche"));

                itens.add(sanduiche);

            }while(cursor.moveToNext());
        }
        cursor.close();

        if (itens.size() != 0) {
            ((TextView)findViewById(R.id.txt_lv)).setVisibility(View.GONE);
        }

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
        Intent intent = new Intent(this, CtrlDest.class);
        intent.putExtra("pedido", itens.get(position));

        startActivity(intent);
    }
}
