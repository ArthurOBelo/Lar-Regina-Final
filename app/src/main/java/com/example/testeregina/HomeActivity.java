package com.example.testeregina;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Recebe o nome do usuário da Intent que veio do Login
        Intent intent = getIntent();
        String nomeUsuario = intent.getStringExtra("NOME_USUARIO");

        // Encontra o TextView no layout e define a saudação
        TextView textSaudacao = findViewById(R.id.text_saudacao);
        if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
            textSaudacao.setText("Olá, " + nomeUsuario + "!");
        }

        // Lógica da barra de navegação
        BottomNavigationView bottomNav = findViewById(R.id.BottomNavigationView);
        bottomNav.setSelectedItemId(R.id.navhome);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.navhome) {
                // Já está na Home, não faz nada
                return true;
            } else if (id == R.id.navadote) {
                startActivity(new Intent(getApplicationContext(), AdoteActivity.class));
                overridePendingTransition(0, 0); // Remove animação de transição
                finish(); // Fecha a tela atual
                return true;
            } else if (id == R.id.navdoe) {
                startActivity(new Intent(getApplicationContext(), DoacaoActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.navfale) {
                startActivity(new Intent(getApplicationContext(), FaleConoscoActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            return false;
        });
    }
}