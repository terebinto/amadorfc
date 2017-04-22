package com.amadorfc.amadorfc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amadorfc.amadorfc.R;
import com.amadorfc.amadorfc.model.Noticias;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListNoticiaAdapter extends ArrayAdapter<Noticias> {


    Context context;
    int layoutResourceId;
    Noticias data[] = null;

    public ListNoticiaAdapter(Context context, int layoutResourceId, Noticias[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ListHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ListHolder();
            holder.noticia = (TextView) row.findViewById(R.id.txt_header_noticia);
            holder.hora = (TextView) row.findViewById(R.id.txt_tempo_noticia);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        Noticias jogos = data[position];
        holder.noticia.setText(jogos.getNoticia());
        holder.hora.setText(jogos.getHora());

        return row;
    }

    static class ListHolder {
        TextView noticia;
        TextView hora;
    }
}