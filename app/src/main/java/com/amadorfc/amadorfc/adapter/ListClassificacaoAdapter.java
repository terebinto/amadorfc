package com.amadorfc.amadorfc.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amadorfc.amadorfc.R;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacao;

import java.util.List;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListClassificacaoAdapter extends ArrayAdapter<EquipeClassificacao> {


    Context context;
    int layoutResourceId;
    List<EquipeClassificacao> data = null;

    public ListClassificacaoAdapter(Context context, int layoutResourceId, List<EquipeClassificacao> data) {
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

            holder.classificacao = (TextView) row.findViewById(R.id.txt_header_noticia_1);
            holder.equipe= (TextView) row.findViewById(R.id.txt_header_noticia_2);
            holder.pontosGanhos= (TextView) row.findViewById(R.id.txt_header_noticia_3);
            holder.jogos= (TextView) row.findViewById(R.id.txt_header_noticia_4);
            holder.vitorias= (TextView) row.findViewById(R.id.txt_header_noticia_5);
            holder.empates= (TextView) row.findViewById(R.id.txt_header_noticia_6);
            holder.derrotas= (TextView) row.findViewById(R.id.txt_header_noticia_7);
            holder.golsPro= (TextView) row.findViewById(R.id.txt_header_noticia_8);
            holder.golsContra= (TextView) row.findViewById(R.id.txt_header_noticia_9);
            holder.saldoGols= (TextView) row.findViewById(R.id.txt_header_noticia_10);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }


        EquipeClassificacao classificacao = data.get(position);
        holder.classificacao.setText(classificacao.getPosicao());
        holder.equipe.setText(classificacao.getNomeEquipe());
        holder.pontosGanhos.setText(classificacao.getPoints());
        holder.jogos.setText(classificacao.getPlayed());
        holder.vitorias.setText(classificacao.getWin());
        holder.empates.setText(classificacao.getDraw());
        holder.derrotas.setText(classificacao.getLost());
        holder.golsPro.setText(classificacao.getGoals());
        holder.golsContra.setText(classificacao.getGoals_conc());
        holder.saldoGols.setText(classificacao.getGd());

        if (position == 0) {
            row.setBackgroundColor(Color.parseColor("#1b5e20"));
            holder.classificacao.setTextColor(Color.parseColor("#FFFFFF"));
            holder.equipe.setTextColor(Color.parseColor("#FFFFFF"));
            holder.pontosGanhos.setTextColor(Color.parseColor("#FFFFFF"));
            holder.jogos.setTextColor(Color.parseColor("#FFFFFF"));
            holder.vitorias.setTextColor(Color.parseColor("#FFFFFF"));
            holder.empates.setTextColor(Color.parseColor("#FFFFFF"));
            holder.derrotas.setTextColor(Color.parseColor("#FFFFFF"));
            holder.golsPro.setTextColor(Color.parseColor("#FFFFFF"));
            holder.golsContra.setTextColor(Color.parseColor("#FFFFFF"));
            holder.saldoGols.setTextColor(Color.parseColor("#FFFFFF"));
    }

    if(position % 2 == 1){
        row.setBackgroundColor(Color.parseColor("#e0e0e0"));
    }

        return row;
    }

    static class ListHolder {
        TextView classificacao;
        TextView equipe;
        TextView pontosGanhos;
        TextView jogos;
        TextView vitorias;
        TextView empates;
        TextView derrotas;
        TextView golsPro;
        TextView golsContra;
        TextView saldoGols;
    }
}