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
import com.amadorfc.amadorfc.rest.apoio.Apoio;
import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.utils.CircleTransform;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListApoioAdapter extends ArrayAdapter<Apoio> {


    Context context;
    int layoutResourceId;
    List<Apoio> data = null;

    public ListApoioAdapter(Context context, int layoutResourceId, List<Apoio> data) {
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
            holder.titulo = (TextView) row.findViewById(R.id.equipe_jogador);
            holder.imagem = (ImageView) row.findViewById(R.id.image_jogador);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        Apoio apoio = data.get(position);
        holder.titulo.setText(apoio.getNomeEquipe());
        if(StringUtils.isNotEmpty(apoio.getImagem())){
            Picasso.with(context).load(apoio.getImagem()).placeholder(R.drawable.ball).error(R.drawable.ball).resize(400,400).centerCrop().transform(new CircleTransform()).into(holder.imagem);
        }else{
            holder.imagem.setImageResource(R.drawable.ball);
        }

        return row;
    }

    static class ListHolder {
        TextView titulo;
        ImageView imagem;
    }
}