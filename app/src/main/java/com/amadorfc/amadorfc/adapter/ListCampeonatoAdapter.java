package com.amadorfc.amadorfc.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amadorfc.amadorfc.R;
import com.amadorfc.amadorfc.rest.campeonato.Campeonato;

import java.util.List;

/**
 * Created by alexandre on 07/03/17.
 */

public class ListCampeonatoAdapter extends ArrayAdapter<Campeonato> {

    private final Activity context;
    private final List<Campeonato> campeonatos;
    int layoutResourceId;

    public ListCampeonatoAdapter(Activity context, int layoutResourceId, List<Campeonato> campeonatos) {

        super(context, layoutResourceId, campeonatos);
        this.context=context;
        this.layoutResourceId = layoutResourceId;
        this.campeonatos = campeonatos;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(layoutResourceId, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtNomeCampeonato);
        txtTitle.setText(campeonatos.get(position).getNomeLiga());

        return rowView;

    };
}