package com.cdh.sms;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cdh.sms.dataBase.DatabaseOpenHelper;
import com.cdh.sms.fragment_montar.CarneFragment;
import com.cdh.sms.location.AppLocationService;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class CtrlMontar extends AppCompatActivity {

    private DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_montar);

        databaseOpenHelper = new DatabaseOpenHelper(this);

        populateRadioGroup("Carne");
        populateRadioGroup("Salada");
    }

    public void populateCarnes(){

        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(LinearLayout.VERTICAL);


        Cursor cursor = databaseOpenHelper.getCarnes();

        if (cursor.moveToFirst()){
            do{
                String id = cursor.getString(cursor.getColumnIndex("_id"));
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String calorias = cursor.getString(cursor.getColumnIndex("calorias"));

                System.out.println("Nome: " + nome);

                double x = Double.parseDouble(calorias);
                int int_id = Integer.parseInt(id);


                final RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId(int_id);
                rdbtn.setText(nome + " " + calorias + " cal");
                rdbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(CtrlMontar.this, "Carne " + rdbtn.getId() + " selecionado!", Toast.LENGTH_SHORT);
                        toast.show();
                        System.out.println("FOI CLICADO");
                    }
                });
                rg.addView(rdbtn);


            }while(cursor.moveToNext());
        }
        cursor.close();

        ((ViewGroup)findViewById(R.id.rg_Carnes)).addView(rg);

    }

    public void populateRadioGroup(String column){

        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(LinearLayout.VERTICAL);

        Cursor cursor = null;
        if(column.equals("Carne")){
            cursor = databaseOpenHelper.getCarnes();
        }else if(column.equals("Salada")){
            cursor = databaseOpenHelper.getSaladas();
        }

        if (cursor.moveToFirst()){
            do{
                String id = cursor.getString(cursor.getColumnIndex("_id"));
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String calorias = cursor.getString(cursor.getColumnIndex("calorias"));

                System.out.println("Nome: " + nome);

                double x = Double.parseDouble(calorias);
                int int_id = Integer.parseInt(id);


                final RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId(int_id);
                rdbtn.setText(nome + " " + calorias + " cal");
                rdbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(CtrlMontar.this, rdbtn.getText() + " selecionado!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                rg.addView(rdbtn);


            }while(cursor.moveToNext());
        }
        cursor.close();

        if(column.equals("Carne")){
            ((ViewGroup)findViewById(R.id.rg_Carnes)).addView(rg);
        }else if(column.equals("Salada")){
            ((ViewGroup)findViewById(R.id.rg_Saladas)).addView(rg);
        }
    }

    public void teste(){

        RadioGroup rgp= (RadioGroup) findViewById(R.id.rg_Carnes);
        RadioGroup.LayoutParams rprms;

        Cursor cursor = databaseOpenHelper.getCarnes();

        if (cursor.moveToFirst()){
            do{
                String id = cursor.getString(cursor.getColumnIndex("_id"));
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String calorias = cursor.getString(cursor.getColumnIndex("calorias"));

                System.out.println("Nome: " + nome);

                double x = Double.parseDouble(calorias);
                int int_id = Integer.parseInt(id);


                RadioButton radioButton = new RadioButton(this);
                radioButton.setId(int_id);
                radioButton.setText(nome + " " + calorias + " cal");
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        System.out.println("CLICADO");
                    }
                });
                rprms= new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);

                rgp.addView(radioButton, rprms);



            }while(cursor.moveToNext());
        }
        cursor.close();

    }

    public void nextD(View view) {
        startActivity(new Intent(this, CtrlDest.class));
    }
}
