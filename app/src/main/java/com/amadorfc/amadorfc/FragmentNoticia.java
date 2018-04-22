package com.amadorfc.amadorfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListNoticiaAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.model.Noticias;
import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.amadorfc.amadorfc.task.NoticiaTask;
import com.amadorfc.amadorfc.task.ProximosJogosTask;
import com.amadorfc.amadorfc.task.listener.NoticiasListener;

import java.util.ArrayList;
import java.util.List;


public class FragmentNoticia extends Fragment implements NoticiasListener {

    private ListView listView1;
    View v;
    private List<Noticia> noticiasGeral;

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
        String categoria = intent.getStringExtra("categoria");
        new NoticiaTask((AmadorfcApplication) getActivity().getApplicationContext(), getActivity(), FragmentNoticia.this, Integer.valueOf(categoria)).execute();
    }

    @Override
    public void carregarNoticias(List<Noticia> noticias) {


        try {

            ListNoticiaAdapter adapter = new ListNoticiaAdapter(getActivity(), R.layout.row_item_noticia, noticias);
            listView1 = (ListView) v.findViewById(R.id.list);
            this.setNoticiasGeral(noticias);

            listView1.setAdapter(adapter);

            listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Log.i("Adicionando Noticia", String.valueOf(position));

                    Intent intent = getActivity().getIntent();
                    intent.setClass(getActivity(), NoticiaAbertaActivity.class);

                    Noticia noticia = getNoticiasGeral().get(position);
                    intent.putExtra("noticiaAlias", noticia.getAlias());
                    intent.putExtra("noticiaDataNoticia", noticia.getDataNoticia());
                    intent.putExtra("noticiaImages", noticia.getImages());
                    intent.putExtra("noticiaTitulo",  noticia.getTitulo());
                    intent.putExtra("noticiaNoticia", noticia.getNoticia());

                    Log.i("Noticia", noticia.getTitulo());




                    startActivity(intent);
                }
            });


        } catch (Exception e) {
            Intent intent = new Intent(getContext(), ErroPadraoActivity.class);
            startActivity(intent);

        }


    }

    public List<Noticia> getNoticiasGeral() {
        return noticiasGeral;
    }

    public void setNoticiasGeral(List<Noticia> noticiasGeral) {
        this.noticiasGeral = noticiasGeral;
    }
}
