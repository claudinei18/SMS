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
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cdh.sms.dataBase.DatabaseOpenHelper;
import com.cdh.sms.httpRequest.CustomRequest;
import com.cdh.sms.location.AppLocationService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class CtrlDest extends AppCompatActivity implements OnMapReadyCallback {

    private DatabaseOpenHelper databaseOpenHelper;
    AppLocationService appLocationService;
    double latitudeLoja = 0, longitudeLoja = 0;

    private LatLng atual = null;
    private String meioDeLocomocao = "driving";

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
            atual = new LatLng(gpsLocation.getLatitude(), gpsLocation.getLongitude());

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
                    mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            setTimePercurse(marker.getPosition());
                            return false;
                        }
                    });

                }while(cursor.moveToNext());
            }
            cursor.close();

            atual = new LatLng(gpsLocation.getLatitude(), gpsLocation.getLongitude());


            mMap.addMarker(new MarkerOptions()
                    .position(atual)
                    .title("Voce está aqui !!!")
                    .snippet("Esta é sua localização !!!")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            Toast toast = Toast.makeText(CtrlDest.this, "Latitude: " + atual.latitude + "\nLongitude: " + atual.longitude, Toast.LENGTH_SHORT);
            toast.show();


            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(teste, 17));


        }

//        setTimePercurse();

    }

    public void setTimePercurse(LatLng loja){

        String enderecoAtual = "";
        String enderecoLoja = "";
        String cidadeAtual = "";
        String cidadeLoja = "";
        Geocoder geocoderAtual, geocoderLoja;
        List<Address> address = new ArrayList<Address>();

            try {
                geocoderAtual = new Geocoder(this, Locale.getDefault());
                geocoderLoja = new Geocoder(this, Locale.getDefault());
                address.add(geocoderAtual.getFromLocation(atual.latitude, atual.longitude, 1).get(0));
                address.add(geocoderLoja.getFromLocation(loja.latitude, loja.longitude, 1).get(0));
                enderecoAtual = address.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                enderecoLoja = address.get(1).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()



                cidadeAtual = address.get(0).getLocality(); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                cidadeLoja = address.get(1).getLocality(); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

                System.out.println("Atual: " + enderecoAtual + " " + cidadeAtual);
                System.out.println("Atual: " + enderecoLoja + " " + cidadeLoja);

//                String city = addresses.get(0).getLocality();
//                String state = addresses.get(0).getAdminArea();
//                String country = addresses.get(0).getCountryName();
//                String postalCode = addresses.get(0).getPostalCode();
//                String knownName = addresses.get(0).getFeatureName();

            } catch (IOException e) {
                e.printStackTrace();
            }


        RequestQueue queue = Volley.newRequestQueue(this);
//        String url ="https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC|Seattle&destinations=San+Francisco|Victoria+BC&mode=bicycling&language=fr-FR&key=AIzaSyCFkDm18czij6N4A8Z3bFbNmul-EU_yJvA";

//        String url ="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+ enderecoAtual.replaceAll(" ", "+") + "|" + cidadeAtual.replaceAll(" ", "+") + "|" +
//                "&destinations=" + enderecoLoja.replaceAll(" ", "+") + "|" + cidadeLoja.replaceAll(" ", "+") + "&mode=bicycling&language=pt-BR&key=AIzaSyCFkDm18czij6N4A8Z3bFbNmul-EU_yJvA";

        String url ="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+ atual.latitude + "," + atual.longitude+ "|" +
                "&destinations=" + loja.latitude + "," + loja.longitude + "&mode=" + meioDeLocomocao + "bicycling&language=pt-BR&key=AIzaSyCFkDm18czij6N4A8Z3bFbNmul-EU_yJvA";


        // POST parameters
        Map<String, String> params = new HashMap<String, String>();
//        params.put("tag", "test");

        JSONObject jsonObj = new JSONObject(params);

        final TextView tvTempo = (TextView)findViewById(R.id.tvTempo);
        final String[] tempo = new String[1];

        // Request a json response from the provided URL
        JsonObjectRequest jsonObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, jsonObj, new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try {
                            tempo[0] = response.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getString("text");
                            System.out.println("Tempo: " + tempo[0]);
                            tvTempo.setText(tempo[0]);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(getApplicationContext(), tempo[0], Toast.LENGTH_SHORT).show();
                        System.out.println("ERRO: " + response.toString());
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        System.out.println("ERRO: " + error.toString());
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(jsonObjRequest);

    }



    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb_APe:
                if (checked) {
                    Toast toast = Toast.makeText(CtrlDest.this, "Você irá até o local à pé!", Toast.LENGTH_SHORT);
                    toast.show();
                    meioDeLocomocao = "walking";
                    setTimePercurse(new LatLng(latitudeLoja, longitudeLoja));
                }
                break;
            case R.id.rb_Carro:
                if (checked) {
                    Toast toast = Toast.makeText(CtrlDest.this, "Você irá até o local dirigindo!", Toast.LENGTH_SHORT);
                    toast.show();
                    meioDeLocomocao = "driving";
                }
                break;
            case R.id.rb_TransPub:
                if (checked) {
                    Toast toast = Toast.makeText(CtrlDest.this, "Você irá até o local por Transporte Público!", Toast.LENGTH_SHORT);
                    toast.show();
                    meioDeLocomocao = "transit";
                }
                break;
        }
    }

    public void nextP(View view) {
        startActivity(new Intent(this, CtrlPag.class));
    }

}
