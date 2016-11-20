package com.cdh.sms.tools;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import com.cdh.sms.R;
import com.cdh.sms.model.Sanduiche;

import java.util.List;

/**
 * Created by cc on 16-11-18.
 */

public class MyAdapter extends ArrayAdapter<Sanduiche> {

    public MyAdapter(Context context, int resource) {
        super(context, resource);
    }

    public MyAdapter(Context context, int resource, List<Sanduiche> items) {
        super(context, resource, items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.list_item, null);
        }

        Sanduiche sanduiche = getItem(position);


        if (sanduiche != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.id);
            TextView tt2 = (TextView) v.findViewById(R.id.categoryId);
            TextView tt3 = (TextView) v.findViewById(R.id.description);
        }

        return v;
    }
}
