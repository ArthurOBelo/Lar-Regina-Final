package com.example.testeregina;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FaleConoscoActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fale_conosco);

        bottomNavigationView = findViewById(R.id.BottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.navhome) {
                startActivity(new Intent(FaleConoscoActivity.this, HomeActivity.class));
                return true;
            } else if (id == R.id.navadote) {
                startActivity(new Intent(FaleConoscoActivity.this, AdoteActivity.class));
                return true;
            } else if (id == R.id.navdoe) {
                startActivity(new Intent(FaleConoscoActivity.this, DoacaoActivity.class));
                return true;
            } else if (id == R.id.navfale) {
                // Já está na tela Fale Conosco
                return true;
            }
            return false;
        });
    }
}
