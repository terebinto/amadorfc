package com.amadorfc.amadorfc.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amadorfc.amadorfc.R;
import com.amadorfc.amadorfc.model.Jogos;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListJogosAdapter extends ArrayAdapter<ProximosJogos> {


    Context context;
    int layoutResourceId;
    List<ProximosJogos> proximosJogos;
    ProximosJogos jogos;
    ListHolder holder = null;
    //Jogos data[] = null;

    public ListJogosAdapter(Context context, int layoutResourceId, List<ProximosJogos> proximosJogos) {
        super(context, layoutResourceId, proximosJogos);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.proximosJogos = proximosJogos;
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

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        jogos = proximosJogos.get(position);
        holder.mandante.setText(jogos.getNomeTime1());
        holder.visitante.setText(jogos.getNomeTime2());
        holder.estadio.setText(jogos.getLocalPartida() +" - "+ jogos.getDataPartida() +" "+ jogos.getHorarioPartida());
        //holder.logoMandante.setImageBitmap(jogos.getEscudoEquipe1().);

        return row;
    }

    static class ListHolder {
        TextView visitante;
        TextView mandante;
        TextView estadio;
        ImageView logoMandante;
    }
}