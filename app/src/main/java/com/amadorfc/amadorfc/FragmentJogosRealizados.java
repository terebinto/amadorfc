package com.amadorfc.amadorfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListJogoRealizadosAdapter;
import com.amadorfc.amadorfc.adapter.ListJogosAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.jogosRealizados.JogosRealizados;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;
import com.amadorfc.amadorfc.task.JogosRealizadosTask;
import com.amadorfc.amadorfc.task.ProximosJogosTask;
import com.amadorfc.amadorfc.task.listener.JogosRealizadosListener;
import com.amadorfc.amadorfc.task.listener.ProximosJogosListener;

import java.util.List;


public class FragmentJogosRealizados extends Fragment implements JogosRealizadosListener {

    private ListView listView1;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_fragment_jogos_realizados, container, false);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent intent = ((Activity) getContext()).getIntent();
        int campeonato = intent.getIntExtra("idLiga",0);
        new JogosRealizadosTask((AmadorfcApplication) getActivity().getApplicationContext(), getActivity(), FragmentJogosRealizados.this,campeonato).execute();
    }


    @Override
    public void carregarJogosRealizados(List<JogosRealizados> jogosRealizados) {
        ListJogoRealizadosAdapter adapter = new ListJogoRealizadosAdapter(getActivity(), R.layout.row_item_rodada_realizado, jogosRealizados);
        listView1 = (ListView) v.findViewById(R.id.list);
        listView1.setAdapter(adapter);
    }


}
