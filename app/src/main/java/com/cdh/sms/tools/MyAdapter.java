package com.cdh.sms.tools;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cdh.sms.model.Sanduiche;

/**
 * Created by cc on 16-11-18.
 */

public class MyAdapter extends ArrayAdapter<Sanduiche> {

    public MyAdapter(Context context, int resource) {
        super(context, resource);
    }
}
