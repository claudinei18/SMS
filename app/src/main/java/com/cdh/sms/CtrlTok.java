package com.cdh.sms;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cdh.sms.dataBase.DatabaseOpenHelper;
import com.cdh.sms.token.TknGenerator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class CtrlTok extends AppCompatActivity {

    DatabaseOpenHelper databaseOpenHelper;
    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tok);

        databaseOpenHelper = new DatabaseOpenHelper(this);

        TknGenerator tknGenerator = new TknGenerator();
        token = tknGenerator.makeToken();

        databaseOpenHelper.insertToken(token);

        TextView tv = (TextView)findViewById(R.id.tvToken);
        tv.setText(token);

        createQRCode(token);
    }

    private void createQRCode(String token) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(token, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            ((ImageView) findViewById(R.id.qrcode2)).setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public void goTelaCentral(View view) {

        String pedido = "";
        String nomUsu = "";
        String cpfUsu = "";
        String telUsu = "";
        float valor = 0;

        try {
            valor = getIntent().getFloatExtra("valor", 0f);

            pedido = getIntent().getStringExtra("pedido");
            nomUsu = getIntent().getStringExtra("nomUsu");
            cpfUsu = getIntent().getStringExtra("cpfUsu");
            telUsu = getIntent().getStringExtra("telUsu");
        }catch (Exception e){

        }

        databaseOpenHelper.insertPedido(cpfUsu, nomUsu, telUsu, pedido, valor, token);

        Intent intent = new Intent(this, CtrlCentral.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
        finish();
    }
}
