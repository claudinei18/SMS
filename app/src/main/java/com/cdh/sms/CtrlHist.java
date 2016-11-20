package com.cdh.sms;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cdh.sms.dataBase.DatabaseOpenHelper;
import com.cdh.sms.model.Sanduiche;
import com.cdh.sms.tools.MyAdapter;

import java.util.ArrayList;

public class CtrlHist extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    DatabaseOpenHelper databaseOpenHelper;
    String sanduiche = "";
    ArrayList<String> itens;
    ArrayList<Sanduiche> sanduiches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_hist);

        databaseOpenHelper = new DatabaseOpenHelper(this);

        itens = new ArrayList<>();
        sanduiches = new ArrayList<Sanduiche>();

        Cursor cursor = databaseOpenHelper.getPedidos();

        if (cursor.moveToFirst()){
            do{
                sanduiche = cursor.getString(cursor.getColumnIndex("sanduiche"));

                itens.add(sanduiche);

                Log.i("CtrlHist", "Add sanduiche");
                sanduiches.add(new Sanduiche(sanduiche));

            }while(cursor.moveToNext());
        }
        cursor.close();

        if (itens.size() != 0) {
            ((TextView)findViewById(R.id.txt_lv)).setVisibility(View.GONE);
        }

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        Log.i("CtrlHist", "creating adapter");
        ArrayAdapter<Sanduiche> adapter = new MyAdapter(this, android.R.layout.simple_list_item_1, sanduiches);
        Log.i("CtrlHist", "created adapter");
        listView.setAdapter(adapter);
        Log.i("CtrlHist", "Set adapter");
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

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        new AlertDialog.Builder(this)
                .setTitle("Detalhe do Sanduiche")
                .setMessage(itens.get(position))
                .show();
        return true;
    }
}
