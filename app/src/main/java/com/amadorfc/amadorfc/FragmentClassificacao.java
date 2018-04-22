package com.amadorfc.amadorfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListClassificacaoAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.equipeClassificacao.EquipeClassificacao;
import com.amadorfc.amadorfc.task.ClassificacaoTask;
import com.amadorfc.amadorfc.task.listener.ClassificacaoListener;

import java.util.ArrayList;
import java.util.List;

//
public class FragmentClassificacao extends Fragment implements ClassificacaoListener{
    private ListView listView1;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.fragment_fragment_classificacao, container, false);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent intent = ((Activity) getContext()).getIntent();
        int campeonato = intent.getIntExtra("idLiga",0);

         new ClassificacaoTask((AmadorfcApplication) getActivity().getApplicationContext(), getActivity(), FragmentClassificacao.this,campeonato).execute();
    }

    @Override
    public void loadClassificacao(List<EquipeClassificacao> equipeClassificacao) {

        List<EquipeClassificacao> listTemp = new ArrayList<EquipeClassificacao>();

        EquipeClassificacao equipeTemp = new EquipeClassificacao();
        equipeTemp.setPosicao("");
        equipeTemp.setNomeEquipe("EQUIPE");
        equipeTemp.setPoints("PG");
        equipeTemp.setPlayed("J");
        equipeTemp.setWin("V");
        equipeTemp.setDraw("E");
        equipeTemp.setLost("D");
        equipeTemp.setGoals("GP");
        equipeTemp.setGoals_conc("GC");
        equipeTemp.setGd("SG");

        listTemp.add(equipeTemp);
        listTemp.addAll(equipeClassificacao);


        ListClassificacaoAdapter adapter = new ListClassificacaoAdapter(getActivity(),R.layout.row_item_classificacao, listTemp);

        listView1 = (ListView) v.findViewById(R.id.list);

        listView1.setAdapter(adapter);
    }
}
