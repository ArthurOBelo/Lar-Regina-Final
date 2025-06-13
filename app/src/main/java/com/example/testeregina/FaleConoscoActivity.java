package com.example.testeregina;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class FaleConoscoActivity extends AppCompatActivity {

    private ImageButton buttonHome, buttonAdote, buttonDoe, buttonFale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fale_conosco);

        // Inicializa os botões de navegação
        buttonHome = findViewById(R.id.button5);  // Home
        buttonAdote = findViewById(R.id.button6); // Adote
        buttonDoe = findViewById(R.id.button7);   // Doe
        buttonFale = findViewById(R.id.button8);  // Fale Conosco

        // Destaca o botão da tela atual
        buttonFale.setAlpha(0.5f); // Opcional: suaviza o botão ativo

        // Configura os cliques
        buttonHome.setOnClickListener(v -> {
            startActivity(new Intent(this, HomeActivity.class));
            overridePendingTransition(0, 0);
            finish();
        });

        buttonAdote.setOnClickListener(v -> {
            startActivity(new Intent(this, AdoteActivity.class));
            overridePendingTransition(0, 0);
            finish();
        });

        buttonDoe.setOnClickListener(v -> {
            startActivity(new Intent(this, DoacaoActivity.class));
            overridePendingTransition(0, 0);
            finish();
        });

        buttonFale.setOnClickListener(v -> {
            // Já está na tela atual
        });
    }
}
