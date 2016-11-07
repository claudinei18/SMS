package com.cdh.sms;

import android.database.Cursor;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
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
import com.google.android.gms.vision.text.Line;

import java.util.ArrayList;
import java.util.List;

public class CtrlMontar extends AppCompatActivity {

    private DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_montar);

        databaseOpenHelper = new DatabaseOpenHelper(this);

        populateRadioGroup("Carne");
        populateRadioGroup("Pao");
        populateListView("Salada");
        populateListView("Molhos");
        populateListView("Condimentos");
    }

    public void populateListView(String column){

        LinearLayout ll = null;
        Cursor cursor = null;
        if(column.equals("Salada")){
            ll = (LinearLayout) findViewById(R.id.llSaladas);
            cursor = databaseOpenHelper.getSaladas();
        }else if(column.equals("Molhos")){
            ll = (LinearLayout) findViewById(R.id.llMolhos);
            cursor = databaseOpenHelper.getMolhos();
        }else if(column.equals("Condimentos")){
            ll = (LinearLayout) findViewById(R.id.llCondimentos);
            cursor = databaseOpenHelper.getCondimentos();
        }



        if (cursor.moveToFirst()){
            do{
                String id = cursor.getString(cursor.getColumnIndex("_id"));
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String calorias = cursor.getString(cursor.getColumnIndex("calorias"));

                System.out.println("Nome: " + nome);

                CheckBox cb = new CheckBox(this);
                cb.setText(nome + " " + calorias + " cal");
                ll.addView(cb);

//                ImageView iv = new ImageView(this);
//                iv.setBackgroundResource(R.drawable.imag);
//                iv.setMaxHeight(20);
//                iv.setMaxWidth(20);
//                ll.addView(iv);



            }while(cursor.moveToNext());
        }
        cursor.close();


    }


    public void populateRadioGroup(String column){

        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(LinearLayout.VERTICAL);

        Cursor cursor = null;
        if(column.equals("Carne")){
            cursor = databaseOpenHelper.getCarnes();
        }else if(column.equals("Pao")){
            cursor = databaseOpenHelper.getPaes();
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
        }else if(column.equals("Pao")){
            ((ViewGroup)findViewById(R.id.rg_Paes)).addView(rg);
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

        String pedido = "";
        boolean nextView = true;


        RadioGroup rgPai = (RadioGroup) findViewById(R.id.rg_Paes);
        RadioGroup rgPaes = (RadioGroup) rgPai.getChildAt(0);

        rgPai = (RadioGroup) findViewById(R.id.rg_Carnes);
        RadioGroup rgCarnes = (RadioGroup) rgPai.getChildAt(0);

        // Returns an integer which represents the selected radio button's ID
        int paoSelecionado = rgPaes.getCheckedRadioButtonId();
        int carneSelecionada = rgCarnes.getCheckedRadioButtonId();

        try {
            RadioButton rbPaoSelecionado = (RadioButton) rgPaes.getChildAt(paoSelecionado-1);
            pedido += rbPaoSelecionado.getText().toString();
        }catch (Exception e){
            Toast toast = Toast.makeText(CtrlMontar.this, "Selecione um pão.", Toast.LENGTH_SHORT);
            toast.show();
            nextView = false;
        }

        try {
            RadioButton rbCarneSelecionada = (RadioButton) rgCarnes.getChildAt(carneSelecionada-1);
            pedido += "\n" + rbCarneSelecionada.getText().toString();
        }catch (Exception e){
            Toast toast = Toast.makeText(CtrlMontar.this, "Selecione uma carne.", Toast.LENGTH_SHORT);
            toast.show();
            nextView = false;
        }

        LinearLayout ll = (LinearLayout) findViewById(R.id.llSaladas);
        for(int i = 0; ll.getChildAt(i) != null; i++){
            CheckBox cb = (CheckBox) ll.getChildAt(i);
            if(cb.isChecked()){
                pedido += "\n" + cb.getText();
            }
        }

        ll = (LinearLayout) findViewById(R.id.llMolhos);
        for(int i = 0; ll.getChildAt(i) != null; i++){
            CheckBox cb = (CheckBox) ll.getChildAt(i);
            if(cb.isChecked()){
                pedido += "\n" + cb.getText();
            }
        }

        ll = (LinearLayout) findViewById(R.id.llCondimentos);
        for(int i = 0; ll.getChildAt(i) != null; i++){
            CheckBox cb = (CheckBox) ll.getChildAt(i);
            if(cb.isChecked()){
                pedido += "\n" + cb.getText();
            }
        }


        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Welcome to AndroidHive", Snackbar.LENGTH_LONG);

        snackbar.show();



        if(nextView) {
//            Toast toast = Toast.makeText(CtrlMontar.this, "Selecionado: " + pedido, Toast.LENGTH_SHORT);
//            toast.show();


            Intent intent = new Intent(this, CtrlDest.class);
            intent.putExtra("pedido", pedido);
//            startActivity(intent);
        }
    }
}
