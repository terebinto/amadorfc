package com.amadorfc.amadorfc.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amadorfc.amadorfc.R;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListNoticiaAbertaAdapter extends ArrayAdapter<Noticia> {


    Context context;
    int layoutResourceId;
    List<Noticia> data = null;

    public ListNoticiaAbertaAdapter(Context context, int layoutResourceId, List<Noticia> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        Log.i("ListNoticiaAbertaAdapte", String.valueOf(data.size()));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ListHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ListHolder();
            holder.titulo = (TextView) row.findViewById(R.id.txt_header_noticia);
            holder.hora = (TextView) row.findViewById(R.id.txt_tempo_noticia);
            holder.capa = (ImageView) row.findViewById(R.id.image_noticia);
            holder.noticia = (TextView) row.findViewById(R.id.txt_noticiaCompleta);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        Noticia noticia = data.get(position);
        holder.titulo.setText(noticia.getTitulo());
        holder.hora.setText(noticia.getDataNoticia());
        holder.noticia.setText(noticia.getNoticia());
        if (StringUtils.isNotEmpty(noticia.getImages())) {
            Picasso.with(context).load(noticia.getImages()).placeholder(R.drawable.bg_no_image).error(R.drawable.bg_no_image).resize(400, 120).centerCrop().into(holder.capa);
        } else {
            holder.capa.setImageResource(R.drawable.bg_no_image);
        }

        return row;
    }

    static class ListHolder {
        TextView titulo;
        TextView hora;
        ImageView capa;
        TextView noticia;

    }
}