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
import com.amadorfc.amadorfc.rest.cartao.Cartao;
import com.amadorfc.amadorfc.utils.CircleTransform;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListCartoesAmarelosAdapter extends ArrayAdapter<Cartao> {


    Context context;
    int layoutResourceId;
    List<Cartao> data = null;

    public ListCartoesAmarelosAdapter(Context context, int layoutResourceId, List<Cartao> data) {
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
            holder.nomeEquipe = (TextView) row.findViewById(R.id.equipe_jogador);
            holder.nome = (TextView) row.findViewById(R.id.nome_jogador);
            holder.total = (TextView) row.findViewById(R.id.gols_jogador);
            holder.capa = (ImageView) row.findViewById(R.id.image_jogador);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        Cartao cartao = data.get(position);
        holder.nomeEquipe.setText(cartao.getNomeEquipe());
        holder.nome.setText(cartao.getNomeJogador());
        holder.total.setText(cartao.getGols());
        if (StringUtils.isNotEmpty(cartao.getImagem())) {
            Picasso.with(context).load(cartao.getImagem()).placeholder(R.drawable.bg_no_image).error(R.drawable.bg_no_image).resize(400, 400).centerCrop().transform(new CircleTransform()).into(holder.capa);
        } else {
            holder.capa.setImageResource(R.drawable.bg_no_image);
        }

        return row;
    }

    static class ListHolder {
        TextView nomeEquipe;
        TextView nome;
        TextView total;
        ImageView capa;
    }
}