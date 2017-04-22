package com.amadorfc.amadorfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListClassificacaoAdapter;
import com.amadorfc.amadorfc.model.Classificacao;


public class FragmentClassificacao extends Fragment {
    private ListView listView1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_fragment_classificacao, container, false);
        Classificacao weather_data[] = new Classificacao[]
                {
                        new Classificacao("", "CLUBES","PG","J","V","E","D","GP","GC","SG"),
                        new Classificacao("1", "CORINTHIANS","55","88","77","66","55","33","2","1"),
                        new Classificacao("2", "PALMEIRA","55","88","77","66","55","33","2","1"),
                        new Classificacao("3", "SANTOS","55","88","77","66","55","33","2","1"),
                        new Classificacao("4", "SÃO PAULO","55","88","77","66","55","33","2","1"),
                        new Classificacao("5", "COXA","55","88","77","66","55","33","2","1"),
                        new Classificacao("6", "ATLETICO","55","88","77","66","55","33","2","1"),
                        new Classificacao("7", "GOIAS","55","88","77","66","55","33","2","1"),
                        new Classificacao("8", "VITÓRIA","55","88","77","66","55","33","2","1"),
                        new Classificacao("9", "LONDRINA","55","88","77","66","55","33","2","1"),
                        new Classificacao("10", "PARANÁ","55","88","77","66","55","33","2","1"),
                };

        ListClassificacaoAdapter adapter = new ListClassificacaoAdapter(getActivity(),
                R.layout.row_item_classificacao, weather_data);

        listView1 = (ListView) v.findViewById(R.id.list);

        listView1.setAdapter(adapter);

        return v;
    }
}
