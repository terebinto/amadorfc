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
import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListArtilheirosAdapter extends ArrayAdapter<Artilharia> {


    Context context;
    int layoutResourceId;
    List<Artilharia> data = null;

    public ListArtilheirosAdapter(Context context, int layoutResourceId, List<Artilharia> data) {
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
            //holder.
            holder.titulo = (TextView) row.findViewById(R.id.equipe_jogador);
          //  holder.hora = (TextView) row.findViewById(R.id.txt_tempo_noticia);
            holder.capa = (ImageView) row.findViewById(R.id.image_jogador);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        Artilharia artilharia = data.get(position);
        holder.titulo.setText(artilharia.getNomeEquipe());
        //holder.hora.setText(artilharia.getNomeJogador());
        if(StringUtils.isNotEmpty(artilharia.getImagem())){
            Picasso.with(context).load(artilharia.getImagem()).placeholder(R.drawable.ball).error(R.drawable.ball).resize(400,120).centerCrop().into(holder.capa);
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