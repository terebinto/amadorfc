package com.amadorfc.amadorfc;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PrincipalActivity extends AppCompatActivity {

    private Fragment fragment;
    private FragmentManager fragmentManager;

    private DrawerLayout mDrawerLayoutPrincipal;
    private ActionBarDrawerToggle drawerTogglePrincipal;
    private ListView mDrawerListPrincipal;
    private Toolbar toolbarPrincipal;
    ListView list;


    private int idLiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        fragment = new FragmentNoticia();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment).commit();

        mDrawerLayoutPrincipal = (DrawerLayout) findViewById(R.id.drawer_layoutPrincipal);
        mDrawerListPrincipal = (ListView) findViewById(R.id.navdrawerPrincipal);
        toolbarPrincipal = (Toolbar) findViewById(R.id.toolbarPrincipal);
        if (toolbarPrincipal != null) {
            setSupportActionBar(toolbarPrincipal);
            toolbarPrincipal.setNavigationIcon(R.drawable.ic_ab_drawer);
        }

        mDrawerListPrincipal.setBackgroundColor(getResources().getColor(R.color.black));
        toolbarPrincipal.setBackgroundColor(getResources().getColor(R.color.laranjaAmador));

        drawerTogglePrincipal = new ActionBarDrawerToggle(this, mDrawerLayoutPrincipal, toolbarPrincipal, R.string.app_name, R.string.app_name);
        mDrawerLayoutPrincipal.setDrawerListener(drawerTogglePrincipal);
        String[] values = new String[]{
                "Notícias", "Próximos Jogos", "Classificação", "Jogos Realizados", "Artilharia"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_view_padrao, android.R.id.text1, values);

        mDrawerListPrincipal.setAdapter(adapter);
        mDrawerListPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                final FragmentTransaction transaction = fragmentManager.beginTransaction();

                switch (position) {
                    case 0:
                        mDrawerLayoutPrincipal.closeDrawer(Gravity.START);

                        fragment = new FragmentNoticia();
                        fragmentManager = getSupportFragmentManager();
                        transaction.replace(R.id.main_container, fragment).commit();

                        break;
                    case 1:
                        mDrawerLayoutPrincipal.closeDrawer(Gravity.START);

                        fragment = new FragmentJogos();
                        fragmentManager = getSupportFragmentManager();
                        transaction.replace(R.id.main_container, fragment).commit();

                        break;
                    case 2:
                        mDrawerLayoutPrincipal.closeDrawer(Gravity.START);

                        fragment = new FragmentClassificacao();
                        fragmentManager = getSupportFragmentManager();
                        transaction.replace(R.id.main_container, fragment).commit();

                        break;
                    case 3:
                        mDrawerLayoutPrincipal.closeDrawer(Gravity.START);

                        fragment = new FragmentJogosRealizados();
                        fragmentManager = getSupportFragmentManager();
                        transaction.replace(R.id.main_container, fragment).commit();

                        break;

                    case 4:
                        mDrawerLayoutPrincipal.closeDrawer(Gravity.START);
                        fragment = new FragmentArtilharia();
                        fragmentManager = getSupportFragmentManager();
                        transaction.replace(R.id.main_container, fragment).commit();

                        break;
                }

            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerTogglePrincipal.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayoutPrincipal.openDrawer(Gravity.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerTogglePrincipal.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerTogglePrincipal.onConfigurationChanged(newConfig);
    }



    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public int getIdLiga() {
        return idLiga;
    }
}
