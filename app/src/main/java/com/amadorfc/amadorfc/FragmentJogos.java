package com.amadorfc.amadorfc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListJogosAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.model.Jogos;
import com.amadorfc.amadorfc.rest.proximosJogos.ProximosJogos;
import com.amadorfc.amadorfc.task.CampeonatoTask;
import com.amadorfc.amadorfc.task.ProximosJogosTask;
import com.amadorfc.amadorfc.task.listener.ProximosJogosListener;

import java.util.List;


public class FragmentJogos extends Fragment implements ProximosJogosListener{

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
        new ProximosJogosTask((AmadorfcApplication) getActivity().getApplicationContext(), getActivity(), FragmentJogos.this).execute();
    }

    @Override
    public void carregarProximosJogos(List<ProximosJogos> proximosJogos) {

        ListJogosAdapter adapter = new ListJogosAdapter(getActivity(), R.layout.row_item_rodada, proximosJogos);
        listView1 = (ListView) v.findViewById(R.id.list);
        listView1.setAdapter(adapter);
    }
}
