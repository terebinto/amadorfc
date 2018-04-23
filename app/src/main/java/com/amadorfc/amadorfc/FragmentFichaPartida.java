package com.amadorfc.amadorfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.FichaPartidaAdapter;
import com.amadorfc.amadorfc.adapter.ListJogoRealizadosAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.fichaPartida.EventoPartida;
import com.amadorfc.amadorfc.rest.fichaPartida.FichaPartida;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizados;
import com.amadorfc.amadorfc.task.FichaPartidaTask;
import com.amadorfc.amadorfc.task.listener.FichaPartidaListener;
import com.amadorfc.amadorfc.task.listener.JogosRealizadosListener;
import com.bluelinelabs.logansquare.annotation.JsonField;

import java.util.ArrayList;
import java.util.List;


public class FragmentFichaPartida extends Fragment implements FichaPartidaListener {

    private ListView listView1;
    private ListView listView2;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_ficha_tecnica, container, false);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent intent = ((Activity) getContext()).getIntent();
        int idJogo = intent.getIntExtra("idJogo", 0);
        idJogo = 1458;
        new FichaPartidaTask((AmadorfcApplication) getActivity().getApplicationContext(), getActivity(), FragmentFichaPartida.this, idJogo).execute();
    }


    @Override
    public void carregarFichaPartida(FichaPartida partida) {


        List<EventoPartida> eventos = new ArrayList<>();
        eventos.addAll(partida.getInfoGol());
        eventos.addAll(partida.getInfoAmarelo());
        eventos.addAll(partida.getInfoVermelho());

        FichaPartidaAdapter adapter = new FichaPartidaAdapter(getActivity(), R.layout.row_item_ficha_tecnica, partida, eventos);
        listView1 = (ListView) v.findViewById(R.id.list);
        listView1.setAdapter(adapter);

        List<JogosRealizados> jogosRealizados = new ArrayList<>();
        JogosRealizados realizados = new JogosRealizados();
        realizados.setEscudoEquipe1(partida.getEscudoEquipe1());
        realizados.setNomeTime1(partida.getNomeEquipe1());
        realizados.setScore1(partida.getPlacar1());
        realizados.setScore2(partida.getPlacar2());
        realizados.setLocalPartida(partida.getLocal());
        realizados.setEscudoEquipe2(partida.getEscudoEquipe2());
        realizados.setDataPartida(partida.getDataPartida());
        realizados.setHorarioPartida("Ficha Técnica");

        jogosRealizados.add(realizados);


        ListJogoRealizadosAdapter adapter2 = new ListJogoRealizadosAdapter(getActivity(), R.layout.row_item_rodada_realizado,  jogosRealizados);
        listView2 = (ListView) v.findViewById(R.id.list2);
        listView2.setAdapter(adapter2);

    }
}
