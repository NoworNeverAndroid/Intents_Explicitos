package com.example.nowor_000.intents_explicitos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SegundaActividad extends AppCompatActivity {


  private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        inicializarComponentes();

        Intent intent = getIntent();
        texto.setText(Integer.toString(intent.getIntExtra("valor", 0) + 1));


    }

    private void inicializarComponentes() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        texto = (TextView)findViewById(R.id.textoSalida);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("valor", Integer.parseInt(texto.getText().toString()));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


}
