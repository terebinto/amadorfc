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
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizados;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListJogoRealizadosAdapter extends ArrayAdapter<JogosRealizados> {


    Context context;
    int layoutResourceId;
    List<JogosRealizados> jogosRealizados;
    JogosRealizados jogos;
    ListHolder holder = null;
    //Jogos data[] = null;

    public ListJogoRealizadosAdapter(Context context, int layoutResourceId, List<JogosRealizados> jogosRealizados) {
        super(context, layoutResourceId, jogosRealizados);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.jogosRealizados = jogosRealizados;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;


        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ListHolder();
            holder.mandante = (TextView) row.findViewById(R.id.name_time_mandante);
            holder.visitante = (TextView) row.findViewById(R.id.name_time_visitante);
            holder.estadio = (TextView) row.findViewById(R.id.name);
            holder.logoMandante = (ImageView) row.findViewById(R.id.image_time_mandante);
            holder.logoVisitante = (ImageView) row.findViewById(R.id.image_time_visitante);

            holder.placar1 = (TextView) row.findViewById(R.id.time_mandante_placar1);
            holder.placar2 = (TextView) row.findViewById(R.id.time_mandante_placar2);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        jogos = jogosRealizados.get(position);
        //holder.mandante.setText(jogos.getNomeTime1());
        //holder.visitante.setText(jogos.getNomeTime2());
        holder.placar1.setText(jogos.getScore1());
        holder.placar2.setText(jogos.getScore2());
        holder.estadio.setText(jogos.getLocalPartida() + " - " + jogos.getDataPartida() + " " + jogos.getHorarioPartida());

        if (jogos.getEscudoEquipe1() !=null && !jogos.getEscudoEquipe1().isEmpty()) {
            Picasso.with(context).load(jogos.getEscudoEquipe1()).placeholder(R.drawable.ball).error(R.drawable.ball).resize(80, 80).centerCrop().into(holder.logoMandante);

        }

        if (jogos.getEscudoEquipe2() !=null && !jogos.getEscudoEquipe2().isEmpty()) {
            Picasso.with(context).load(jogos.getEscudoEquipe2()).placeholder(R.drawable.ball).error(R.drawable.ball).resize(80, 80).centerCrop().into(holder.logoVisitante);
        }


        return row;
    }

    static class ListHolder {
        TextView visitante;
        TextView mandante;
        TextView estadio;
        TextView placar1;
        TextView placar2;
        ImageView logoMandante;
        ImageView logoVisitante;
    }
}