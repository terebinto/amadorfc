package com.amadorfc.amadorfc.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amadorfc.amadorfc.R;

/**
 * Created by alexandre on 07/03/17.
 */

public class  CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final Integer[] idLiga;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid, Integer[] idLiga) {

        super(context, R.layout.list_mobile, itemname);
        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.idLiga = idLiga;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_mobile, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("Description "+idLiga[position]);
        return rowView;

    };
}