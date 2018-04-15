package com.amadorfc.amadorfc;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.amadorfc.amadorfc.adapter.ListCampeonatoAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.task.CampeonatoTask;
import com.amadorfc.amadorfc.task.listener.CampeonatoListener;

import java.util.List;

public class MainActivity extends ActionBarActivity implements CampeonatoListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView mDrawerList;
    private Toolbar toolbar;
    ListView list;
    private List<Campeonato> campeonatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navdrawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
        }


        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(drawerToggle);
        String[] values = new String[]{
                "Sobre o AMADOR FC", "Adicione seu camponato", "Apoio", "Contato"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        mDrawerList.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                    case 1:
                        mDrawerList.setBackgroundColor(getResources().getColor(R.color.verde900));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.verde900));
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                    case 2:
                        mDrawerList.setBackgroundColor(getResources().getColor(R.color.verde900));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.verde900));
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                    case 3:
                        mDrawerList.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onResume() {
        super.onResume();
        new CampeonatoTask((AmadorfcApplication) this.getApplicationContext(), MainActivity.this, MainActivity.this).execute();
    }

    @Override
    public void carregarCampeonatos(List<Campeonato> campeonatos) {

        ListCampeonatoAdapter adapter = new ListCampeonatoAdapter(this, R.layout.row_item_campeonatos, campeonatos);
        this.setCampeonatos(campeonatos);

        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Campeonato campeonato = getCampeonatos().get(position);
                Intent intent =  new Intent(getBaseContext(), PrincipalActivity.class);
                intent.putExtra("idLiga", campeonato.getIdLiga());
                intent.putExtra("categoria", campeonato.getIdCategoriaNoticia());
                startActivity(intent);
            }
        });
    }


    public List<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(List<Campeonato> campeonatos) {
        this.campeonatos = campeonatos;
    }
}
