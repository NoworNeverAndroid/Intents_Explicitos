package com.example.nowor_000.intents_explicitos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity   implements View.OnClickListener{

    private static final int ID_B1 = 1;
    private static final int ID_B2 = 2;
    private static final int ID_B3 = 3;


    TextView tv1, tv2, tv3;
    Button btn1, btn2, btn3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv1 = (TextView)findViewById(R.id.texto1);
        tv2 = (TextView)findViewById(R.id.texto2);
        tv3 = (TextView)findViewById(R.id.texto3);

        btn1 = (Button)findViewById(R.id.btn01);
        btn1.setOnClickListener(this);
        btn2 = (Button)findViewById(R.id.btn02);
        btn2.setOnClickListener(this);
        btn3 = (Button)findViewById(R.id.btn03);
        btn3.setOnClickListener(this);



    }


    private void lanzarIntent(int id, int valor) {
        Intent intent = new Intent(this, SegundaActividad.class);
        intent.putExtra("valor", valor);
        startActivityForResult(intent, id);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn01:
                lanzarIntent(ID_B1, Integer.parseInt(tv1.getText().toString()));
                break;

            case R.id.btn02:
                lanzarIntent(ID_B2, Integer.parseInt(tv2.getText().toString()));
                break;

            case R.id.btn03:
                lanzarIntent(ID_B3, Integer.parseInt(tv3.getText().toString()));
                break;

        }

    }






    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch(requestCode) {
                case ID_B1:
                    actualizarTexto(data, tv1);
                    break;
                case ID_B2:
                    actualizarTexto(data, tv2);
                    break;
                case ID_B3:
                    actualizarTexto(data, tv3);
                    break;

            }
        }
    }

    private void actualizarTexto(Intent intent, TextView texto) {
        int valor = intent.getIntExtra("valor", 0);
        texto.setText(Integer.toString(valor));
    }


}
