package com.amadorfc.amadorfc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.amadorfc.amadorfc.R;
import com.amadorfc.amadorfc.rest.fichaPartida.EventoPartida;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartida;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizados;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class FichaPartidaAdapter extends ArrayAdapter<EventoPartida> {


    Context context;
    int layoutResourceId;
    List<EventoPartida> eventos;
    FichaPartida fichaPartida;
    ListHolder holder = null;
    EventoPartida evento;
    //Jogos data[] = null;

    public FichaPartidaAdapter(Context context, int layoutResourceId, FichaPartida fichaPartida,  List<EventoPartida> eventos ) {
        super(context, layoutResourceId, eventos);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.fichaPartida = fichaPartida;
        this.eventos = eventos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;


        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ListHolder();
            holder.atleta = (TextView) row.findViewById(R.id.name_atleta_ficha);
            holder.minuto = (TextView) row.findViewById(R.id.minuto_ficha);
            holder.imagem = (ImageView) row.findViewById(R.id.image_evento_ficha);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        evento = eventos.get(position);

        holder.atleta.setText(evento.getNomeAtleta());
        holder.minuto.setText(evento.getMinuto());

        Picasso.with(context).load(evento.getImagem()).placeholder(R.drawable.ball).error(R.drawable.ball).resize(80, 80).centerCrop().into(holder.imagem);



        return row;
    }

    static class ListHolder {
        TextView atleta;
        TextView minuto;
        ImageView imagem;
    }
}