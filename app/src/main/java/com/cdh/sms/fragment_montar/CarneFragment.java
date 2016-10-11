package com.cdh.sms.fragment_montar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cdh.sms.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarneFragment extends Fragment implements AdapterView.OnItemClickListener{

    ArrayList<String> itens;

    public CarneFragment() {
        itens = new ArrayList<>();
        itens.add("Carne1");
        itens.add("Carne2");
        itens.add("Carne3");
        itens.add("Carne4");
        itens.add("Carne5");
        itens.add("Carne6");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_carne, container, false);
//
//        ListView listView = (ListView) root.findViewById(R.id.list_view);
////        listView.setOnItemClickListener(this);
//        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, itens);
//        listView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
