package com.example.testeregina;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class DoacaoActivity extends AppCompatActivity {

    private TextInputEditText editValor;
    private Button botaoGerarPix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doacao);

        editValor = findViewById(R.id.editValor);
        botaoGerarPix = findViewById(R.id.button);

        botaoGerarPix.setOnClickListener(v -> {
            String valor = editValor.getText().toString().trim();

            if (!valor.isEmpty()) {
                Toast.makeText(this, "Chave PIX gerada para R$ " + valor, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Digite um valor para gerar a chave PIX!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
