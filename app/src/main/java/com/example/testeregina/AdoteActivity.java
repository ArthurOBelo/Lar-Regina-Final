package com.example.testeregina;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdoteActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adocao);

        bottomNavigationView = findViewById(R.id.BottomNavigationView);

        // Define o item "Adote" como selecionado
        bottomNavigationView.setSelectedItemId(R.id.navadote);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.navhome) {
                startActivity(new Intent(this, HomeActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.navadote) {
                // Já está na tela de Adoção
                return true;
            } else if (id == R.id.navdoe) {
                startActivity(new Intent(this, DoacaoActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            } else if (id == R.id.navfale) {
                startActivity(new Intent(this, FaleConoscoActivity.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            return false;
        });
    }
}