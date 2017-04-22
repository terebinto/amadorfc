package com.amadorfc.amadorfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListAdapter;
import com.amadorfc.amadorfc.model.Jogos;


public class FragmentJogos extends Fragment {

    private ListView listView1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_fragment_jogos, container, false);
        Jogos weather_data[] = new Jogos[]
                {
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                        new Jogos("CORINTHIANS", "PALMEIRA", "ESTADIO 19:00"),
                };

        ListAdapter adapter = new ListAdapter(getActivity(),
                R.layout.row_item_rodada, weather_data);


        listView1 = (ListView) v.findViewById(R.id.list);

        listView1.setAdapter(adapter);

        return v;
    }

}
