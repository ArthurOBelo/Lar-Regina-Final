package com.example.testeregina;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class DoacaoActivity extends AppCompatActivity {

    private TextInputEditText editValor;
    private Button botaoGerarPix;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doacao);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        BottomNavigationView bottomNav = findViewById(R.id.BottomNavigationView);

        // Define o item "Home" como selecionado
        bottomNav.setSelectedItemId(R.id.navhome);

        // Inicializa componentes de UI
        editValor = findViewById(R.id.editValor);
        botaoGerarPix = findViewById(R.id.button);
        bottomNavigationView = findViewById(R.id.BottomNavigationView);

        // Configura botão PIX
        botaoGerarPix.setOnClickListener(v -> {
            String valor = editValor.getText().toString().trim();

            if (!valor.isEmpty()) {
                Toast.makeText(this, "Chave PIX gerada para R$ " + valor, Toast.LENGTH_LONG).show();
                // Aqui você pode adicionar a lógica para gerar o PIX de fato
            } else {
                Toast.makeText(this, "Digite um valor para gerar a chave PIX!", Toast.LENGTH_SHORT).show();
            }
        });

        // Configura navegação do BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.navhome) {
                startActivity(new Intent(this, HomeActivity.class));
                return true;
            } else if (id == R.id.navadote) {
                startActivity(new Intent(this, AdoteActivity.class));
                return true;
            } else if (id == R.id.navdoe) {
                // Já está na tela de Doação
                return true;
            } else if (id == R.id.navfale) {
                startActivity(new Intent(this, FaleConoscoActivity.class));
                return true;
            }
            return false;
        });
    }
}
