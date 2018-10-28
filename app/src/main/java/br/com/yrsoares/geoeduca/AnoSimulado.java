package br.com.yrsoares.geoeduca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnoSimulado extends AppCompatActivity {

    public static final String EXTRA_DIFFICULTY = "extraDifficulty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ano_simulado);

        Button buttonEnem = findViewById(R.id.btnEnemSimulado);
        buttonEnem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz("ENEM");
            }
        });

        Button buttonPSC1 = findViewById(R.id.btnAno1Simulado);
        buttonPSC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz("PSC1");
            }
        });

        Button buttonPSC2 = findViewById(R.id.btnAno2Simulado);
        buttonPSC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz("PSC2");
            }
        });

        Button buttonPSC3 = findViewById(R.id.btnAno3Simulado);
        buttonPSC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz("PSC3");
            }
        });
    }

    private void startQuiz(String difficulty) {
        Intent intent = new Intent(AnoSimulado.this, SImuladoActivity.class);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        startActivity(intent);
    }
}

