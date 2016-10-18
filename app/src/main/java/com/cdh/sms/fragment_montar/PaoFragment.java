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
public class PaoFragment extends Fragment implements AdapterView.OnItemClickListener{
    ArrayList<String> itens;

    public PaoFragment() {
        // Required empty public constructor
        itens = new ArrayList<>();
        itens.add("Sanduiche1");
        itens.add("Sanduiche2");
        itens.add("Sanduiche3");
        itens.add("Sanduiche4");
        itens.add("Sanduiche5");
        itens.add("Sanduiche6");
        itens.add("Sanduiche7");
        itens.add("Sanduiche8");
        itens.add("Sanduiche9");
        itens.add("Sanduiche10");
        itens.add("Sanduiche1");
        itens.add("Sanduiche2");
        itens.add("Sanduiche3");
        itens.add("Sanduiche4");
        itens.add("Sanduiche5");
        itens.add("Sanduiche6");
        itens.add("Sanduiche7");
        itens.add("Sanduiche8");
        itens.add("Sanduiche9");
        itens.add("Sanduiche10");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pao, container, false);

        ListView listView = (ListView) root.findViewById(R.id.list_view);
        listView.setOnItemClickListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, itens);
        listView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
