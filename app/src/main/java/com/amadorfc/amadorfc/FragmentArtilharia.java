package com.amadorfc.amadorfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListArtilheirosAdapter;
import com.amadorfc.amadorfc.adapter.ListNoticiaAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.artilharia.Artilharia;
import com.amadorfc.amadorfc.rest.noticia.Noticia;
import com.amadorfc.amadorfc.task.ArtilhariaTask;
import com.amadorfc.amadorfc.task.NoticiaTask;
import com.amadorfc.amadorfc.task.listener.ArtilhariaListener;

import java.util.List;


public class FragmentArtilharia extends Fragment implements ArtilhariaListener {

    private ListView listView1;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_artilharia_jogos, container, false);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        new ArtilhariaTask((AmadorfcApplication) getActivity().getApplicationContext(), getActivity(), FragmentArtilharia.this).execute();
    }

    @Override
    public void carregarArtilharia(List<Artilharia> artilheiros) {

        ListArtilheirosAdapter adapter = new ListArtilheirosAdapter(getActivity(), R.layout.row_item_artilharia, artilheiros);
        listView1 = (ListView) v.findViewById(R.id.list);

        listView1.setAdapter(adapter);
    }
}
