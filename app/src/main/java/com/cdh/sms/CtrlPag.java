package com.cdh.sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cdh.sms.dataBase.DatabaseOpenHelper;

public class CtrlPag extends AppCompatActivity {
    private DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pag);

        databaseOpenHelper = new DatabaseOpenHelper(this);
    }

    public void nextT(View view) {

        EditText etNome = (EditText)findViewById(R.id.et_Nome);
        String nomeUsu = etNome.getText().toString();
        etNome.addTextChangedListener(textWatcher);

        EditText etCPF = (EditText)findViewById(R.id.et_CPF);
        String cpfUsu = etCPF.getText().toString();
        etCPF.addTextChangedListener(textWatcher);

        EditText etTel = (EditText)findViewById(R.id.editText_Telefone);

        String telsu = etTel.getText().toString();

        String pedido = "";

        try {
            pedido = getIntent().getExtras().get("pedido").toString();
        }catch (Exception e){

        }

        Intent intent = new Intent(this, CtrlTok.class);
        intent.putExtra("pedido", pedido);
        intent.putExtra("nomeUsu", nomeUsu);
        intent.putExtra("cpfUsu", cpfUsu);
        intent.putExtra("telUsu", telsu);

        startActivity(intent);
    }

    private final TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.length() > 2){
                Toast toast = Toast.makeText(CtrlPag.this, " selecionado!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }

        public void afterTextChanged(Editable s)
        {
            if(s.length() > 2){
                Toast toast = Toast.makeText(CtrlPag.this, " selecionado!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    };
}
