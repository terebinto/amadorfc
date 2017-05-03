package com.amadorfc.amadorfc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amadorfc.amadorfc.R;
import com.amadorfc.amadorfc.model.Noticias;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListNoticiaAdapter extends ArrayAdapter<Noticia> {


    Context context;
    int layoutResourceId;
    List<Noticia> data = null;

    public ListNoticiaAdapter(Context context, int layoutResourceId, List<Noticia> data) {
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
            holder.titulo = (TextView) row.findViewById(R.id.txt_header_noticia);
            holder.hora = (TextView) row.findViewById(R.id.txt_tempo_noticia);
            holder.capa = (ImageView) row.findViewById(R.id.image_noticia);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        Noticia noticia = data.get(position);
        holder.titulo.setText(noticia.getTitulo());
        holder.hora.setText(noticia.getDataNoticia());
        if(StringUtils.isNotEmpty(noticia.getImages())){
            Picasso.with(context).load(noticia.getImages()).placeholder(R.drawable.ball).error(R.drawable.ball).resize(400,120).centerCrop().into(holder.capa);
        }else{
            holder.capa.setImageResource(R.drawable.ball);
        }

        return row;
    }

    static class ListHolder {
        TextView titulo;
        TextView hora;
        ImageView capa;
    }
}