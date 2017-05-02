package com.amadorfc.amadorfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListNoticiaAdapter;
import com.amadorfc.amadorfc.model.Noticias;


public class FragmentNoticia extends Fragment{

    private ListView listView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment_jogos, container, false);
        Noticias weather_data[] = new Noticias[]
                {
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás"),
                        new Noticias("Robinho é desfalque: Atlético-MG pega o Tricordiano; siga aqui", "15 mitutos atrás")
                };

        ListNoticiaAdapter adapter = new ListNoticiaAdapter(getActivity(), R.layout.row_item_noticia, weather_data);

        listView1 = (ListView) v.findViewById(R.id.list);

        listView1.setAdapter(adapter);

        return v;

    }
}
