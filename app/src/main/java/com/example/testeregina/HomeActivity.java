package com.example.testeregina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    ImageButton buttonHome, buttonAdote, buttonDoe, buttonFale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Saudação
        Intent intent = getIntent();
        String nomeUsuario = intent.getStringExtra("NOME_USUARIO");

        TextView textSaudacao = findViewById(R.id.text_saudacao);
        if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
            textSaudacao.setText("Olá, " + nomeUsuario + "!");
        }

        // Inicializar botões
        buttonHome = findViewById(R.id.button5);      // Home
        buttonAdote = findViewById(R.id.button6);      // Adote
        buttonDoe = findViewById(R.id.button7);        // Doe
        buttonFale = findViewById(R.id.button8);       // Fale Conosco

        // Lógica dos botões
        buttonHome.setOnClickListener(v -> {
            // Já está na Home, então não faz nada
        });

        buttonAdote.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, AdoteActivity.class));
            overridePendingTransition(0, 0);
            finish();
        });

        buttonDoe.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, DoacaoActivity.class));
            overridePendingTransition(0, 0);
            finish();
        });

        buttonFale.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, FaleConoscoActivity.class));
            overridePendingTransition(0, 0);
            finish();
        });
    }
}
