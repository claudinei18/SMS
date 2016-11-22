package com.cdh.sms;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cdh.sms.dataBase.DatabaseOpenHelper;

public class CtrlPag extends AppCompatActivity {
    private DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pag);

        Spinner spinner = (Spinner) findViewById(R.id.month_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.month_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.year_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.year_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        databaseOpenHelper = new DatabaseOpenHelper(this);
    }

    public void nextT(View view) {

        EditText etNome = (EditText)findViewById(R.id.et_Nome);
        String nomeUsu = etNome.getText().toString();

        EditText etCPF = (EditText)findViewById(R.id.et_CPF);
        String cpfUsu = etCPF.getText().toString();

        EditText etNumCart = (EditText)findViewById(R.id.et_NumeroCartao);
        String numCar = etNumCart.getText().toString();

        EditText etCodSeg = (EditText)findViewById(R.id.et_CodSeg);
        String codSeg = etCodSeg.getText().toString();

        EditText etNomImp = (EditText)findViewById(R.id.et_NomeImpresso);
        String nomImp = etNomImp.getText().toString();

//        EditText etDatVal= (EditText)findViewById(R.id.et_DataVal);
//        String datVal = etDatVal.getText().toString();

        EditText etTel = (EditText)findViewById(R.id.editText_Telefone);
        String telUsu = etTel.getText().toString();

        String pedido = "";
        float valor = 0;

        try {
            pedido = getIntent().getStringExtra("pedido");
            valor = getIntent().getFloatExtra("valor", valor);

        }catch (Exception e){
            e.printStackTrace();
        }
        if(nomeUsu.length() < 3){
            etNome.setError("Nome deve conter pelo menos 3 dígitos");
        }else if(cpfUsu.length() < 11){
            etCPF.requestFocus();
            etCPF.setError("CPF deve ter 11 dígitos");
        }else if(numCar.length() < 16){
            etNumCart.requestFocus();
            etNumCart.setError("Número do cartão deve ter 16 dígitos");
        }else if(codSeg.length() < 3){
            etCodSeg.requestFocus();
            etCodSeg.setError("Código de Segurança deve ter 3 dígitos");
        }else if(nomImp.length() < 3){
            etNomImp.requestFocus();
            etNomImp.setError("Nome deve conter pelo menos 3 dígitos");
        }else if(telUsu.length() < 8){
            etTel.requestFocus();
            etTel.setError("Telefone pelo menos 8 digítos");
        }else{
            final Bundle bundle = new Bundle();
            bundle.putFloat("valor", valor);
            bundle.putString("pedido", pedido);
            bundle.putString("nomeUsu", nomeUsu);
            bundle.putString("cpfUsu", cpfUsu);
            bundle.putString("telUsu", telUsu);


            final ProgressDialog progressBar = new ProgressDialog(this);
            progressBar.setCancelable(true);
            progressBar.setMessage("Aguardando pagamento ...");
            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressBar.setProgress(0);
            progressBar.setMax(100);

            progressBar.show();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    progressBar.hide();
                    Intent intent = new Intent(CtrlPag.this, CtrlTok.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }, 2000);
        }
    }
}
