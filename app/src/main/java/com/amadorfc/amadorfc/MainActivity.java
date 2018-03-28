package com.amadorfc.amadorfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListCampeonatoAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.task.CampeonatoTask;
import com.amadorfc.amadorfc.task.listener.CampeonatoListener;

import java.util.List;

public class MainActivity extends Activity implements CampeonatoListener {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();
        new CampeonatoTask((AmadorfcApplication) this.getApplicationContext(), MainActivity.this, MainActivity.this).execute();
    }

    @Override
    public void carregarCampeonatos(final List<Campeonato> campeonatos) {

        ListCampeonatoAdapter adapter = new ListCampeonatoAdapter(this, R.layout.row_item_campeonatos, campeonatos);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            Campeonato campeonato = campeonatos.get(position) ;

                // create intent to start another activity
                Intent intent = new Intent(getBaseContext(), PrincipalActivity.class);
                // add the selected text item to our intent.
                intent.putExtra("idLiga", campeonato.getIdLiga());
                intent.putExtra("categoria", campeonato.getIdCategoriaNoticia());

            startActivity(intent);
            }
        });
    }


}
