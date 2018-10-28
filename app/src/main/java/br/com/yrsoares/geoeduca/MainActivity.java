package br.com.yrsoares.geoeduca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnConteudo = (Button) findViewById(R.id.btnConteudo);
        btnConteudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AnoConteudo.class);
                startActivity(intent);
            }
        });

        Button btnSimulado = (Button) findViewById(R.id.btnSimulado);
        btnSimulado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AnoSimulado.class);
                startActivity(intent);
            }
        });

    }
}
