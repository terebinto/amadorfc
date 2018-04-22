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

import com.amadorfc.amadorfc.adapter.ListNoticiaAbertaAdapter;
import com.amadorfc.amadorfc.adapter.ListNoticiaAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.model.Noticias;
import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.amadorfc.amadorfc.task.NoticiaAbertaTask;
import com.amadorfc.amadorfc.task.NoticiaTask;
import com.amadorfc.amadorfc.task.ProximosJogosTask;
import com.amadorfc.amadorfc.task.listener.NoticiaAbertaListener;
import com.amadorfc.amadorfc.task.listener.NoticiasListener;

import java.util.ArrayList;
import java.util.List;


public class FragmentNoticiaAberta extends Fragment  {

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
        Noticia noticia = new Noticia();

        Log.i("FragmentNoticiaAberta", intent.getStringExtra("noticiaTitulo"));

        noticia.setAlias(intent.getStringExtra("noticiaAlias"));
        noticia.setDataNoticia(intent.getStringExtra("noticiaDataNoticia"));
        noticia.setImages(intent.getStringExtra("noticiaImages"));
        noticia.setTitulo(intent.getStringExtra("noticiaTitulo"));
        noticia.setNoticia(intent.getStringExtra("noticiaNoticia"));

        this.setNoticiasGeral(new ArrayList<Noticia>());
        this.getNoticiasGeral().add(noticia);

        Log.i("getNoticiasGeral : ", String.valueOf(getNoticiasGeral().size()));


        try {

            Log.i("try : ", String.valueOf(getNoticiasGeral().size()));

            ListNoticiaAbertaAdapter adapter = new ListNoticiaAbertaAdapter(getActivity(), R.layout.row_item_noticia_aberta, this.getNoticiasGeral());
            listView1 = (ListView) v.findViewById(R.id.list);
            listView1.setAdapter(adapter);


        } catch (Exception e) {
             intent = new Intent(getContext(), ErroPadraoActivity.class);
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
