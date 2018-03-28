package com.amadorfc.amadorfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListNoticiaAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.model.Noticias;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.amadorfc.amadorfc.task.NoticiaTask;
import com.amadorfc.amadorfc.task.ProximosJogosTask;
import com.amadorfc.amadorfc.task.listener.NoticiasListener;

import java.util.List;


public class FragmentNoticia extends Fragment implements NoticiasListener{

    private ListView listView1;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_fragment_jogos, container, false);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent intent = ((Activity) getContext()).getIntent();
        int categoria = intent.getIntExtra("categoria",0);
        new NoticiaTask((AmadorfcApplication) getActivity().getApplicationContext(), getActivity(), FragmentNoticia.this,categoria).execute();
    }

    @Override
    public void carregarNoticias(List<Noticia> noticias) {

        ListNoticiaAdapter adapter = new ListNoticiaAdapter(getActivity(), R.layout.row_item_noticia, noticias);
        listView1 = (ListView) v.findViewById(R.id.list);

        listView1.setAdapter(adapter);
    }
}
