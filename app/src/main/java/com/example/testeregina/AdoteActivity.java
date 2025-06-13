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
        setContentView(R.layout.adocao);  // Make sure this matches your XML filename

        bottomNavigationView = findViewById(R.id.BottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.navhome) {
                startActivity(new Intent(AdoteActivity.this, HomeActivity.class));
                return true;
            } else if (id == R.id.navadote) {
                // Already on Adote screen
                return true;
            } else if (id == R.id.navdoe) {
                startActivity(new Intent(AdoteActivity.this, DoacaoActivity.class));
                return true;
            } else if (id == R.id.navfale) {
                startActivity(new Intent(AdoteActivity.this, FaleConoscoActivity.class));
                return true;
            }
            return false;
        });
    }
}