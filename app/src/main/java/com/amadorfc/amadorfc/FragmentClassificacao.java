package com.amadorfc.amadorfc;

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

import java.util.List;


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
        new ClassificacaoTask((AmadorfcApplication) getActivity().getApplicationContext(), getActivity(), FragmentClassificacao.this).execute();
    }

    @Override
    public void loadClassificacao(List<EquipeClassificacao> equipeClassificacao) {

        ListClassificacaoAdapter adapter = new ListClassificacaoAdapter(getActivity(),R.layout.row_item_classificacao, equipeClassificacao);

        listView1 = (ListView) v.findViewById(R.id.list);

        listView1.setAdapter(adapter);
    }
}
