package com.amadorfc.amadorfc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amadorfc.amadorfc.R;
import com.amadorfc.amadorfc.model.Jogos;


/**
 * Created by lucas.viveiros on 17/03/2017.
 */

public class ListAdapter extends ArrayAdapter<Jogos> {


    Context context;
    int layoutResourceId;
    Jogos data[] = null;

    public ListAdapter(Context context, int layoutResourceId, Jogos[] data) {
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
            holder.mandante = (TextView) row.findViewById(R.id.name_time_mandante);
            holder.visitante = (TextView) row.findViewById(R.id.name_time_visitante);
            holder.estadio = (TextView) row.findViewById(R.id.name);

            row.setTag(holder);
        } else {
            holder = (ListHolder) row.getTag();
        }

        Jogos jogos = data[position];
        holder.mandante.setText(jogos.getMandante());
        holder.visitante.setText(jogos.getVisitante());
        holder.estadio.setText(jogos.getEstadio());

        return row;
    }

    static class ListHolder {
        TextView visitante;
        TextView mandante;
        TextView estadio;
    }
}