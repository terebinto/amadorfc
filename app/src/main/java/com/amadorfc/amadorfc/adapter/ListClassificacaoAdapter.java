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
import com.amadorfc.amadorfc.model.Classificacao;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListClassificacaoAdapter extends ArrayAdapter<Classificacao> {


    Context context;
    int layoutResourceId;
    Classificacao data[] = null;

    public ListClassificacaoAdapter(Context context, int layoutResourceId, Classificacao[] data) {
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

        Classificacao classificacao = data[position];
        holder.classificacao.setText(classificacao.getClassificacao());
        holder.equipe.setText(classificacao.getEquipe());
        holder.pontosGanhos.setText(classificacao.getPontosGanhos());
        holder.jogos.setText(classificacao.getJogos());
        holder.vitorias.setText(classificacao.getVitorias());
        holder.empates.setText(classificacao.getEmpates());
        holder.derrotas.setText(classificacao.getDerrotas());
        holder.golsPro.setText(classificacao.getGolsPro());
        holder.golsContra.setText(classificacao.getGolsContra());
        holder.saldoGols.setText(classificacao.getClassificacao());

        if (position == 0) {
            row.setBackgroundColor(Color.parseColor("#1b5e20"));

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