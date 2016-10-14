package com.cdh.sms;

import android.content.Intent;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cdh.sms.dataBase.DatabaseOpenHelper;
import com.cdh.sms.location.AppLocationService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class CtrlDest extends AppCompatActivity implements OnMapReadyCallback {

    private DatabaseOpenHelper databaseOpenHelper;
    AppLocationService appLocationService;
    double latitude, longitude;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dest);

        RelativeLayout item = (RelativeLayout)findViewById(R.id.rl_map);
        View child = getLayoutInflater().inflate(R.layout.activity_maps, null);
        item.addView(child);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        databaseOpenHelper = new DatabaseOpenHelper(this);

        appLocationService = new AppLocationService(CtrlDest.this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        appLocationService = new AppLocationService(CtrlDest.this);

        Location gpsLocation = appLocationService.getLocation(LocationManager.GPS_PROVIDER);

        if (gpsLocation != null) {

            Cursor cursor = databaseOpenHelper.getLocations();
            LatLng teste = null;

            if (cursor.moveToFirst()){
                do{
                    String nome = cursor.getString(cursor.getColumnIndex("nome"));
                    String lat = cursor.getString(cursor.getColumnIndex("latitude"));
                    String longi = cursor.getString(cursor.getColumnIndex("longitude"));
                    String id = cursor.getString(cursor.getColumnIndex("_id"));

                    System.out.println("Nome: " + nome);

                    double x = Double.parseDouble(lat);
                    double y = Double.parseDouble(longi);
                    int z = Integer.parseInt(id);


                    teste = new LatLng(x, y);
                    mMap.addMarker(new MarkerOptions().position(teste).title("Loja: " + nome).snippet("Esta é uma loja !!!"));

                }while(cursor.moveToNext());
            }
            cursor.close();

            latitude = gpsLocation.getLatitude();
            longitude = gpsLocation.getLongitude();

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng( latitude, longitude))
                    .title("Voce está aqui !!!")
                    .snippet("Esta é sua localização !!!")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            Toast toast = Toast.makeText(CtrlDest.this, "Latitude: " + latitude + "\nLongitude: " + longitude, Toast.LENGTH_SHORT);
            toast.show();


            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(teste, 17));


        }

    }

    public String getAddress(){
        Geocoder geocoder;
        List<Address> addresses;

        String endereco = "";

//            try {
//                geocoder = new Geocoder(this, Locale.getDefault());
//                addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
//                endereco = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
//                String city = addresses.get(0).getLocality();
//                String state = addresses.get(0).getAdminArea();
//                String country = addresses.get(0).getCountryName();
//                String postalCode = addresses.get(0).getPostalCode();
//                String knownName = addresses.get(0).getFeatureName();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        return endereco;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_APe:
                if (checked) {
                    Toast toast = Toast.makeText(CtrlDest.this, "Você irá até o local à pé!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                    break;
            case R.id.rb_Carro:
                if (checked) {
                    Toast toast = Toast.makeText(CtrlDest.this, "Você irá até o local dirigindo!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                    break;
            case R.id.rb_TransPub:
                if (checked) {
                    Toast toast = Toast.makeText(CtrlDest.this, "Você irá até o local por Transporte Público!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                    break;
        }
    }

    public void nextP(View view) {
        startActivity(new Intent(this, CtrlPag.class));
    }

}
