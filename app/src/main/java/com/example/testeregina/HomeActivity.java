package com.example.testeregina;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        BottomNavigationView bottomNav = findViewById(R.id.BottomNavigationView);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.navhome) {
                // Já está na Home
                return true;
            } else if (id == R.id.navadote) {
                startActivity(new Intent(this, AdoteActivity.class));
                return true;
            } else if (id == R.id.navdoe) {
                startActivity(new Intent(this, DoacaoActivity.class));
                return true;
            } else if (id == R.id.navfale) {
                startActivity(new Intent(this, FaleConoscoActivity.class));
                return true;
            }
            return false;
        });
    }
}
