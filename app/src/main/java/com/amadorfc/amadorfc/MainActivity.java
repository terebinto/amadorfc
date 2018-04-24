package com.amadorfc.amadorfc;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amadorfc.amadorfc.adapter.ListCampeonatoAdapter;
import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.campeonato.Campeonato;
import com.amadorfc.amadorfc.task.CampeonatoTask;
import com.amadorfc.amadorfc.task.listener.CampeonatoListener;

import java.util.List;

import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

public class MainActivity extends ActionBarActivity implements CampeonatoListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView mDrawerList;
    private Toolbar toolbar;
    ListView list;
    private List<Campeonato> campeonatos;
    AppCompatButton btn_titleMessage, btn_okCancel, btn_allCustom;


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


        //Debug.waitForDebugger();

        mDrawerList.setBackgroundColor(getResources().getColor(R.color.branco));
        toolbar.setBackgroundColor(getResources().getColor(R.color.verde900));

        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(drawerToggle);
        String[] values = new String[]{
                "Adicione seu campeonato", "Contato","Sobre o AMADOR FC"
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
                        setup_okCancelDialog("Adicione seu campeonato", "Amador FC é um aplicativo destinado aos amantes do futebol amador. Através dele é possível acompanhar com facilidade os diversos campeonatos de futebol de sua cidade. \n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Informações como notícias, tabelas de jogos, horários das próximas rodadas, resultados e artilharia dos jogos. Além disso é possível divulgar os patrocinadores de cada campeonato.");
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                    case 1:
                        setup_okCancelDialog("Contato", "contato@aterebinto.com.br");
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                    case 2:
                        setup_okCancelDialog("Amador FC Versão 1.0", "http://www.afcapp.com.br ");
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


        try {

            ListCampeonatoAdapter adapter = new ListCampeonatoAdapter(this, R.layout.row_item_campeonatos, campeonatos);
            this.setCampeonatos(campeonatos);

            if (campeonatos == null || campeonatos.size() == 0) {
                Intent intent = new Intent(getBaseContext(), ErroPadraoActivity.class);
                startActivity(intent);
            }


            list = (ListView) findViewById(R.id.list);
            list.setAdapter(adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Campeonato campeonato = getCampeonatos().get(position);
                    Intent intent = new Intent(getBaseContext(), PrincipalActivity.class);
                    intent.putExtra("idLiga", campeonato.getIdLiga());
                    intent.putExtra("categoria", campeonato.getIdCategoriaNoticia());
                    startActivity(intent);
                }
            });


            if (campeonatos == null || campeonatos.size() == 0) {
                Intent intent = new Intent(getBaseContext(), ErroPadraoActivity.class);
                startActivity(intent);
            }


        } catch (NullPointerException e) {

            Intent intent = new Intent(getBaseContext(), ErroPadraoActivity.class);
            startActivity(intent);


        }


    }


    private void setup_titleMessageDialog() {
        final PrettyDialog dialog = new PrettyDialog(this)
                .setIcon(
                        R.drawable.pdlg_icon_info,    // Icon resource
                        R.color.pdlg_color_green,      // Icon tint
                        new PrettyDialogCallback() {  // Icon OnClick listener
                            @Override
                            public void onClick() {
                                // Do what you gotta do
                            }
                        })
                .setTitle("PrettyDialog Title")
                .setMessage("PrettyDialog Message")
                .addButton(
                        "OK",
                        R.color.pdlg_color_white,
                        R.color.pdlg_color_green,
                        new PrettyDialogCallback() {
                            @Override
                            public void onClick() {
                                // Do what you gotta do
                            }
                        }
                )
                .addButton(
                        "Cancel",
                        R.color.pdlg_color_white,
                        R.color.pdlg_color_red,
                        new PrettyDialogCallback() {
                            @Override
                            public void onClick() {
                                // Dismiss
                            }
                        }
                )
                .addButton(
                        "Option 3",
                        R.color.pdlg_color_black,
                        R.color.pdlg_color_gray,
                        new PrettyDialogCallback() {
                            @Override
                            public void onClick() {
                                Toast.makeText(MainActivity.this, "I Do Nothing :)", Toast.LENGTH_SHORT).show();

                            }
                        }
                )
                .setTitle("Do you agree?")
                .setTitleColor(R.color.pdlg_color_blue)
                .setAnimationEnabled(true)
                .setMessage("By agreeing to our terms and conditions, you agree to our terms and conditions.")
                .setMessageColor(R.color.pdlg_color_gray)
                .setTypeface(Typeface.createFromAsset(getResources().getAssets(), "myfont.ttf"));
        btn_titleMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    private void setup_okCancelDialog(String title, String message) {
        final PrettyDialog dialog = new PrettyDialog(this);
        dialog
                .setTitle(title)
                .setTitleColor(R.color.pdlg_color_blue)
                .setMessage(message)
                .setIcon(R.drawable.pdlg_icon_info, R.color.pdlg_color_blue, null)
                .addButton("Fechar", R.color.pdlg_color_white, R.color.pdlg_color_green, new PrettyDialogCallback() {
                    @Override
                    public void onClick() {
                        dialog.dismiss();
                        //Toast.makeText(MainActivity.this, "OK selected", Toast.LENGTH_SHORT).show();
                    }
                });

        dialog.show();

    }

    private void setup_allCustomDialog() {
        final PrettyDialog dialog = new PrettyDialog(this);
        dialog
                .setTitle("Custom PrettyDialog")
                .setTitleColor(R.color.pdlg_color_blue)
                .setMessage("You can customize icon, buttons, button colors and text colors...")
                .setMessageColor(R.color.pdlg_color_black)
                .setTypeface(Typeface.createFromAsset(getResources().getAssets(), "myfont.ttf"))
                .setAnimationEnabled(false)
                .setIcon(R.drawable.pdlg_icon_close, R.color.pdlg_color_red, new PrettyDialogCallback() {
                    @Override
                    public void onClick() {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Close selected", Toast.LENGTH_SHORT).show();
                    }
                })
                .addButton("Option 1", R.color.pdlg_color_white, R.color.pdlg_color_blue, new PrettyDialogCallback() {
                    @Override
                    public void onClick() {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Option 1 selected", Toast.LENGTH_SHORT).show();
                    }
                })
                .addButton("Option 2", R.color.pdlg_color_black, R.color.pdlg_color_gray, new PrettyDialogCallback() {
                    @Override
                    public void onClick() {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Option 2 selected", Toast.LENGTH_SHORT).show();
                    }
                })
                .addButton("Option 3", R.color.pdlg_color_white, R.color.pdlg_color_green, new PrettyDialogCallback() {
                    @Override
                    public void onClick() {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Option 3 selected", Toast.LENGTH_SHORT).show();
                    }
                })
                .addButton("Option 4", R.color.pdlg_color_white, R.color.pdlg_color_blue, new PrettyDialogCallback() {
                    @Override
                    public void onClick() {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Option 4 selected", Toast.LENGTH_SHORT).show();
                    }
                });
        btn_allCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
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
