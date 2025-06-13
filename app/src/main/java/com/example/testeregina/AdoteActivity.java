package com.example.testeregina;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class AdoteActivity extends AppCompatActivity {

    ImageButton buttonHome, buttonAdote, buttonDoe, buttonFale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adocao);

        // Inicializar os botões da navegação
        buttonHome = findViewById(R.id.button5);  // Home
        buttonAdote = findViewById(R.id.button6); // Adote
        buttonDoe = findViewById(R.id.button7);   // Doe
        buttonFale = findViewById(R.id.button8);  // Fale

        // Configurar ações
        buttonHome.setOnClickListener(v -> {
            startActivity(new Intent(AdoteActivity.this, HomeActivity.class));
            overridePendingTransition(0, 0);
            finish();
        });

        buttonAdote.setOnClickListener(v -> {
            // Já está na tela de adoção
        });

        buttonDoe.setOnClickListener(v -> {
            startActivity(new Intent(AdoteActivity.this, DoacaoActivity.class));
            overridePendingTransition(0, 0);
            finish();
        });

        buttonFale.setOnClickListener(v -> {
            startActivity(new Intent(AdoteActivity.this, FaleConoscoActivity.class));
            overridePendingTransition(0, 0);
            finish();
        });
    }
}
