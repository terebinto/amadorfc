package com.amadorfc.amadorfc;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import java.lang.reflect.Field;

public class PrincipalActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private int idLiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigation.getMenu().clear();
        bottomNavigation.inflateMenu(R.menu.menu_main);

        fragment = new FragmentJogos();

        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment).commit();


        disableShiftMode(bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                fragment = null;
                fragmentManager = getSupportFragmentManager();
                int id = item.getItemId();
                switch (id) {
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

    public void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }


    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public int getIdLiga() {
        return idLiga;
    }
}
