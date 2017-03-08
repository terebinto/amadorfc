package com.amadorfc.amadorfc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.amadorfc.amadorfc.app.AmadorfcApplication;
import com.amadorfc.amadorfc.rest.usuario.Usuario;
import com.amadorfc.amadorfc.task.AtivaCadastroTask;
import com.amadorfc.amadorfc.task.listener.AtivaCadastroListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
            implements AtivaCadastroListener {

    private ListView lView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lView = (ListView) findViewById(R.id.listaLigas);

        AtivaCadastroTask mTask = new AtivaCadastroTask((AmadorfcApplication) this.getApplicationContext(),MainActivity.this, MainActivity.this);
        mTask.execute();

   }

    @Override

    public void ativaCadastroResposta(List<Usuario> usuarios) {

        ArrayAdapter<Usuario> arrayUsuario = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, usuarios);

        lView.setAdapter(arrayUsuario);

    }
}
