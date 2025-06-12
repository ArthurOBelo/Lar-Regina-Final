package com.example.testeregina;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // A linha 'ActivityMainBinding binding' no código Kotlin original
    // não era uma sintaxe válida e não estava sendo usada, por isso foi omitida aqui.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilita a exibição de ponta a ponta (edge-to-edge), o equivalente Java
        // da função de extensão 'enableEdgeToEdge()' do Kotlin.
        EdgeToEdge.enable(this);

        // Define o layout da Activity.
        // Os marcadores de conflito do Git foram removidos.
        setContentView(R.layout.tela_login);

    }
}

