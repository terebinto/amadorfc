package com.amadorfc.amadorfc;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class PrincipalActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        bottomNavigation =  (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigation.getMenu().clear();
        bottomNavigation.inflateMenu(R.menu.menu_main);
        fragment = new FragmentJogos();
        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment).commit();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                fragment = null;
                fragmentManager = getSupportFragmentManager();
                int id = item.getItemId();
                switch (id){
                    case R.id.action_jogos:
                        fragment = new FragmentJogos();
                        break;
                    case R.id.action_noticias:
                        fragment = new FragmentNoticia();
                        break;
                    case R.id.action_artilharia:
                        fragment = new FragmentArtilharia();
                        break;
                    case R.id.action_music:
                        fragment = new FragmentClassificacao();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
    }
}
