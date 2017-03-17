package com.amadorfc.amadorfc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amadorfc.amadorfc.adapter.CustomListAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.task.CampeonatoTask;
import com.amadorfc.amadorfc.task.listener.CampeonatoListener;

import java.util.List;

public class MainActivity extends Activity implements CampeonatoListener {

    ListView list;
    String[] itemname = {
            "Campeonato Amigos da Bola ",
            "Campeonato Amador Esportivo",
    };

    Integer[] imgid = {
            R.drawable.amigos,
            R.drawable.amador
    };

    Integer[] idLiga = {1,2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CampeonatoTask mTask = new CampeonatoTask((AmadorfcApplication) this.getApplicationContext(), MainActivity.this, MainActivity.this);
        mTask.execute();

        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid,idLiga);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String Slecteditem = idLiga[+position].toString();
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public void carregarCampeonatos(List<Campeonato> campeonatos) {

        ArrayAdapter<Campeonato> array = new ArrayAdapter<Campeonato>(this, android.R.layout.simple_list_item_1, campeonatos);

    }


}
