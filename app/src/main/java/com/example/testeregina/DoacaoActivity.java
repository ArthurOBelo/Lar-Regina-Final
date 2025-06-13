package com.example.testeregina;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class DoacaoActivity extends AppCompatActivity {

    private TextInputEditText editValor;
    private Button botaoGerarPix;
    private ImageButton buttonHome, buttonAdote, buttonDoe, buttonFale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doacao);
        EdgeToEdge.enable(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa os botões da barra de navegação
        buttonHome = findViewById(R.id.button5);  // Home
        buttonAdote = findViewById(R.id.button6); // Adote
        buttonDoe = findViewById(R.id.button7);   // Doe
        buttonFale = findViewById(R.id.button8);  // Fale

        // Deixa o botão atual "ativado" visualmente, se quiser
        buttonDoe.setAlpha(0.5f); // Opcional: destaca o botão da tela atual

        // Lógica de navegação
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
            // Já está na tela de doação
        });

        buttonFale.setOnClickListener(v -> {
            startActivity(new Intent(this, FaleConoscoActivity.class));
            overridePendingTransition(0, 0);
            finish();
        });

        // Inicializa os campos de doação
        editValor = findViewById(R.id.editValor);
        botaoGerarPix = findViewById(R.id.button);

        botaoGerarPix.setOnClickListener(v -> {
            String valor = editValor.getText().toString().trim();

            if (!valor.isEmpty()) {
                Toast.makeText(this, "Chave PIX gerada para R$ " + valor, Toast.LENGTH_LONG).show();
                // Aqui você pode adicionar a lógica para gerar a chave PIX de verdade
            } else {
                Toast.makeText(this, "Digite um valor para gerar a chave PIX!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

